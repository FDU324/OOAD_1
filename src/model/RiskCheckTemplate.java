package model;

import dao.BaseModelObject;
import dao.IPersistenceManager;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "riskchecktemplate")
public class RiskCheckTemplate extends BaseModelObject {

    private String name;
    private String summary;
    private Set<RiskCheckTemplateItem> riskCheckTemplateItems;


    public static RiskCheckTemplate create(IPersistenceManager pm, String name, String summary, Set<RiskCheckTemplateItem> riskCheckTemplateItems) {
        RiskCheckTemplate re = new RiskCheckTemplate();
        re.setName(name);
        re.setSummary(summary);
        re.setRiskCheckTemplateItems(riskCheckTemplateItems);

        pm.save(re);
        return re;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "summary", nullable = false, length = 100)
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Access(AccessType.PROPERTY)
    @ManyToMany(cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
                }, fetch = FetchType.LAZY)
    public Set<RiskCheckTemplateItem> getRiskCheckTemplateItems() {
        return riskCheckTemplateItems;
    }

    public void setRiskCheckTemplateItems(Set<RiskCheckTemplateItem> riskCheckTemplateItems) {
        this.riskCheckTemplateItems = riskCheckTemplateItems;
    }

}
