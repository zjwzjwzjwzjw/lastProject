package dao;

import entity.*;

import java.util.List;

/**
 * Created by user on 2018/10/15.
 */
public interface ManagerDao extends EmploeeDao{
    void saveDept(Dept dept);//增加部门
    void delDeptByDid(Integer did);//删除部门
    void updateDept(Dept dept);//更改部门
    void saveJob(Job job);//增加职位
    void delJobByJid(Integer jid);//删除职位
    void updateJob(Job job);//更新职位
    void saveComputerTrainTable(ComputerTrainTable computerTrainTable);//发布培训信息
    void updateComputerTrainTable(ComputerTrainTable computerTrainTable);//更新培训信息
    void delComputerTrainTable(Integer ctid);//删除培训信息
    List<ComputerResumes> findAllComputerResumes();//查找所有的简历信息
    void delComputerResumesByCrid(Integer crid);//删除简历信息
    ComputerResumes findComputerResumesByCrid(Integer crid);//查找简历信息
    void updateComputerResumesByCrid(ComputerResumes computerResumes);//更新简历信息
}
