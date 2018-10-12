package entity;

import java.util.Date;

/**
 * Created by user on 2018/10/12.
 */
public class InterviewTable extends Resume{
    private Integer iid;
    private Date iinterviewtime;//面试时间
    private String itype;//是否面试或是否录取 未面试 通知面试 去面试 录取 没录取

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
