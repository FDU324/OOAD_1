package ooad.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@javax.persistence.Table(name = "riskcheckplan_template", schema = "ooad", catalog = "")
public class RiskcheckplanTemplate {
    private int id;

    @Id
    @javax.persistence.Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    private int riskCheckTemplateId;

    @Basic
    @javax.persistence.Column(name = "riskCheckTemplateID", nullable = false)
    public int getRiskCheckTemplateId() {
        return riskCheckTemplateId;
    }

    public void setRiskCheckTemplateId(int riskCheckTemplateId) {
        this.riskCheckTemplateId = riskCheckTemplateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RiskcheckplanTemplate that = (RiskcheckplanTemplate) o;

        if (id != that.id) return false;
        if (riskCheckPlanId != that.riskCheckPlanId) return false;
        if (riskCheckTemplateId != that.riskCheckTemplateId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + riskCheckPlanId;
        result = 31 * result + riskCheckTemplateId;
        return result;
    }
}
