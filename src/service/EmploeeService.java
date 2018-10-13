package service;

import entity.*;

import java.util.Date;
import java.util.List;

/**
 * Created by user on 2018/10/13.
 */
public interface EmploeeService {
    void  saveEmploee(Emploee emploee);//����Ա��
    void updateEmploee(Emploee emploee);//����Ա��
    Emploee findEmpByUid(Integer id);//ͨ��Ա��id����Ա����Ϣ
    List<Emploee> findEmpByDname(String dname);//����ĳ���ŵ�Ա��
    List<Emploee> findEmpByDnameAndJName(String dname,String jname);//����ְͬλԱ��
    List<CheckWork> findCheckWorkByUid(Integer id);//�鿴����
    void saveCheckBeginTimeByUid(CheckWork checkWork);//�ϰ��
    void updateCheckAfterTimeByUid(Integer id,Date date);//�°��
    void savePublishment(Publishment publishment);//���ɽ��ͼ�¼
    List<Publishment> findPubByUid(Integer id);//�鿴�ͷ���¼
    List<Salary> findSalaryByUid(Integer id);//�鿴нˮ
    List<TrainTable> findTrainTableByUid(Integer id);//�鿴������ѵ��¼
    void updateTrainTableByTidAndUid(Integer uid,Integer tid);//�ı�ĳԱ������ѵ��¼״̬
    List<ChangeSalary> findChangeSalaryByUid(Integer id);
}
