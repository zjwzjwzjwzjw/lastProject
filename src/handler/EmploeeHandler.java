package handler;

import entity.Emploee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.serviceImpl.EmploeeServiceImpl;

/**
 * Created by user on 2018/10/13.
 */
@RequestMapping("emp")
@Controller
public class EmploeeHandler {
    @Autowired
    private EmploeeServiceImpl emploeeService;
    @RequestMapping("showEmp")
    private String showEmp(Integer id,Model model){
        Emploee  emploee=emploeeService.findEmpByUid(id);
        model.addAttribute("emploee",emploee);
        return "/emploee/showEmploee";
    }

}
