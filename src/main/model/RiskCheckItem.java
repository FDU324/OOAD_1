package main.model;

import main.common.BaseModelObject;
import main.common.IPersistenceManager;

import javax.persistence.*;

@Entity
@Table(name = "riskcheckitem")
public class RiskCheckItem extends BaseModelObject {
    private RiskCheck riskCheck;
    private String name;
    private String content;
    private String result;

    public static RiskCheckItem create(IPersistenceManager pm, RiskCheck riskCheck, RiskCheckTemplateItem riskCheckTemplateItem, String result) {
        RiskCheckItem re = new RiskCheckItem();
        re.setRiskCheck(riskCheck);
        re.setName(riskCheckTemplateItem.getName());
        re.setContent(riskCheckTemplateItem.getContent());
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

    @Column(name = "name", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "content", nullable = true, length = 100)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "result", nullable = true, length = 100)
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


}
