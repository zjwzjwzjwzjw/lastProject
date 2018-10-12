package dao;

import entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by user on 2018/10/12.
 */
public interface EmploeeDao extends UserDao{
    void  saveEmploee(Emploee emploee);//����Ա��
    void updateEmploee(Emploee emploee);//����Ա��
    Emploee findEmpByUid(Integer id);//ͨ��Ա��id����Ա����Ϣ
    List<Emploee> findEmpByDname(String dname);//����ĳ���ŵ�Ա��
    List<Emploee> findEmpByDnameAndJName(@Param("dname")String dname,@Param("jname")String jname);//����ְͬλԱ��
    List<CheckWork> findCheckWorkByUid(Integer id);//�鿴����
    void saveCheckBeginTimeByUid(CheckWork checkWork);//�ϰ��
    void updateCheckAfterTimeByUid(@Param("id") Integer id,@Param("date") Date date);//�°��
    void savePublishment(Publishment publishment);//���ɽ��ͼ�¼
    List<Publishment> findPubByUid(Integer id);//�鿴�ͷ���¼
    List<Salary> findSalaryByUid(Integer id);//�鿴нˮ
    List<TrainTable> findTrainTableByUid(Integer id);//�鿴������ѵ��¼
    void updateTrainTableByTidAndUid(@Param("uid") Integer uid,@Param("tid")Integer tid);//�ı�ĳԱ������ѵ��¼״̬
    List<ChangeSalary> findChangeSalaryByUid(Integer id);
}
