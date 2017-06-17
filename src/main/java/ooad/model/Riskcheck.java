package ooad.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Riskcheck {
    private int id;

    @Id
    @javax.persistence.Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int companyId;

    @Basic
    @javax.persistence.Column(name = "companyID", nullable = false)
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    private int riskCheckPlanId;

    @Basic
    @javax.persistence.Column(name = "riskCheckPlanID", nullable = false)
    public int getRiskCheckPlanId() {
        return riskCheckPlanId;
    }

    public void setRiskCheckPlanId(int riskCheckPlanId) {
        this.riskCheckPlanId = riskCheckPlanId;
    }

    private String startTime;

    @Basic
    @javax.persistence.Column(name = "startTime", nullable = false, length = 45)
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    private String deadline;

    @Basic
    @javax.persistence.Column(name = "deadline", nullable = false, length = 45)
    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    private String finishTime;

    @Basic
    @javax.persistence.Column(name = "finishTime", nullable = false, length = 45)
    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    private String state;

    @Basic
    @javax.persistence.Column(name = "state", nullable = false, length = 45)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Riskcheck riskcheck = (Riskcheck) o;

        if (id != riskcheck.id) return false;
        if (companyId != riskcheck.companyId) return false;
        if (riskCheckPlanId != riskcheck.riskCheckPlanId) return false;
        if (startTime != null ? !startTime.equals(riskcheck.startTime) : riskcheck.startTime != null) return false;
        if (deadline != null ? !deadline.equals(riskcheck.deadline) : riskcheck.deadline != null) return false;
        if (finishTime != null ? !finishTime.equals(riskcheck.finishTime) : riskcheck.finishTime != null) return false;
        if (state != null ? !state.equals(riskcheck.state) : riskcheck.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + companyId;
        result = 31 * result + riskCheckPlanId;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (finishTime != null ? finishTime.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
