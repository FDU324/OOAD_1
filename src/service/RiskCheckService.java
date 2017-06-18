package service;

import dao.IPersistenceManager;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class RiskCheckService {
    @Autowired
    IPersistenceManager persistenceManager;

    // 分配一次任务
    public int add(Company company, Riskcheckplan riskcheckplan, String deadline, Set<Riskchecktemplateitem> riskchecktemplateitems) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-ddm HH:m:ss");
        String startTime = formatter.format(new Date());
        Riskcheck riskcheck = Riskcheck.create(persistenceManager, company, riskcheckplan, startTime, deadline, "", RiskcheckState.UNDERGOING.toString());

        Set<Riskcheckitem> riskcheckitems = new HashSet<Riskcheckitem>();
        for (Riskchecktemplateitem riskchecktemplateitem : riskchecktemplateitems) {
            Riskcheckitem riskcheckitem = Riskcheckitem.create(persistenceManager, riskcheck, riskchecktemplateitem, "");
            riskcheckitems.add(riskcheckitem);
        }

        riskcheck.setRiskcheckitems(riskcheckitems);
        persistenceManager.save(riskcheck);

        return 0;
    }

}
