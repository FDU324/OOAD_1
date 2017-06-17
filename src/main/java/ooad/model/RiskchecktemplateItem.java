package ooad.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@javax.persistence.Table(name = "riskchecktemplate_item", schema = "ooad", catalog = "")
public class RiskchecktemplateItem {
    private int id;

    @Id
    @javax.persistence.Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    private int riskCheckTemplateItemId;

    @Basic
    @javax.persistence.Column(name = "riskCheckTemplateItemID", nullable = false)
    public int getRiskCheckTemplateItemId() {
        return riskCheckTemplateItemId;
    }

    public void setRiskCheckTemplateItemId(int riskCheckTemplateItemId) {
        this.riskCheckTemplateItemId = riskCheckTemplateItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RiskchecktemplateItem that = (RiskchecktemplateItem) o;

        if (id != that.id) return false;
        if (riskCheckTemplateId != that.riskCheckTemplateId) return false;
        if (riskCheckTemplateItemId != that.riskCheckTemplateItemId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + riskCheckTemplateId;
        result = 31 * result + riskCheckTemplateItemId;
        return result;
    }
}
