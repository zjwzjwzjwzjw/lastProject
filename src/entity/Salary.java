package entity;

/**
 * Created by user on 2018/10/12.
 */
public class Salary {
    private Integer id;
    private Integer uid;
    private Double baseSalary;//基本工资
    private Double overTimeSalary;//加班工资
    private Double performanceSalary;//绩效工资
    private Double publishmentSalary;//奖惩金额
    private Double socical;//社保

    public Salary() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Double getOverTimeSalary() {
        return overTimeSalary;
    }

    public void setOverTimeSalary(Double overTimeSalary) {
        this.overTimeSalary = overTimeSalary;
    }

    public Double getPerformanceSalary() {
        return performanceSalary;
    }

    public void setPerformanceSalary(Double performanceSalary) {
        this.performanceSalary = performanceSalary;
    }

    public Double getPublishmentSalary() {
        return publishmentSalary;
    }

    public void setPublishmentSalary(Double publishmentSalary) {
        this.publishmentSalary = publishmentSalary;
    }

    public Double getSocical() {
        return socical;
    }

    public void setSocical(Double socical) {
        this.socical = socical;
    }
}
