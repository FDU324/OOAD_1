package model;

import common.BaseModelObject;
import common.IPersistenceManager;
import model.enums.RiskCheckState;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "riskcheck")
public class RiskCheck extends BaseModelObject {
    private Company company;
    private RiskCheckPlan riskCheckPlan;
    private String startTime;
    private String deadline;
    private String finishTime;
    private RiskCheckState state;
    private Set<RiskCheckItem> riskCheckItems;

    public static RiskCheck create(IPersistenceManager pm, Company company, RiskCheckPlan riskCheckPlan, String startTime,
                                   String deadline, String finishTime, RiskCheckState state) {
        RiskCheck result = new RiskCheck();
        result.setCompany(company);
        result.setRiskCheckPlan(riskCheckPlan);
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
    public RiskCheckPlan getRiskCheckPlan() {
        return riskCheckPlan;
    }

    public void setRiskCheckPlan(RiskCheckPlan riskCheckPlan) {
        this.riskCheckPlan = riskCheckPlan;
    }


    @Access(AccessType.PROPERTY)
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST
    },fetch = FetchType.LAZY)
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
    @Convert(converter = RiskCheckState.class)
    public RiskCheckState getState() {
        return state;
    }

    public void setState(RiskCheckState state) {
        this.state = state;
    }

    @Access(AccessType.PROPERTY)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<RiskCheckItem> getRiskCheckItems() {
        return riskCheckItems;
    }

    public void setRiskCheckItems(Set<RiskCheckItem> riskCheckItems) {
        this.riskCheckItems = riskCheckItems;
    }
}
