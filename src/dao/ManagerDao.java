package dao;

import entity.*;

import java.util.List;

/**
 * Created by user on 2018/10/15.
 */
public interface ManagerDao extends EmploeeDao{
    void saveDept(Dept dept);//���Ӳ���
    void delDeptByDid(Integer did);//ɾ������
    void updateDept(Dept dept);//���Ĳ���
    void saveJob(Job job);//����ְλ
    void delJobByJid(Integer jid);//ɾ��ְλ
    void updateJob(Job job);//����ְλ
    void saveComputerTrainTable(ComputerTrainTable computerTrainTable);//������ѵ��Ϣ
    void updateComputerTrainTable(ComputerTrainTable computerTrainTable);//������ѵ��Ϣ
    void delComputerTrainTable(Integer ctid);//ɾ����ѵ��Ϣ
    List<ComputerResumes> findAllComputerResumes();//�������еļ�����Ϣ
    void delComputerResumesByCrid(Integer crid);//ɾ��������Ϣ
    ComputerResumes findComputerResumesByCrid(Integer crid);//���Ҽ�����Ϣ
    void updateComputerResumesByCrid(ComputerResumes computerResumes);//���¼�����Ϣ
}
