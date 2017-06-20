package service;

import model.Riskcheckplan;
import model.Riskchecktemplate;

import java.util.List;

public interface IRiskcheckplanService {
    int add(String name, Riskchecktemplate riskchecktemplate);

    List<Riskcheckplan> search(String input);
}
