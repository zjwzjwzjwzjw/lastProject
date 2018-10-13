package handler;

import com.alibaba.fastjson.JSON;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import service.serviceImpl.UserServiceImpl;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 2018/10/11.
 */
@Controller
public class UserHandler {
    @Autowired
    private UserServiceImpl userService;
    /**
     * 跳转到注册页面
     */
    @RequestMapping("add")
    public String add(){
       return "regist";
    }
    /**
     * 增加用户
     */
    @RequestMapping("addUser")
    public String addUser(String accName,String passwordA){
        userService.saveUser(accName,passwordA);
        return "forward:main.jsp";
    }
    /**
     * 检测用户名是否存在
     */
    @RequestMapping("checkUserName")
    @ResponseBody
    public String checkUserName(String name){
        User user=userService.findUserByName(name);
        if(user==null){
            return "";
        }else{
            return "right";
        }
    }
    /**
     * 检测用户与密码是否匹配
     */
    @RequestMapping("checkUser")
    @ResponseBody
    public String checkUser(String name,String password){
        User user=userService.findUserByNameAndPassword(name,password);
        if(user==null){
            return "";
        }else{
            return "right";
        }
    }
    /**
     * 跳转到个人页面
     */
    @RequestMapping("login")
    public String login(String accName, String password, HttpSession session){
        User user=userService.findUserByNameAndPassword(accName,password);
        session.setAttribute("user",user);
        return "user";
    }
    /**
     * 跳到修改账户信息页面
     */
    @RequestMapping("editAccount")
    public String editAccount(){
        return "resetAccount";
    }
    /**
     * 修改账户信息
     */
    @RequestMapping("registAccount")
    public String registAccount(User user, HttpSession session){
        userService.updateUser(user);
        session.setAttribute("user",user);
        return "resetAccount";
    }
    /**
     * 查找部门相应的职位 二级联动
     */
    @RequestMapping(value="findJobs",produces={"text/html;charset=UTF-8"})
    @ResponseBody
    public String findJobs(String dName, Model mode){
        Dept dept=userService.findByName(dName);
        List<Job>jobs=userService.findJobByDId(dept.getdId());
        String j = JSON.toJSONString(jobs);
        return j;
    }
    /**
     * 显示个人简历
     */
    @RequestMapping("showResume")
    public String showResume(Integer id,Model model){
        List<Dept> depts=userService.findAllDept();
        List<Job>jobs=userService.findAllJob();
        Resume resume=userService.findResumeById(id);
        if(resume!=null){
            model.addAttribute("resume",resume);
        }
        model.addAttribute("depts",depts);
        model.addAttribute("jobs",jobs);
        return "createResume";
    }
    /**
     * 创建简历
     */
    @RequestMapping("saveResume")
    public String saveResume(Resume resume,Integer uid){
        Resume resume1=userService.findResumeById(resume.getUid());
        if(resume1==null){
            userService.saveResume(resume);
        }else{
            resume.setRtype(0);//每次更改简历后 状态都恢复为未发布
            userService.updateResume(resume);
        }
        return "forward:showResume?id="+uid;
    }
    /**
     * 发布简历
     */
    @RequestMapping("sendResume")
    @ResponseBody
    public String sendResume(Integer id,String diff){
        Resume resume=userService.findResumeById(id);
        if(resume==null){//没有简历
            return "";
        }
        if(resume.getRtype()==0){//未发布
            if(diff!=null){//区别创建简历页面的ajax
                return "0";
            }
            resume.setRtype(1);
            resume.setTime(new Date());
            userService.updateResume(resume);
            return "1";
        }else if(resume.getRtype()==1){
            return "1";//已发布
        }else if(resume.getRtype()==2){
            return "2";//已被查看
        }else{
            if(diff!=null){//区别创建简历页面的ajax
                InterviewTable interviewTable=userService.findInterviewByUid(resume.getUid());
                if(interviewTable.getIutype()==1){
                    return "4";//用户已经查看过此面试消息
                }else{
                    return "3";//通知面试,用户未查看过
                }
            }
            InterviewTable interviewTable=userService.findInterviewByUid(resume.getUid());
            return "3";//通知面试
        }
    }
    /**
     * 跳转到显示面试信息页面
     */
    @RequestMapping("showInterview")
    public String showInterview(User user,Model model){
        InterviewTable interviewTable=userService.findInterviewByUid(user.getId());
        User user1=userService.findUserById(user.getId());
        model.addAttribute("interview",interviewTable);
        model.addAttribute("user",user1);
        return "showinterview";
    }
    /**
     * 更改面试表的状态
     */
    @RequestMapping("updateInterview")
    @ResponseBody
    public String updateInterview(String itype,Integer iid){
        InterviewTable interviewTable=userService.findInterviewByIid(iid);
        interviewTable.setIutype(1);
        if(itype!=null){
            interviewTable.setItype(itype);
        }
        userService.updateInterviewType(interviewTable);
        return "";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request){
        DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));
    }
}
