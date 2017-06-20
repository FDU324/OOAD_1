package service;

import model.Company;
import model.Riskcheckitem;

import java.util.Set;

public interface ICompanyService {
    void finishOneCheckRiskItem(Riskcheckitem riskcheckitem, String result);

    Set<Riskcheckitem> getAllRiskcheckitem(Company company);
}
