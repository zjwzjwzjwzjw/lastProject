package service;

import entity.*;

import java.util.Date;
import java.util.List;

/**
 * Created by user on 2018/10/13.
 */
public interface EmploeeService {
    void  saveEmploee(Emploee emploee);//增加员工
    void updateEmploee(Emploee emploee);//更新员工
    Emploee findEmpByUid(Integer id);//通过员工id查找员工信息
    List<Emploee> findEmpByDname(String dname);//查找某部门的员工
    List<Emploee> findEmpByDnameAndJName(String dname,String jname);//查找同职位员工
    List<CheckWork> findCheckWorkByUid(Integer id);//查看考勤
    void saveCheckBeginTimeByUid(CheckWork checkWork);//上班打卡
    void updateCheckAfterTimeByUid(Integer id,Date date);//下班打卡
    void savePublishment(Publishment publishment);//生成奖惩记录
    List<Publishment> findPubByUid(Integer id);//查看惩罚记录
    List<Salary> findSalaryByUid(Integer id);//查看薪水
    List<TrainTable> findTrainTableByUid(Integer id);//查看本人培训记录
    void updateTrainTableByTidAndUid(Integer uid,Integer tid);//改变某员工的培训记录状态
    List<ChangeSalary> findChangeSalaryByUid(Integer id);
}
