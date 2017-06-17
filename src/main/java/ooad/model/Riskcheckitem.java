package ooad.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Riskcheckitem {
    private int id;

    @Id
    @javax.persistence.Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int riskCheckId;

    @Basic
    @javax.persistence.Column(name = "riskCheckID", nullable = false)
    public int getRiskCheckId() {
        return riskCheckId;
    }

    public void setRiskCheckId(int riskCheckId) {
        this.riskCheckId = riskCheckId;
    }

    private int riskCheckTemplateItemId;

    @Basic
    @javax.persistence.Column(name = "riskCheckTemplateItemID", nullable = false)
    public int getRiskCheckTemplateItemId() {
        return riskCheckTemplateItemId;
    }

    public void setRiskCheckTemplateItemId(int riskCheckTemplateItemId) {
        this.riskCheckTemplateItemId = riskCheckTemplateItemId;
    }

    private String result;

    @Basic
    @javax.persistence.Column(name = "result", nullable = true, length = 100)
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Riskcheckitem that = (Riskcheckitem) o;

        if (id != that.id) return false;
        if (riskCheckId != that.riskCheckId) return false;
        if (riskCheckTemplateItemId != that.riskCheckTemplateItemId) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = id;
        result1 = 31 * result1 + riskCheckId;
        result1 = 31 * result1 + riskCheckTemplateItemId;
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }
}
