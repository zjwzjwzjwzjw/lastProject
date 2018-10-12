package entity;

import java.util.Date;

/**
 * Created by user on 2018/10/12.
 */
public class Emploee {
    private Integer uid;
    private Integer etype;
    private String ename;
    private Integer eage;
    private String eeducation;
    private String efavorite;
    private String eemail;
    private Integer etel;
    private String edept;
    private String ejob;
    private String epolicitalStatus;
    private Date ebegintime;
    private Date eaftertime;
    private String ereason;

    public Emploee() {
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getEtype() {
        return etype;
    }

    public void setEtype(Integer etype) {
        this.etype = etype;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getEage() {
        return eage;
    }

    public void setEage(Integer eage) {
        this.eage = eage;
    }

    public String getEeducation() {
        return eeducation;
    }

    public void setEeducation(String eeducation) {
        this.eeducation = eeducation;
    }

    public String getEfavorite() {
        return efavorite;
    }

    public void setEfavorite(String efavorite) {
        this.efavorite = efavorite;
    }

    public String getEemail() {
        return eemail;
    }

    public void setEemail(String eemail) {
        this.eemail = eemail;
    }

    public Integer getEtel() {
        return etel;
    }

    public void setEtel(Integer etel) {
        this.etel = etel;
    }

    public String getEdept() {
        return edept;
    }

    public void setEdept(String edept) {
        this.edept = edept;
    }

    public String getEjob() {
        return ejob;
    }

    public void setEjob(String ejob) {
        this.ejob = ejob;
    }

    public String getEpolicitalStatus() {
        return epolicitalStatus;
    }

    public void setEpolicitalStatus(String epolicitalStatus) {
        this.epolicitalStatus = epolicitalStatus;
    }

    public Date getEbegintime() {
        return ebegintime;
    }

    public void setEbegintime(Date ebegintime) {
        this.ebegintime = ebegintime;
    }

    public Date getEaftertime() {
        return eaftertime;
    }

    public void setEaftertime(Date eaftertime) {
        this.eaftertime = eaftertime;
    }

    public String getEreason() {
        return ereason;
    }

    public void setEreason(String ereason) {
        this.ereason = ereason;
    }
}
