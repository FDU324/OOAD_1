package service;

import dao.IPersistenceManager;
import model.RiskCheckPlan;
import model.RiskCheckTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RiskCheckPlanService implements IRiskCheckPlanService {
    @Autowired
    IPersistenceManager persistenceManager;

    @Override
    public RiskCheckPlan add(String name, RiskCheckTemplate riskCheckTemplate) {
        return RiskCheckPlan.create(persistenceManager, name, riskCheckTemplate);
    }

    @Override
    public void delete(RiskCheckPlan riskCheckPlan) {
        persistenceManager.delete(riskCheckPlan);
    }

    @Override
    public RiskCheckPlan edit(RiskCheckPlan riskCheckPlan, String name) {
        riskCheckPlan.setName(name);
        persistenceManager.save(riskCheckPlan);
        return riskCheckPlan;
    }

    @Override
    public List<RiskCheckPlan> search(String input) {
        return persistenceManager.findByFussyValue(RiskCheckPlan.class, input);
    }

}
