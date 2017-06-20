package service;

import model.RiskCheckTemplate;
import model.RiskCheckTemplateItem;

import java.util.List;
import java.util.Set;

public interface IRiskCheckTemplateService {
    RiskCheckTemplate add(String name, String summary, Set<RiskCheckTemplateItem> riskCheckTemplateItems);

    RiskCheckTemplate edit(RiskCheckTemplate riskCheckTemplate, String name, String summary, Set<RiskCheckTemplateItem> riskCheckTemplateItems);

    RiskCheckTemplate addRiskchecktemplateitem(RiskCheckTemplate riskCheckTemplate, RiskCheckTemplateItem riskCheckTemplateItem);

    List<RiskCheckTemplate> search(String input);
}
