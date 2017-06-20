import dao.BasePersistenceTest;
import dao.IPersistenceManager;
import model.RiskCheck;
import model.RiskCheckPlan;
import model.RiskCheckTemplate;
import model.RiskCheckTemplateItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.IRiskCheckPlanService;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by asus on 2017/6/20.
 */
public class RiskCheckPlanServiceTest extends BasePersistenceTest {
    @Autowired
    IRiskCheckPlanService service;

    @Autowired
    IPersistenceManager pm;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        pm.deleteAll(RiskCheckPlan.class);
        pm.deleteAll(RiskCheckTemplate.class);
    }


    @Test
    public void add() throws Exception {
        RiskCheckPlan plan = service.add("plan", RiskCheckTemplate.create(pm, "template", "summary", new HashSet<RiskCheckTemplateItem>()));
        RiskCheckPlan result = pm.get(RiskCheckPlan.class, plan.getId());

        assertNotNull(result);

    }

    // 与template中的edit测试类似
    @Test
    public void edit() throws Exception {
        RiskCheckPlan plan = service.add("plan", RiskCheckTemplate.create(pm, "template", "summary", new HashSet<RiskCheckTemplateItem>()));
        service.edit(plan, "plan 2");

        RiskCheckPlan result = pm.get(RiskCheckPlan.class, plan.getId());

        assertNotNull(result);
        assertEquals("plan 2", result.getName());

    }

    // 与template中的search测试类似
    @Test
    public void search() throws Exception {
        service.add("plan 1", RiskCheckTemplate.create(pm, "template", "summary", new HashSet<RiskCheckTemplateItem>()));  // plan1
        service.add("plan 2", RiskCheckTemplate.create(pm, "template", "summary", new HashSet<RiskCheckTemplateItem>()));  // plan2
        service.add("plan 1", RiskCheckTemplate.create(pm, "template", "summary", new HashSet<RiskCheckTemplateItem>()));  // plan3
        service.add("plan 3", RiskCheckTemplate.create(pm, "template", "summary", new HashSet<RiskCheckTemplateItem>()));  // plan4

        // 匹配pattern："plan"
        // 期望返回的list：所有plan
        // 望值的list.size: 4
        List<RiskCheckPlan> result1 = service.search("plan");
        assertEquals(4, result1.size());

        // 匹配pattern："plan"
        // 期望返回的list：[]
        // 望值的list.size: 0
        List<RiskCheckPlan> result2 = service.search("0");
        assertEquals(0, result2.size());

        // 匹配pattern："plan"
        // 期望返回的list：所有plan
        // 望值的list.size: 2
        List<RiskCheckPlan> result3 = service.search("plan 1");
        assertEquals(2, result3.size());

    }

}