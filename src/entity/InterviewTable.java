package entity;

import java.util.Date;

/**
 * Created by user on 2018/10/12.
 */
public class InterviewTable extends Resume{
    private Integer iid;
    private Date iinterviewtime;//面试时间
    private Integer itype;//是否面试或是否录取 0已过期 1通知面试 2预约面试 3录取 4没录取
    private Integer iutype;//是否查看过 对用户
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
