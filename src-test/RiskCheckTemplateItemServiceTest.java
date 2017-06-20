import common.BasePersistenceTest;
import common.IPersistenceManager;
import model.RiskCheckTemplateItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.IRiskCheckTemplateItemService;

import java.util.List;


/**
 * Created by asus on 2017/6/20.
 */
public class RiskCheckTemplateItemServiceTest extends BasePersistenceTest {
    @Autowired
    private IRiskCheckTemplateItemService service;

    @Autowired
    IPersistenceManager pm;

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
        pm.deleteAll(RiskCheckTemplateItem.class);
    }


    // 测试添加一个检查条目，先将一个条目添加进数据库，再按照刚才设置的id在数据库查找，判断是否存在
    @Test
    public void add() throws Exception {
        RiskCheckTemplateItem item = service.add("Item 1", "this is a test item");
        RiskCheckTemplateItem result = pm.get(RiskCheckTemplateItem.class, item.getId());

        assertNotNull(result);
    }

    //测试模糊查找，查找方式为：对每条表项，在所有字段中模糊匹配“pattern”（不区分大小写），将所有匹配到的表项用list返回
    @Test
    public void search() throws Exception {
        // 插入7条数据
        service.add("Item 1", "this is item A");       // item1
        service.add("Item 2", "this is item B");       // item2
        service.add("Item 3", "this is item C");       // item3
        service.add("Item 4", "this is item D");       // item4
        service.add("Item 5", "this is item A");       // item5
        service.add("Item TEST", "this is a item");    // item6
        service.add("Item 6", "this is a TEST item");  // item7


        // 匹配pattern："Item"
        // 期望返回的list：所有item
        // 望值的list.size: 7
        List<RiskCheckTemplateItem> result1 = service.search("Item");
        assertEquals(7, result1.size());

        // 匹配pattern："A"
        // 期望返回的list：[item1,item5, item6, item7]
        // 望值的list.size: 4
        List<RiskCheckTemplateItem> result2 = service.search("A");
        assertEquals(4, result2.size());

        // 匹配pattern："0"
        // 期望返回的list：[]
        // 望值的list.size: 0
        List<RiskCheckTemplateItem> result3 = service.search("0");
        assertEquals(0, result3.size());

        // 匹配pattern："TEST"
        // 期望返回的list：[item6, item7]
        // 望值的list.size: 2
        List<RiskCheckTemplateItem> result4 = service.search("TEST");
        assertEquals(2, result4.size());

    }

}