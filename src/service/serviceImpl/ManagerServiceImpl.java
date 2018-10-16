package service.serviceImpl;

import dao.ManagerDao;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ManagerService;

import java.util.List;

/**
 * Created by user on 2018/10/15.
 */
@Service("managerService")
public class ManagerServiceImpl extends EmploeeServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;
    @Override
    public void saveDept(Dept dept) {
        managerDao.saveDept(dept);
    }

    @Override
    public void delDeptByDid(Integer did) {
        managerDao.delDeptByDid(did);
    }

    @Override
    public void updateDept(Dept dept) {
        managerDao.updateDept(dept);
    }

    @Override
    public void saveJob(Job job) {
        managerDao.saveJob(job);
    }

    @Override
    public void delJobByJid(Integer jid) {
        managerDao.delJobByJid(jid);
    }

    @Override
    public void updateJob(Job job) {
        managerDao.updateJob(job);
    }

    @Override
    public void saveComputerTrainTable(ComputerTrainTable computerTrainTable) {
        managerDao.saveComputerTrainTable(computerTrainTable);
    }

    @Override
    public void updateComputerTrainTable(ComputerTrainTable computerTrainTable) {
        managerDao.updateComputerTrainTable(computerTrainTable);
    }

    @Override
    public void delComputerTrainTable(Integer ctid) {
        managerDao.delComputerTrainTable(ctid);
    }

    @Override
    public List<ComputerResumes> findAllComputerResumes() {
        return managerDao.findAllComputerResumes();
    }

    @Override
    public void delComputerResumesByCrid(Integer crid) {
        managerDao.delComputerResumesByCrid(crid);
    }

    @Override
    public ComputerResumes findComputerResumesByCrid(Integer crid) {
         return managerDao.findComputerResumesByCrid(crid);
    }

    @Override
    public ComputerResumes findComputerResumesByRid(Integer rid) {
        return managerDao.findComputerResumesByRid(rid);
    }

    @Override
    public void updateComputerResumesByCrid(ComputerResumes computerResumes) {
        managerDao.updateComputerResumesByCrid(computerResumes);
    }

    @Override
    public void saveInterviewTable(ComputerResumes computerResumes) {
        managerDao.saveInterviewTable(computerResumes);
    }

    @Override
    public List<InterviewTable> findAllInterview() {
        return managerDao.findAllInterview();
    }

    @Override
    public InterviewTable findInterviewByRid(Integer rid) {
        return managerDao.findInterviewByRid(rid);
    }
}
