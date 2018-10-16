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
        model.addAttribute("computerResumes",list);
        return "manager/showComputerResumes";
    }
    @RequestMapping("findComputerResumes")
    @ResponseBody
    private String findComputerResumes(){
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
    private String showDetailResumes(Integer crid,Model model){
        ComputerResumes computerResumes=managerService.findComputerResumesByCrid(crid);
        computerResumes.setCrtype("已查看");
        managerService.updateComputerResumesByCrid(computerResumes);
        model.addAttribute("computerResumes",computerResumes);
        return "manager/showComputerResumes";
    }
}
