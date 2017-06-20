package service;

import model.Company;
import model.Riskcheckplan;
import model.Riskchecktemplateitem;

import java.util.Set;

public interface IRiskCheckService {
    int add(Company company, Riskcheckplan riskcheckplan, String deadline, Set<Riskchecktemplateitem> riskchecktemplateitems);
}
