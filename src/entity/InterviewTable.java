package entity;

import java.util.Date;

/**
 * Created by user on 2018/10/12.
 */
public class InterviewTable extends Resume{
    private Integer iid;
    private Date iinterviewtime;//����ʱ��
    private Integer itype;//�Ƿ����Ի��Ƿ�¼ȡ 0�ѹ��� 1֪ͨ���� 2ԤԼ���� 3¼ȡ 4û¼ȡ
    private Integer iutype;//�Ƿ�鿴�� ���û�
    public InterviewTable() {
    }

    public Integer getIutype() {
        return iutype;
    }

    public void setIutype(Integer iutype) {
        this.iutype = iutype;
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

    public Integer getItype() {
        return itype;
    }

    public void setItype(Integer itype) {
        this.itype = itype;
    }

    @Override
    public String toString() {
        return "InterviewTable{" +
                "iid=" + iid +
                ", iinterviewtime=" + iinterviewtime +
                ", itype='" + itype + '\'' +
                ", iutype=" + iutype +
                "} " + super.toString();
    }
}
