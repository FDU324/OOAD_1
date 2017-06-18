package service;

import model.Riskcheckplan;
import model.Riskchecktemplate;

public interface IRiskcheckplanService {
    int add(String name, Riskchecktemplate riskchecktemplate);

    Riskcheckplan search(String input);
}
