package service;

import model.RiskCheckTemplateItem;

import java.util.List;

public interface IRiskCheckTemplateItemService {
    RiskCheckTemplateItem add(String name, String content);
    List<RiskCheckTemplateItem> search(String input);
}
