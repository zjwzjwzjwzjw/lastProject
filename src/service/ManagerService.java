package service;

import entity.ComputerResumes;
import entity.ComputerTrainTable;
import entity.Dept;
import entity.Job;

import java.util.List;

/**
 * Created by user on 2018/10/15.
 */
public interface ManagerService {
    void saveDept(Dept dept);//���Ӳ���
    void delDeptByDid(Integer did);//ɾ������
    void updateDept(Dept dept);//���Ĳ���
    void saveJob(Job job);//����ְλ
    void delJobByJid(Integer jid);//ɾ��ְλ
    void updateJob(Job job);//����ְλ
    void saveComputerTrainTable(ComputerTrainTable computerTrainTable);//������ѵ��Ϣ
    void updateComputerTrainTable(ComputerTrainTable computerTrainTable);//������ѵ��Ϣ
    void delComputerTrainTable(Integer ctid);//ɾ����ѵ��Ϣ
    List<ComputerResumes> findAllComputerResumes();
    void delComputerResumesByCrid(Integer crid);//ɾ��������Ϣ
    ComputerResumes findComputerResumesByCrid(Integer crid);//���Ҽ�����Ϣ
    void updateComputerResumesByCrid(ComputerResumes computerResumes);//���¼�����Ϣ
}