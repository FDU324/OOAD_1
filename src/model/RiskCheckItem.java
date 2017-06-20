package model;

import common.BaseModelObject;
import common.IPersistenceManager;

import javax.persistence.*;

@Entity
@Table(name = "riskcheckitem")
public class RiskCheckItem extends BaseModelObject {
    private RiskCheck riskCheck;
    private RiskCheckTemplateItem riskCheckTemplateItem;
    private String result;

    public static RiskCheckItem create(IPersistenceManager pm, RiskCheck riskCheck, RiskCheckTemplateItem riskCheckTemplateItem, String result) {
        RiskCheckItem re = new RiskCheckItem();
        re.setRiskCheck(riskCheck);
        re.setRiskCheckTemplateItem(riskCheckTemplateItem);
        re.setResult(result);

        pm.save(re);
        return re;
    }

    @Access(AccessType.PROPERTY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "riskcheck_id", nullable = false)
    public RiskCheck getRiskCheck() {
        return riskCheck;
    }

    public void setRiskCheck(RiskCheck riskCheck) {
        this.riskCheck = riskCheck;
    }

    @Access(AccessType.PROPERTY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "riskchecktemplateItem_id", nullable = false)
    public RiskCheckTemplateItem getRiskCheckTemplateItem() {
        return riskCheckTemplateItem;
    }

    public void setRiskCheckTemplateItem(RiskCheckTemplateItem riskCheckTemplateItem) {
        this.riskCheckTemplateItem = riskCheckTemplateItem;
    }

    @Column(name = "result", nullable = true, length = 100)
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


}
