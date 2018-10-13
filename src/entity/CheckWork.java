package entity;

import java.util.Date;

/**
 * Created by user on 2018/10/12.
 */
public class CheckWork {
    private Integer cid;//表的id
    private Integer uid;//用户id
    private Integer cmonth;//月份
    private Date cbegintime;//上班打卡时间
    private Date caftertime;//下班打卡时间
    private Integer cworkday;//已工作多少天
    private Integer cneedworkday;//需工作多少天

    public CheckWork() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCmonth() {
        return cmonth;
    }

    public void setCmonth(Integer cmonth) {
        this.cmonth = cmonth;
    }

    public Date getCbegintime() {
        return cbegintime;
    }

    public void setCbegintime(Date cbegintime) {
        this.cbegintime = cbegintime;
    }

    public Date getCaftertime() {
        return caftertime;
    }

    public void setCaftertime(Date caftertime) {
        this.caftertime = caftertime;
    }

    public Integer getCworkday() {
        return cworkday;
    }

    public void setCworkday(Integer cworkday) {
        this.cworkday = cworkday;
    }

    public Integer getCneedworkday() {
        return cneedworkday;
    }

    public void setCneedworkday(Integer cneedworkday) {
        this.cneedworkday = cneedworkday;
    }
}
