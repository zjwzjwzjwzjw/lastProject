package handler;

import com.alibaba.fastjson.JSON;
import com.sun.deploy.net.HttpResponse;
import entity.Dept;
import entity.Job;
import entity.Resume;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import service.serviceImpl.UserServiceImpl;

import javax.servlet.http.HttpServletResponse;
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
    @RequestMapping("add")
    public String add(){
       return "regist";
    }
    @RequestMapping("addUser")
    public String addUser(String accName,String passwordA){
        userService.saveUser(accName,passwordA);
        return "forward:main.jsp";
    }
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
    @RequestMapping("login")
    public String login(String accName,String password,Model model){
        User user=userService.findUserByNameAndPassword(accName,password);
        model.addAttribute("user",user);
        return "user";
    }
    @RequestMapping("editAccount")
    public String editAccount(Integer id, Model model){
        User user=userService.findUserById(id);
        model.addAttribute("user",user);
        return "resetAccount";
    }
    @RequestMapping("registAccount")
    public String registAccount(User user, Model model){
        userService.updateUser(user);
        model.addAttribute("user",user);
        return "resetAccount";
    }
    @RequestMapping(value="findJobs",produces={"text/html;charset=UTF-8"})
    @ResponseBody
    public String findJobs(String dName, Model mode){
        Dept dept=userService.findByName(dName);
        List<Job>jobs=userService.findJobByDId(dept.getdId());
        String j = JSON.toJSONString(jobs);
        return j;
    }
    @RequestMapping("showResume")
    public String showResume(Integer id,Model model){
        List<Dept> depts=userService.findAllDept();
        List<Job>jobs=userService.findAllJob();
        Resume resume=userService.findResumeById(id);
        User user=userService.findUserById(id);
        if(resume!=null){
            model.addAttribute("resume",resume);
        }
        model.addAttribute("depts",depts);
        model.addAttribute("jobs",jobs);
        model.addAttribute("user",user);
        return "createResume";
    }
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
    @RequestMapping("sendResume")
    @ResponseBody
    public String sendResume(Integer id){
        Resume resume=userService.findResumeById(id);
        if(resume==null){//没有简历
            return "";
        }
        if(resume.getRtype()==0){//未发布
            resume.setRtype(1);
            resume.setTime(new Date());
            userService.updateResume(resume);
            return "right";
        }else{
            return "right";//已发布
        }
    }
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request){
        DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));
    }
}
