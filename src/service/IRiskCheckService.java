package service;

import model.Company;
import model.RiskCheck;
import model.RiskCheckPlan;
import model.RiskCheckTemplateItem;

import java.util.Set;

public interface IRiskCheckService {
    RiskCheck add(Company company, RiskCheckPlan riskCheckPlan, String deadline);

    void delete(RiskCheckPlan riskCheckPlan);
}
