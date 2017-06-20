package service;

import dao.IPersistenceManager;
import model.Riskchecktemplateitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RiskchecktemplateitemService implements IRiskchecktemplateitemService {

    @Autowired
    IPersistenceManager persistenceManager;

    public int add(String name, String content) {
        Riskchecktemplateitem.create(persistenceManager, name, content);
        return 0;
    }

    public List<Riskchecktemplateitem> search(String input) {
        return persistenceManager.findByFussyValue(Riskchecktemplateitem.class, input);
    }


}
