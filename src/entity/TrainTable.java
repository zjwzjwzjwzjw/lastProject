package entity;

import java.util.Date;

/**
 * Created by user on 2018/10/12.
 */
public class TrainTable {
    private Integer tid;
    private Integer uid;
    private String context;//��ѵ����
    private Date ttime;//��ʼʱ��
    private Integer did;//����ѵ�Ĳ���id
    private Integer ttype;//�Ƿ�μ�
    private Integer needTime;//��ѵʱ��

    public TrainTable() {
    }

    public Integer getTid() {
        return tid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getTtime() {
        return ttime;
    }

    public void setTtime(Date ttime) {
        this.ttime = ttime;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getTtype() {
        return ttype;
    }

    public void setTtype(Integer ttype) {
        this.ttype = ttype;
    }

    public Integer getNeedTime() {
        return needTime;
    }

    public void setNeedTime(Integer needTime) {
        this.needTime = needTime;
    }
}
