package main.service;

import main.model.Company;
import main.model.RiskCheck;
import main.model.RiskCheckPlan;

public interface IRiskCheckService {
    RiskCheck add(Company company, RiskCheckPlan riskCheckPlan, String deadline);

    void delete(RiskCheckPlan riskCheckPlan);
}
