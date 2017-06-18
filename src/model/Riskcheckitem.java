package model;

import dao.BaseModelObject;
import dao.IPersistenceManager;

import javax.persistence.*;

@Entity
@Table(name = "riskcheckitem")
public class Riskcheckitem extends BaseModelObject {
    private Riskcheck riskcheck;
    private Riskchecktemplateitem riskchecktemplateitem;
    private String result;

    public static Riskcheckitem create(IPersistenceManager pm, Riskcheck riskcheck, Riskchecktemplateitem riskchecktemplateitem, String result) {
        Riskcheckitem re = new Riskcheckitem();
        re.setRiskcheck(riskcheck);
        re.setRiskchecktemplateitem(riskchecktemplateitem);
        re.setResult(result);

        pm.save(re);
        return re;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "riskcheck_id", nullable = false)
    public Riskcheck getRiskcheck() {
        return riskcheck;
    }

    public void setRiskcheck(Riskcheck riskcheck) {
        this.riskcheck = riskcheck;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "riskchecktemplateItem_id", nullable = false)
    public Riskchecktemplateitem getRiskchecktemplateitem() {
        return riskchecktemplateitem;
    }

    public void setRiskchecktemplateitem(Riskchecktemplateitem riskchecktemplateitem) {
        this.riskchecktemplateitem = riskchecktemplateitem;
    }

    @Column(name = "result", nullable = true, length = 100)
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


}
