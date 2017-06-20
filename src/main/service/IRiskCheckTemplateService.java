package main.service;

import main.model.RiskCheckTemplate;
import main.model.RiskCheckTemplateItem;

import java.util.List;
import java.util.Set;

public interface IRiskCheckTemplateService {
    RiskCheckTemplate add(String name, String summary, Set<RiskCheckTemplateItem> riskCheckTemplateItems);

    RiskCheckTemplate edit(RiskCheckTemplate riskCheckTemplate, String name, String summary, Set<RiskCheckTemplateItem> riskCheckTemplateItems);

    RiskCheckTemplate addRiskCheckTemplateItem(RiskCheckTemplate riskCheckTemplate, RiskCheckTemplateItem riskCheckTemplateItem);

    List<RiskCheckTemplate> search(String input);
}
