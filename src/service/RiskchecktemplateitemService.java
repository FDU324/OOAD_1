package service;

import dao.IPersistenceManager;
import model.Riskchecktemplateitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class RiskchecktemplateitemService {

    @Autowired
    IPersistenceManager persistenceManager;

    public int add(String name, String content){
        Riskchecktemplateitem.create(persistenceManager, name, content);
        return 0;
    }

    // todo
    public Set<Riskchecktemplateitem> search(String input){

        return null;
    }






}
