package service;

import model.Company;
import model.RiskCheckItem;
import model.enums.CompanyState;

import java.util.Set;

public interface ICompanyService {
    void finishOneCheckRiskItem(RiskCheckItem riskCheckItem, String result);

    Company add(String code, String name, CompanyState state, String organizationalCode,
                String industryGenera, String industry, String businessCategory, String contact, String contactNumber);

    void delete(Company company);

    Company edit(Company company, String code, String name, CompanyState state, String organizationalCode,
                 String industryGenera, String industry, String businessCategory, String contact, String contactNumber);

    Set<RiskCheckItem> getAllRiskcheckitem(Company company);

}
