package entity;

import java.util.Date;

/**
 * Created by user on 2018/10/12.
 */
public class InterviewTable extends Resume{
    private Integer iid;
    private Date iinterviewtime;//����ʱ��
    private String itype;//�Ƿ����Ի��Ƿ�¼ȡ δ���� ֪ͨ���� ȥ���� ¼ȡ û¼ȡ

    public InterviewTable() {
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Date getIinterviewtime() {
        return iinterviewtime;
    }

    public void setIinterviewtime(Date iinterviewtime) {
        this.iinterviewtime = iinterviewtime;
    }

    public String getItype() {
        return itype;
    }

    public void setItype(String itype) {
        this.itype = itype;
    }
}