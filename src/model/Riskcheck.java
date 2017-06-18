package model;

import dao.BaseModelObject;
import dao.IPersistenceManager;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "riskcheck")
public class Riskcheck extends BaseModelObject {
    private Company company;
    private Riskcheckplan riskcheckplan;
    private String startTime;
    private String deadline;
    private String finishTime;
    private String state;
    private Set<Riskcheckitem> riskcheckitems;

    public static Riskcheck create(IPersistenceManager pm, Company company, Riskcheckplan riskcheckplan, String startTime,
                                   String deadline, String finishTime, String state) {
        Riskcheck result = new Riskcheck();
        result.setCompany(company);
        result.setRiskcheckplan(riskcheckplan);
        result.setStartTime(startTime);
        result.setDeadline(deadline);
        result.setFinishTime(finishTime);
        result.setState(state);

        pm.save(result);
        return result;
    }

    @Access(AccessType.PROPERTY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "riskcheckplanid", referencedColumnName = "ID", nullable = false)
    public Riskcheckplan getRiskcheckplan() {
        return riskcheckplan;
    }

    public void setRiskcheckplan(Riskcheckplan riskcheckplan) {
        this.riskcheckplan = riskcheckplan;
    }


    @Access(AccessType.PROPERTY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyid", referencedColumnName = "ID", nullable = false)
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    @Column(name = "startTime", nullable = false, length = 45)
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Column(name = "deadline", nullable = false, length = 45)
    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Column(name = "finishTime", nullable = false, length = 45)
    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    @Column(name = "state", nullable = false, length = 45)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Access(AccessType.PROPERTY)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Riskcheckitem> getRiskcheckitems() {
        return riskcheckitems;
    }

    public void setRiskcheckitems(Set<Riskcheckitem> riskcheckitems) {
        this.riskcheckitems = riskcheckitems;
    }
}
