package service;

import entity.Dept;
import entity.Job;
import entity.Resume;
import entity.User;

import java.util.List;

/**
 * Created by user on 2018/10/11.
 */
public interface UserService {
    User findUserByNameAndPassword(String name,String password);
    User findUserByName(String name);
    User findUserById(Integer id);
    void saveUser( String name, String password);
    void updateUser(User user);
    void saveResume(Resume resume);
    void updateResume(Resume resume);
    Resume findResumeById(Integer id);
    List<Dept> findAllDept();
    Dept findByName(String name);
    List<Job> findAllJob();
    List<Job> findJobByDId(Integer dId);
}
