package service;

import dao.IPersistenceManager;
import model.Company;
import model.RiskCheck;
import model.enums.CompanyState;
import model.enums.RiskCheckState;
import model.RiskCheckItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class CompanyService implements ICompanyService {
    @Autowired
    IPersistenceManager persistenceManager;

    @Override
    public void finishOneCheckRiskItem(RiskCheckItem riskCheckItem, String result) {
        riskCheckItem.setResult(result);
        persistenceManager.save(riskCheckItem);

        boolean finished = true;
        RiskCheck riskCheck = riskCheckItem.getRiskCheck();
        for (RiskCheckItem riskCheckItem1 : riskCheck.getRiskCheckItems()) {
            if (riskCheckItem1.getResult().equals("")) {
                finished = false;
                break;
            }
        }

        if (finished) {
            riskCheck.setState(RiskCheckState.FINISHED);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-ddm HH:m:ss");
            riskCheck.setFinishTime(formatter.format(new Date()));
            persistenceManager.save(riskCheck);
        }

    }

    @Override
    public Company add(String code, String name, CompanyState state, String organizationalCode,
                       String industryGenera, String industry, String businessCategory, String contact, String contactNumber) {
        return Company.create(persistenceManager, code, name, state, organizationalCode, industryGenera, industry, businessCategory, contact, contactNumber);
    }

    @Override
    public void delete(Company company) {
        persistenceManager.delete(company);
    }

    @Override
    public Company edit(Company company, String code, String name, CompanyState state, String organizationalCode, String industryGenera, String industry, String businessCategory, String contact, String contactNumber) {
        company.setCode(code);
        company.setName(name);
        company.setState(state);
        company.setOrganizationalCode(organizationalCode);
        company.setIndustryGenera(industryGenera);
        company.setIndustry(industry);
        company.setBusinessCategory(businessCategory);
        company.setContact(contact);
        company.setContactNumber(contactNumber);
        persistenceManager.save(company);

        return company;
    }

    @Override
    public Set<RiskCheckItem> getAllRiskcheckitem(Company company) {
        Set<RiskCheckItem> re = new HashSet<RiskCheckItem>();

        for (RiskCheck riskCheck : company.getRiskChecks()) {
            for (RiskCheckItem riskCheckItem : riskCheck.getRiskCheckItems()) {
                re.add(riskCheckItem);
            }
        }

        return re;
    }


}
