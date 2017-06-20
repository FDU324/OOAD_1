package main.service;

import main.common.IPersistenceManager;
import main.model.*;
import main.model.enums.RiskCheckState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class RiskCheckService implements IRiskCheckService {
    @Autowired
    IPersistenceManager persistenceManager;

    // 分配一次任务
    @Override
    public RiskCheck add(Company company, RiskCheckPlan riskCheckPlan, String deadline) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-ddm HH:m:ss");
        String startTime = formatter.format(new Date());
        RiskCheck riskCheck = RiskCheck.create(persistenceManager, company, riskCheckPlan, startTime, deadline, "", RiskCheckState.UNDERGOING);

        Set<RiskCheckTemplateItem> riskCheckTemplateItems = riskCheckPlan.getRiskCheckTemplate().getRiskCheckTemplateItems();
        Set<RiskCheckItem> riskCheckItems = new HashSet<RiskCheckItem>();
        for (RiskCheckTemplateItem riskCheckTemplateItem : riskCheckTemplateItems) {
            RiskCheckItem riskCheckItem = RiskCheckItem.create(persistenceManager, riskCheck, riskCheckTemplateItem, "");
            riskCheckItems.add(riskCheckItem);
        }

        riskCheck.setRiskCheckItems(riskCheckItems);


        persistenceManager.save(riskCheck);
        company.getRiskChecks().add(riskCheck);
        persistenceManager.save(company);

        return riskCheck;
    }

    @Override
    public void delete(RiskCheckPlan riskCheckPlan) {
        persistenceManager.delete(riskCheckPlan);
    }

}
