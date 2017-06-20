package main.service;

import main.common.IPersistenceManager;
import main.model.RiskCheckTemplateItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RiskCheckTemplateItemService implements IRiskCheckTemplateItemService {

    @Autowired
    IPersistenceManager persistenceManager;

    @Override
    public RiskCheckTemplateItem add(String name, String content) {
        RiskCheckTemplateItem riskCheckTemplateItem = RiskCheckTemplateItem.create(persistenceManager, name, content);
        return riskCheckTemplateItem;
    }

    @Override
    public List<RiskCheckTemplateItem> search(String input) {
        return persistenceManager.findByFussyValue(RiskCheckTemplateItem.class, input);
    }


}
