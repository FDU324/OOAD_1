package model;

import common.BaseModelObject;
import common.IPersistenceManager;

import javax.persistence.*;

@Entity
@Table(name = "riskcheckplan")
public class RiskCheckPlan extends BaseModelObject {
    private String name;
    private RiskCheckTemplate riskCheckTemplate;

    public static RiskCheckPlan create(IPersistenceManager pm, String name, RiskCheckTemplate riskCheckTemplate) {
        RiskCheckPlan re = new RiskCheckPlan();
        re.setName(name);
        re.setRiskCheckTemplate(riskCheckTemplate);

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


    @Access(AccessType.PROPERTY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "riskchecktemplate_id", nullable = false)
    public RiskCheckTemplate getRiskCheckTemplate() {
        return riskCheckTemplate;
    }

    public void setRiskCheckTemplate(RiskCheckTemplate riskCheckTemplate) {
        this.riskCheckTemplate = riskCheckTemplate;
    }
}
