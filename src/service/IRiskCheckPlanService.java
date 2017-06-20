package service;

import model.RiskCheckPlan;
import model.RiskCheckTemplate;

import java.util.List;

public interface IRiskCheckPlanService {
    RiskCheckPlan add(String name, RiskCheckTemplate riskCheckTemplate);

    void delete(RiskCheckPlan riskCheckPlan);

    RiskCheckPlan edit(RiskCheckPlan riskCheckPlan, String name);

    List<RiskCheckPlan> search(String input);
}
