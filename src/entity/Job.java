package entity;

/**
 * Created by user on 2018/10/11.
 */
public class Job {
    private Integer jId;
    private Integer dId;//����id
    private String jName;//ְλ��

    public Job() {
    }

    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName;
    }
}
