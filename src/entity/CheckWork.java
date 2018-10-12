package entity;

import java.util.Date;

/**
 * Created by user on 2018/10/12.
 */
public class CheckWork {
    private Integer cid;
    private Integer uid;
    private Integer cmonth;
    private Date cbegintime;
    private Date caftertime;
    private Integer cworkday;
    private Integer cneedworkday;

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
