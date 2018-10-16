package handler;

import com.alibaba.fastjson.JSON;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import service.serviceImpl.EmploeeServiceImpl;
import service.serviceImpl.ManagerServiceImpl;
import util.MyUtil;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 2018/10/13.
 */
@RequestMapping("man")
@Controller
public class ManagerHandler {
    @Autowired
    @Qualifier("managerService")
    private ManagerServiceImpl managerService;
    @RequestMapping("showComputerResumes")
    private String showComputerResumes(Model model){
        List<ComputerResumes> list=managerService.findAllComputerResumes();
        List<InterviewTable> list1=managerService.findAllInterview();
        List<InterviewTable> todayInterview=new ArrayList<>();
        if(list1.size()!=0){
            String nowTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            for(int i=0;i<list1.size();i++){
                String interviewTime = new SimpleDateFormat("yyyy-MM-dd").format(list1.get(i).getIinterviewtime());
                if (list1.get(i).getItype() .equals("预约面试") && nowTime.compareTo(interviewTime) == 0) {
                    todayInterview.add(list1.get(i));
                }
            }
        }
        model.addAttribute("todayInterview",todayInterview);
        model.addAttribute("computerResumes",list);
        return "manager/showComputerResumes";
    }
    @RequestMapping("findComputerResumes")
    @ResponseBody
    private String findComputerResumes() throws UnsupportedEncodingException {
        List<ComputerResumes> list=managerService.findAllComputerResumes();
        boolean flag=false;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getCrtype().equals("未查看")){
                flag=true;
            }
        }
        if(flag){
            return "yes";//存在新的简历
        }else{
            return "no";
        }
    }
    @RequestMapping("delComputerResumes")
    @ResponseBody
    private String delComputerResumes(Integer crid){
       managerService.delComputerResumesByCrid(crid);
        return "";
    }
    @RequestMapping("showDetailResumes")
    private String showDetailResumes(Integer crid,Model model) {
        ComputerResumes computerResumes = managerService.findComputerResumesByCrid(crid);
        computerResumes.setCrtype("已查看");
        managerService.updateComputerResumesByCrid(computerResumes);
        model.addAttribute("computerResumes", computerResumes);
        return "manager/showDetailResume";
    }
    @RequestMapping("tellUserInterview")
    @ResponseBody
    private String tellUserInterview(Integer crid,Date date){
        ComputerResumes computerResumes=managerService.findComputerResumesByCrid(crid);
        computerResumes.setTime(date);
        computerResumes.setCstype("通知面试");
        managerService.updateComputerResumesByCrid(computerResumes);
        managerService.saveInterviewTable(computerResumes);
        return "";
    }
    @RequestMapping("checkInterMessage")
    @ResponseBody
    private String checkInterMessage(){
        List<InterviewTable> list=managerService.findAllInterview();
        Boolean flag = false;
        if(list.size()!=0){
            for(int i=0;i<list.size();i++){
                String nowTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                String interviewTime = new SimpleDateFormat("yyyy-MM-dd").format(list.get(i).getIinterviewtime());
                if (list.get(i).getItype() .equals("预约面试") && nowTime.compareTo(interviewTime) == 0) {
                    flag = true;
                }
            }
            if(flag){
                return "yes";
            }
        }
        return "";
    }
    @RequestMapping("enterinterview")
    private String enterinterview(Integer iid,Model model) {
       InterviewTable interviewTable=managerService.findInterviewByIid(iid);
        model.addAttribute("interviewTable", interviewTable);
        return "manager/enterInterview";
    }
    @RequestMapping("success")
    @ResponseBody
    private String success(Integer uid,Integer rid,Integer iid,String diff){
        User user=managerService.findUserById(uid);
        ComputerResumes computerResumes=managerService.findComputerResumesByRid(rid);
        InterviewTable interviewTable=managerService.findInterviewByIid(iid);
        if(diff==null) {
            user.setUtype(1);
            computerResumes.setCstype("录取");
            interviewTable.setItype("录取");
            managerService.updateUser(user);
        }else{
            computerResumes.setCstype("不录取");
            interviewTable.setItype("不录取");
        }
        managerService.updateComputerResumesByCrid(computerResumes);
        managerService.updateInterviewType(interviewTable);
        return "";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request){
        DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));
    }
}
