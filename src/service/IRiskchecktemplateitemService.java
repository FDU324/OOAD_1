package service;

import model.Riskchecktemplateitem;

import java.util.List;

public interface IRiskchecktemplateitemService {
    int add(String name, String content);
    List<Riskchecktemplateitem> search(String input);
}
