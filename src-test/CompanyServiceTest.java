import common.BasePersistenceTest;
import common.IPersistenceManager;
import model.*;
import model.enums.CompanyState;
import model.enums.RiskCheckState;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.ICompanyService;
import service.IRiskCheckService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CompanyServiceTest extends BasePersistenceTest {
    @Autowired
    private ICompanyService service;

    @Autowired
    private IRiskCheckService riskCheckService;

    @Autowired
    private IPersistenceManager pm;

    @Before
    public void setUp() {
        //Company.create(pm, "1", "1234", CompanyState.NORMAL, "123", "生产加工", "塑料加工", "橡胶", "徐凯文", "123-4567-8910");

    }


    @After
    public void tearDown() {

        pm.deleteAll(Company.class);
        pm.deleteAll(RiskCheck.class);
        pm.deleteAll(RiskCheckPlan.class);
        pm.deleteAll(RiskCheckTemplate.class);
        pm.deleteAll(RiskCheckTemplateItem.class);
    }


    @Test
    public void finishOneCheckRiskItem() throws Exception {
        Company company = Company.create(pm, "", "", CompanyState.NORMAL, "", "", "", "", "", "" );

        // 新建一个plan，并发放给company，这个plan里有一个item1
        Set<RiskCheckTemplateItem> set1 = new HashSet<RiskCheckTemplateItem>();
        set1.add(RiskCheckTemplateItem.create(pm, "item 1", ""));                     // item1
        RiskCheckTemplate template1 = RiskCheckTemplate.create(pm, "template","", set1);
        RiskCheckPlan plan1 = RiskCheckPlan.create(pm, "plan", template1);
        riskCheckService.add(company, plan1, "2017-06-30");

        // 修改item的完成状态
        RiskCheckItem item = service.getAllRiskCheckItem(company).iterator().next();
        service.finishOneCheckRiskItem(item, "完成");

        // 期望值："完成"
        RiskCheckItem result = service.getAllRiskCheckItem(company).iterator().next();
        assertEquals("完成", result.getResult());
    }

    // 和其余测试类中的add类似
    @Test
    public void add() throws Exception {
        Company company = service.add("1", "1234", CompanyState.NORMAL, "123", "生产加工", "塑料加工", "橡胶", "徐凯文", "123-4567-8910");
        Company result = pm.get(Company.class, company.getId());

        assertNotNull(result);
    }


    // 测试修改company信息
    @Test
    public void edit() throws Exception {
        Company company = service.add("1", "1234", CompanyState.NORMAL, "123", "生产加工", "塑料加工", "橡胶", "徐凯文", "123-4567-8910");

        service.edit(company,"2", "4321", CompanyState.ABSENT, "321", "销售", "零售", "橡胶", "蒲实", "987-6543-2100");
        Company result = pm.get(Company.class, company.getId());

        assertNotNull(result);
        assertEquals("2", result.getCode());
        assertEquals("4321", result.getName());
        assertEquals(CompanyState.ABSENT, result.getState());
        assertEquals("321", result.getOrganizationalCode());
        assertEquals("销售", result.getIndustryGenera());
        assertEquals("零售", result.getIndustry());
        assertEquals("橡胶", result.getBusinessCategory());
        assertEquals("蒲实", result.getContact());
        assertEquals("987-6543-2100", result.getContactNumber());

    }

    @Test
    public void getAllRiskCheckItem() throws Exception {
        Company company = Company.create(pm, "", "", CompanyState.NORMAL, "", "", "", "", "", "" );

        // 新建一个plan，并发放给company，这个plan里有一个item1
        Set<RiskCheckTemplateItem> set1 = new HashSet<RiskCheckTemplateItem>();
        set1.add(RiskCheckTemplateItem.create(pm, "item 1", ""));                     // item1
        RiskCheckTemplate template1 = RiskCheckTemplate.create(pm, "template","", set1);
        RiskCheckPlan plan1 = RiskCheckPlan.create(pm, "plan", template1);
        riskCheckService.add(company, plan1, "2017-06-30");


        // item集合：[item1]
        // 期望size：1
        Set<RiskCheckItem> result = service.getAllRiskCheckItem(company);
        assertEquals(1, result.size());


        // 新建一个plan，并发放给company，这个plan里有一个item2
        Set<RiskCheckTemplateItem> set2 = new HashSet<RiskCheckTemplateItem>();
        set2.add(RiskCheckTemplateItem.create(pm, "item 2", ""));
        RiskCheckTemplate template2 = RiskCheckTemplate.create(pm, "template","", set2);
        RiskCheckPlan plan2 = RiskCheckPlan.create(pm, "plan", template2);
        riskCheckService.add(company, plan2, "2017-06-30");

        // item集合：[item1, item2]
        // 期望size：2
        result = service.getAllRiskCheckItem(company);
        assertEquals(2, result.size());

    }



}
