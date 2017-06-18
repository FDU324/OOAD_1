package service;

import dao.IPersistenceManager;
import model.Company;
import model.Riskcheck;
import model.RiskcheckState;
import model.Riskcheckitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class CompanyService {
    @Autowired
    IPersistenceManager persistenceManager;

    public int finishOneCheckRiskItem(Riskcheckitem riskcheckitem, String result) {
        riskcheckitem.setResult(result);
        persistenceManager.save(riskcheckitem);

        boolean finished = true;
        Riskcheck riskcheck = riskcheckitem.getRiskcheck();
        for (Riskcheckitem riskcheckitem1 : riskcheck.getRiskcheckitems()) {
            if (riskcheckitem1.getResult().equals("")) {
                finished = false;
                break;
            }
        }

        if (finished) {
            riskcheck.setState(RiskcheckState.FINISHED.toString());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-ddm HH:m:ss");
            riskcheck.setFinishTime(formatter.format(new Date()));
            persistenceManager.save(riskcheck);
        }

        return 0;
    }

    public Set<Riskcheckitem> getAllRiskcheckitem(Company company){
        Set<Riskcheckitem> re = new HashSet<Riskcheckitem>();

        for (Riskcheck riskcheck:company.getRiskchecks()) {
            for (Riskcheckitem riskcheckitem:riskcheck.getRiskcheckitems()) {
                re.add(riskcheckitem);
            }
        }

        return re;
    }




}
