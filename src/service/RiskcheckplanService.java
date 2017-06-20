package service;

import dao.IPersistenceManager;
import model.Riskcheck;
import model.Riskcheckplan;
import model.Riskchecktemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RiskcheckplanService implements IRiskcheckplanService {
    @Autowired
    IPersistenceManager persistenceManager;

    public int add(String name, Riskchecktemplate riskchecktemplate) {
        Riskcheckplan.create(persistenceManager, name, riskchecktemplate);
        return 0;
    }

    public List<Riskcheckplan> search(String input) {
        return persistenceManager.findByFussyValue(Riskcheckplan.class, input);
    }

}
