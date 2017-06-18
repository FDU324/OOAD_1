package service;

import dao.IPersistenceManager;
import model.Riskchecktemplate;
import model.Riskchecktemplateitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class RiskchecktemplateService {
    @Autowired
    IPersistenceManager persistenceManager;

    public int add(String name, String summary, Set<Riskchecktemplateitem> riskchecktemplateitems) {
        Riskchecktemplate.create(persistenceManager, name, summary, riskchecktemplateitems);
        return 0;
    }

    // delete
    public Riskchecktemplate edit(Riskchecktemplate riskchecktemplate, String name, String summary, Set<Riskchecktemplateitem> riskchecktemplateitems) {
        riskchecktemplate.setName(name);
        riskchecktemplate.setSummary(summary);
        riskchecktemplate.setRiskchecktemplateitems(riskchecktemplateitems);
        persistenceManager.save(riskchecktemplate);
        return riskchecktemplate;
    }

    public int addRiskchecktemplateitem(Riskchecktemplate riskchecktemplate, Riskchecktemplateitem riskchecktemplateitem){
        Set<Riskchecktemplateitem> tem = riskchecktemplate.getRiskchecktemplateitems();
        tem.add(riskchecktemplateitem);
        riskchecktemplate.setRiskchecktemplateitems(tem);

        persistenceManager.save(riskchecktemplate);

        return 0;
    }

    // todo
    public Set<Riskchecktemplate> search(String input){

        return null;
    }

}
