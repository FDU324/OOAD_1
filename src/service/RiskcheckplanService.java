package service;

import dao.IPersistenceManager;
import model.Riskcheckplan;
import model.Riskchecktemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RiskcheckplanService {
    @Autowired
    IPersistenceManager persistenceManager;

    public int add(String name, Riskchecktemplate riskchecktemplate) {
        Riskcheckplan.create(persistenceManager, name, riskchecktemplate);
        return 0;
    }

    // todo
    public Riskcheckplan search(String input) {


        return null;
    }

}
