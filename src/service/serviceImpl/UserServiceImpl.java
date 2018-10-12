package service.serviceImpl;

import dao.UserDao;
import entity.Dept;
import entity.Job;
import entity.Resume;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.List;

/**
 * Created by user on 2018/10/11.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User findUserByNameAndPassword(String name, String password) {
        return userDao.findUserByNameAndPassword(name,password);
    }
    @Override
    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public void saveUser(String name, String password) {
        userDao.saveUser(name,password);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void saveResume(Resume resume) {
        userDao.saveResume(resume);
    }

    @Override
    public void updateResume(Resume resume) {
        userDao.updateResume(resume);
    }

    @Override
    public Resume findResumeById(Integer id) {
        return userDao.findResumeById(id);
    }

    @Override
    public List<Dept> findAllDept() {
        return userDao.findAllDept();
    }

    @Override
    public Dept findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public List<Job> findAllJob() {
        return userDao.findAllJob();
    }

    @Override
    public List<Job> findJobByDId(Integer dId) {
        return userDao.findJobByDId(dId);
    }
}
