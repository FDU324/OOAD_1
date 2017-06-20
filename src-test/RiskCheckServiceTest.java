import dao.BasePersistenceTest;
import dao.IPersistenceManager;
import model.*;
import model.enums.CompanyState;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.IRiskCheckService;

import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * Created by asus on 2017/6/20.
 */
public class RiskCheckServiceTest extends BasePersistenceTest {
    @Autowired
    IRiskCheckService service;

    @Autowired
    IPersistenceManager pm;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        pm.deleteAll(Company.class);
        pm.deleteAll(RiskCheck.class);
        pm.deleteAll(RiskCheckPlan.class);
        pm.deleteAll(RiskCheckTemplate.class);
        pm.deleteAll(RiskCheckTemplateItem.class);

    }

    // 测试将一个plan发放给一个company，与其他测试中的add类似
    @Test
    public void add() throws Exception {
        Company company = Company.create(pm, "", "", CompanyState.NORMAL, "", "", "", "", "", "" );
        RiskCheckTemplate template = RiskCheckTemplate.create(pm, "template","", new HashSet<RiskCheckTemplateItem>());
        RiskCheckPlan plan = RiskCheckPlan.create(pm, "plan", template);
        RiskCheck task = service.add(company, plan, "2017-06-30");

        RiskCheck result = pm.get(RiskCheck.class, task.getId());
        assertNotNull(result);


    }


}