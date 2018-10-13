package service.serviceImpl;

import dao.EmploeeDao;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.EmploeeService;

import java.util.Date;
import java.util.List;

/**
 * Created by user on 2018/10/13.
 */
@Service
public class EmploeeServiceImpl implements EmploeeService{
    @Autowired
    private EmploeeDao emploeeDao;
    @Override
    public void saveEmploee(Emploee emploee) {
        emploeeDao.saveEmploee(emploee);
    }

    @Override
    public void updateEmploee(Emploee emploee) {
        emploeeDao.updateEmploee(emploee);
    }

    @Override
    public Emploee findEmpByUid(Integer id) {
        return emploeeDao.findEmpByUid(id);
    }

    @Override
    public List<Emploee> findEmpByDname(String dname) {
        return emploeeDao.findEmpByDname(dname);
    }

    @Override
    public List<Emploee> findEmpByDnameAndJName(String dname, String jname) {
        return emploeeDao.findEmpByDnameAndJName(dname,jname);
    }

    @Override
    public List<CheckWork> findCheckWorkByUid(Integer id) {
        return emploeeDao.findCheckWorkByUid(id);
    }

    @Override
    public void saveCheckBeginTimeByUid(CheckWork checkWork) {
        emploeeDao.saveCheckBeginTimeByUid(checkWork);
    }

    @Override
    public void updateCheckAfterTimeByUid(Integer id, Date date) {
        emploeeDao.updateCheckAfterTimeByUid(id,date);
    }

    @Override
    public void savePublishment(Publishment publishment) {
        emploeeDao.savePublishment(publishment);
    }

    @Override
    public List<Publishment> findPubByUid(Integer id) {
        return emploeeDao.findPubByUid(id);
    }

    @Override
    public List<Salary> findSalaryByUid(Integer id) {
        return emploeeDao.findSalaryByUid(id);
    }

    @Override
    public List<TrainTable> findTrainTableByUid(Integer id) {
        return emploeeDao.findTrainTableByUid(id);
    }

    @Override
    public void updateTrainTableByTidAndUid(Integer uid, Integer tid) {
        emploeeDao.updateTrainTableByTidAndUid(uid,tid);
    }

    @Override
    public List<ChangeSalary> findChangeSalaryByUid(Integer id) {
        return emploeeDao.findChangeSalaryByUid(id);
    }
}
