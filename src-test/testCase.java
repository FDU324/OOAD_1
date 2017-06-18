import dao.BasePersistenceTest;
import model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2017/6/18.
 */
public class testCase extends BasePersistenceTest {

    @Before
    public void setup() {
        //Riskchecktemplateitem item = Riskchecktemplateitem.create(getPersistenceManager(), "Item 1","this is check template item 1");
    }

    @After
    public void shutdown() {
        getPersistenceManager().deleteAll(Riskchecktemplateitem.class);
    }

    @Test
    public void getItemTest(){
        Riskchecktemplateitem item = Riskchecktemplateitem.create(getPersistenceManager(), "Item 1","this is check template item 1");

        Riskchecktemplateitem result = getPersistenceManager().get(Riskchecktemplateitem.class, item.getId());
        System.out.println(result.getId());
        assertEquals(item, result);
    }

    @Test
    public void createItemTest(){
        Riskchecktemplateitem item = Riskchecktemplateitem.create(getPersistenceManager(), "Item 1","this is check template item 1");

        Riskchecktemplateitem result = getPersistenceManager().get(Riskchecktemplateitem.class, item.getId());
        assertObjectPersisted(item);
    }

    @Test
    public void deleteItemTest(){
        Riskchecktemplateitem item = Riskchecktemplateitem.create(getPersistenceManager(), "Item 1","this is check template item 1");

        getPersistenceManager().delete(item);

        Riskchecktemplateitem result = getPersistenceManager().get(Riskchecktemplateitem.class, item.getId());
        assertNull(result);
    }



    @Test
    public void deleteAllTest(){
        Riskchecktemplateitem item1 = Riskchecktemplateitem.create(getPersistenceManager(), "Item","this is check template item");
        Riskchecktemplateitem item2 = Riskchecktemplateitem.create(getPersistenceManager(), "Item","this is check template item");
        Riskchecktemplateitem item3 = Riskchecktemplateitem.create(getPersistenceManager(), "Item","this is check template item");

        getPersistenceManager().deleteAll(Riskchecktemplateitem.class);

        assertNull(getPersistenceManager().get(Riskchecktemplateitem.class, item1.getId()));
        assertNull(getPersistenceManager().get(Riskchecktemplateitem.class, item2.getId()));
        assertNull(getPersistenceManager().get(Riskchecktemplateitem.class, item3.getId()));
    }



    @Test
    public void findAllTest(){
        getPersistenceManager().deleteAll(Riskchecktemplateitem.class);

        Riskchecktemplateitem item1 = Riskchecktemplateitem.create(getPersistenceManager(), "Item","this is check template item");
        Riskchecktemplateitem item2 = Riskchecktemplateitem.create(getPersistenceManager(), "Item","this is check template item");
        Riskchecktemplateitem item3 = Riskchecktemplateitem.create(getPersistenceManager(), "Item","this is check template item");


        assertEquals(getPersistenceManager().all(Riskchecktemplateitem.class).size(), 3);
    }

    @Test
    public void findByParamTest(){
        getPersistenceManager().deleteAll(Riskchecktemplateitem.class);

        Riskchecktemplateitem item1 = Riskchecktemplateitem.create(getPersistenceManager(), "Item 1","this is check template item");
        Riskchecktemplateitem item2 = Riskchecktemplateitem.create(getPersistenceManager(), "Item 2","this is check template item");
        Riskchecktemplateitem item3 = Riskchecktemplateitem.create(getPersistenceManager(), "Item 3","this is check template item");

        List<Riskchecktemplateitem> list = getPersistenceManager().findByProperty(Riskchecktemplateitem.class, "name", "Item");
        System.out.println(list.size());
        assertEquals(list.size(), 3);
    }


    @Test
    public void findByFussyValueTest(){
        getPersistenceManager().deleteAll(Riskchecktemplateitem.class);

        Riskchecktemplateitem item1 = Riskchecktemplateitem.create(getPersistenceManager(), "Item 1","this is check template Item");
        Riskchecktemplateitem item2 = Riskchecktemplateitem.create(getPersistenceManager(), "Item 2","this is check template");
        Riskchecktemplateitem item3 = Riskchecktemplateitem.create(getPersistenceManager(), "3","this is check template Item");

        List<Riskchecktemplateitem> list = getPersistenceManager().findByFussyValue(Riskchecktemplateitem.class, "Item");

        System.out.println(list.get(0).getName());
        assertEquals(list.size(), 3);
    }




}
