package model;

import dao.BaseModelObject;
import dao.IPersistenceManager;

import javax.persistence.*;

@Entity
@Table(name = "riskcheckplan")
public class Riskcheckplan extends BaseModelObject {
    private String name;
    private Riskchecktemplate riskchecktemplate;

    public static Riskcheckplan create(IPersistenceManager pm, String name, Riskchecktemplate riskchecktemplate) {
        Riskcheckplan re = new Riskcheckplan();
        re.setName(name);
        re.setRiskchecktemplate(riskchecktemplate);

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
    public Riskchecktemplate getRiskchecktemplate() {
        return riskchecktemplate;
    }

    public void setRiskchecktemplate(Riskchecktemplate riskchecktemplate) {
        this.riskchecktemplate = riskchecktemplate;
    }
}
