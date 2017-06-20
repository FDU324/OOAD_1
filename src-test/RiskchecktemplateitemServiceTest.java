import dao.BasePersistenceTest;
import dao.IPersistenceManager;
import model.Riskchecktemplateitem;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.RiskchecktemplateitemService;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by asus on 2017/6/20.
 */
public class RiskchecktemplateitemServiceTest extends BasePersistenceTest {
    @Autowired
    RiskchecktemplateitemService service;

    @Autowired
    IPersistenceManager pm;


    // 测试添加一个检查条目，先将一个条目添加进数据库，再按照刚才设置的name在数据库查找，判断是否存在，且id是否正确
    @Test
    public void add() throws Exception {
        Riskchecktemplateitem item = service.add("Item 1", "this is a test item");
        List<Riskchecktemplateitem> result = pm.findByProperty(Riskchecktemplateitem.class, "name", "Item 1");

        assertNotNull(result.get(0));
        assertEquals(item.getId(), result.get(0).getId());

        pm.delete(item);
    }

    @Test
    public void search() throws Exception {
        Riskchecktemplateitem item1 = service.add("Item 1", "this is item A");
        Riskchecktemplateitem item2 = service.add("Item 2", "this is item B");
        Riskchecktemplateitem item3 = service.add("Item 3", "this is item C");
        Riskchecktemplateitem item4 = service.add("Item 4", "this is item D");
        Riskchecktemplateitem item5 = service.add("Item 5", "this is item A");

        List<Riskchecktemplateitem> result1 = service.search("Item");
        assertEquals(5, result1.size());

        List<Riskchecktemplateitem> result2 = service.search("A");
        assertEquals(2, result2.size());

        pm.delete(item1);
        pm.delete(item2);
        pm.delete(item3);
        pm.delete(item4);
        pm.delete(item5);
    }

}