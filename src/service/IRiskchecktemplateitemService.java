package service;

import model.Riskchecktemplateitem;

import java.util.Set;

public interface IRiskchecktemplateitemService {
    int add(String name, String content);
    Set<Riskchecktemplateitem> search(String input);
}
