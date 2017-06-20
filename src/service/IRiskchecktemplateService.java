package service;

import model.Riskchecktemplate;
import model.Riskchecktemplateitem;

import java.util.List;
import java.util.Set;

public interface IRiskchecktemplateService {
    int add(String name, String summary, Set<Riskchecktemplateitem> riskchecktemplateitems);
    Riskchecktemplate edit(Riskchecktemplate riskchecktemplate, String name, String summary, Set<Riskchecktemplateitem> riskchecktemplateitems);
    int addRiskchecktemplateitem(Riskchecktemplate riskchecktemplate, Riskchecktemplateitem riskchecktemplateitem);
    List<Riskchecktemplate> search(String input);
}
