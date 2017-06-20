import common.BasePersistenceTest;
import model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by asus on 2017/6/18.
 */
public class testCase extends BasePersistenceTest {

    @Before
    public void setup() {
        //RiskCheckTemplateItem item = RiskCheckTemplateItem.create(getPersistenceManager(), "Item 1","this is check template item 1");
    }

    @After
    public void shutdown() {
        getPersistenceManager().deleteAll(RiskCheckTemplateItem.class);
    }

    @Test
    public void getItemTest(){
        RiskCheckTemplateItem item = RiskCheckTemplateItem.create(getPersistenceManager(), "Item 1","this is check template item 1");

        RiskCheckTemplateItem result = getPersistenceManager().get(RiskCheckTemplateItem.class, item.getId());
        System.out.println(result.getId());
        assertEquals(item, result);
    }

    @Test
    public void createItemTest(){
        RiskCheckTemplateItem item = RiskCheckTemplateItem.create(getPersistenceManager(), "Item 1","this is check template item 1");

        RiskCheckTemplateItem result = getPersistenceManager().get(RiskCheckTemplateItem.class, item.getId());
        assertObjectPersisted(item);
    }

    @Test
    public void deleteItemTest(){
        RiskCheckTemplateItem item = RiskCheckTemplateItem.create(getPersistenceManager(), "Item 1","this is check template item 1");

        getPersistenceManager().delete(item);

        RiskCheckTemplateItem result = getPersistenceManager().get(RiskCheckTemplateItem.class, item.getId());
        assertNull(result);
    }



    @Test
    public void deleteAllTest(){
        RiskCheckTemplateItem item1 = RiskCheckTemplateItem.create(getPersistenceManager(), "Item","this is check template item");
        RiskCheckTemplateItem item2 = RiskCheckTemplateItem.create(getPersistenceManager(), "Item","this is check template item");
        RiskCheckTemplateItem item3 = RiskCheckTemplateItem.create(getPersistenceManager(), "Item","this is check template item");

        getPersistenceManager().deleteAll(RiskCheckTemplateItem.class);

        assertNull(getPersistenceManager().get(RiskCheckTemplateItem.class, item1.getId()));
        assertNull(getPersistenceManager().get(RiskCheckTemplateItem.class, item2.getId()));
        assertNull(getPersistenceManager().get(RiskCheckTemplateItem.class, item3.getId()));
    }



    @Test
    public void findAllTest(){
        getPersistenceManager().deleteAll(RiskCheckTemplateItem.class);

        RiskCheckTemplateItem item1 = RiskCheckTemplateItem.create(getPersistenceManager(), "Item","this is check template item");
        RiskCheckTemplateItem item2 = RiskCheckTemplateItem.create(getPersistenceManager(), "Item","this is check template item");
        RiskCheckTemplateItem item3 = RiskCheckTemplateItem.create(getPersistenceManager(), "Item","this is check template item");


        assertEquals(getPersistenceManager().all(RiskCheckTemplateItem.class).size(), 3);
    }

    @Test
    public void findByParamTest(){
        getPersistenceManager().deleteAll(RiskCheckTemplateItem.class);

        RiskCheckTemplateItem item1 = RiskCheckTemplateItem.create(getPersistenceManager(), "Item 1","this is check template item");
        RiskCheckTemplateItem item2 = RiskCheckTemplateItem.create(getPersistenceManager(), "Item 2","this is check template item");
        RiskCheckTemplateItem item3 = RiskCheckTemplateItem.create(getPersistenceManager(), "Item 3","this is check template item");

        List<RiskCheckTemplateItem> list = getPersistenceManager().findByProperty(RiskCheckTemplateItem.class, "name", "Item");
        System.out.println(list.size());
        assertEquals(list.size(), 3);
    }


    @Test
    public void findByFussyValueTest(){
        getPersistenceManager().deleteAll(RiskCheckTemplateItem.class);

        RiskCheckTemplateItem item1 = RiskCheckTemplateItem.create(getPersistenceManager(), "Item 1","this is check template Item");
        RiskCheckTemplateItem item2 = RiskCheckTemplateItem.create(getPersistenceManager(), "Item 2","this is check template");
        RiskCheckTemplateItem item3 = RiskCheckTemplateItem.create(getPersistenceManager(), "3","this is check template Item");

        List<RiskCheckTemplateItem> list = getPersistenceManager().findByFussyValue(RiskCheckTemplateItem.class, "Item");

        System.out.println(list.get(0).getName());
        assertEquals(list.size(), 3);
    }




}
