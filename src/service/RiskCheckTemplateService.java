package service;

import dao.IPersistenceManager;
import model.RiskCheckTemplate;
import model.RiskCheckTemplateItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class RiskCheckTemplateService implements IRiskCheckTemplateService {
    @Autowired
    IPersistenceManager persistenceManager;

    @Override
    public RiskCheckTemplate add(String name, String summary, Set<RiskCheckTemplateItem> riskCheckTemplateItems) {
        return RiskCheckTemplate.create(persistenceManager, name, summary, riskCheckTemplateItems);
    }

    @Override
    public RiskCheckTemplate edit(RiskCheckTemplate riskCheckTemplate, String name, String summary, Set<RiskCheckTemplateItem> riskCheckTemplateItems) {
        riskCheckTemplate.setName(name);
        riskCheckTemplate.setSummary(summary);
        riskCheckTemplate.setRiskCheckTemplateItems(riskCheckTemplateItems);
        persistenceManager.save(riskCheckTemplate);
        return riskCheckTemplate;
    }

    @Override
    public RiskCheckTemplate addRiskchecktemplateitem(RiskCheckTemplate riskCheckTemplate, RiskCheckTemplateItem riskCheckTemplateItem) {
        Set<RiskCheckTemplateItem> tem = riskCheckTemplate.getRiskCheckTemplateItems();
        tem.add(riskCheckTemplateItem);
        riskCheckTemplate.setRiskCheckTemplateItems(tem);

        persistenceManager.save(riskCheckTemplate);

        return riskCheckTemplate;
    }

    @Override
    public List<RiskCheckTemplate> search(String input) {
        return persistenceManager.findByFussyValue(RiskCheckTemplate.class, input);
    }

}
