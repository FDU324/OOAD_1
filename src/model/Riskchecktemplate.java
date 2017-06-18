package model;

import dao.BaseModelObject;
import dao.IPersistenceManager;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "riskchecktemplate")
public class Riskchecktemplate extends BaseModelObject {

    private String name;
    private String summary;
    private List<Riskchecktemplateitem> riskchecktemplateitems;


    public static Riskchecktemplate create(IPersistenceManager pm, String name, String summary, List<Riskchecktemplateitem> riskchecktemplateitems) {
        Riskchecktemplate re = new Riskchecktemplate();
        re.setName(name);
        re.setSummary(summary);
        re.setRiskchecktemplateitems(riskchecktemplateitems);

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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Riskchecktemplateitem> getRiskchecktemplateitems() {
        return riskchecktemplateitems;
    }

    public void setRiskchecktemplateitems(List<Riskchecktemplateitem> riskchecktemplateitems) {
        this.riskchecktemplateitems = riskchecktemplateitems;
    }

}
