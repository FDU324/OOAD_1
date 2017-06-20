import common.BasePersistenceTest;
import common.IPersistenceManager;
import model.RiskCheckTemplate;
import model.RiskCheckTemplateItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.IRiskCheckTemplateService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by asus on 2017/6/20.
 */
public class RiskCheckTemplateServiceTest extends BasePersistenceTest {
    @Autowired
    IRiskCheckTemplateService service;

    @Autowired
    IPersistenceManager pm;

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
        pm.deleteAll(RiskCheckTemplate.class);
        pm.deleteAll(RiskCheckTemplateItem.class);
    }

    // 测试添加一个检查模板，先将一个条目添加进数据库，再按照刚才设置的id在数据库查找，判断是否存在
    @Test
    public void add() throws Exception {
        Set<RiskCheckTemplateItem> set = new HashSet<RiskCheckTemplateItem>();
        set.add(RiskCheckTemplateItem.create(pm, "item 1", "this is a test item"));
        RiskCheckTemplate temp = service.add("template","summary", set);

        assertNotNull(pm.get(RiskCheckTemplate.class, temp.getId()));
    }


    // 测试编辑template
    @Test
    public void edit() throws Exception {
        Set<RiskCheckTemplateItem> set = new HashSet<RiskCheckTemplateItem>();
        set.add(RiskCheckTemplateItem.create(pm, "item 1", "this is a test item"));
        RiskCheckTemplate temp = service.add("template","summary", set);  //template

        // 修改template的信息
        set.add(RiskCheckTemplateItem.create(pm, "item 2", "this is a test item"));
        service.edit(temp, "template 2", "summary 2", set);

        // 将修改后的template从数据库取出
        RiskCheckTemplate result = pm.get(RiskCheckTemplate.class, temp.getId());

        // 期望值：
        // name: template 2
        // summary: summary 2
        // set.size: 2
        assertNotNull(result);
        assertEquals("template 2", result.getName());
        assertEquals("summary 2", result.getSummary());
        assertEquals(2, result.getRiskCheckTemplateItems().size());

    }

    // 测试给template增加item
    @Test
    public void addRiskCheckTemplateItem() throws Exception {
        // 创建一个template， 包含一个空的set
        Set<RiskCheckTemplateItem> set = new HashSet<RiskCheckTemplateItem>();
        RiskCheckTemplate temp = service.add("template","summary", set);  //template

        // 添加一个名为 "item 1" 的检查条目
        service.addRiskCheckTemplateItem(temp,  RiskCheckTemplateItem.create(pm, "item 1", "this is a test item"));

        // 将修改后的template从数据库取出
        RiskCheckTemplate result = pm.get(RiskCheckTemplate.class, temp.getId());

        // 期望值：
        // set.size: 1
        // set.get(0).name == "item 1"
        assertNotNull(result);
        assertEquals(1, result.getRiskCheckTemplateItems().size());
        assertEquals("item 1", result.getRiskCheckTemplateItems().iterator().next().getName());

    }


    //测试模糊查找，查找方式为：对每条表项，在所有字段中模糊匹配“pattern”（不区分大小写），将所有匹配到的表项用list返回
    @Test
    public void search() throws Exception {

        // 插入7条数据
        service.add("Template 1", "summary A", new HashSet<RiskCheckTemplateItem>());       // template1
        service.add("Template 2", "summary B", new HashSet<RiskCheckTemplateItem>());       // template2
        service.add("Template 3", "summary C", new HashSet<RiskCheckTemplateItem>());       // template3
        service.add("Template 4", "summary D", new HashSet<RiskCheckTemplateItem>());       // template4
        service.add("Template 5", "summary A", new HashSet<RiskCheckTemplateItem>());       // template5
        service.add("Template TEST", "summary", new HashSet<RiskCheckTemplateItem>());      // template6
        service.add("Template 6", "summary TEST", new HashSet<RiskCheckTemplateItem>());    // template7


        // 匹配pattern："Template"
        // 期望返回的list：所有template
        // 望值的list.size: 7
        List<RiskCheckTemplate> result1 = service.search("Template");
        assertEquals(7, result1.size());

        // 匹配pattern："A"
        // 期望返回的list：[template1, template5]
        // 望值的list.size: 2
        List<RiskCheckTemplate> result2 = service.search("summary A");
        assertEquals(2, result2.size());

        // 匹配pattern："0"
        // 期望返回的list：[]
        // 望值的list.size: 0
        List<RiskCheckTemplate> result3 = service.search("0");
        assertEquals(0, result3.size());

        // 匹配pattern："TEST"
        // 期望返回的list：[template6, template7]
        // 望值的list.size: 2
        List<RiskCheckTemplate> result4 = service.search("TEST");
        assertEquals(2, result4.size());

    }

}