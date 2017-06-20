import dao.BasePersistenceTest;
import dao.IPersistenceManager;
import model.Company;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.ICompanyService;

public class CompanyServiceTest extends BasePersistenceTest {
    @Autowired
    private ICompanyService companyService;

    @Autowired
    private IPersistenceManager pm;

    @Before
    public void setup() {
        Company.create(pm, "1", "1234", "正常", "123", "生产加工", "塑料加工", "橡胶", "徐凯文", "123-4567-8910");
    }

    @Test
    public void finishOneCheckRiskItemTest() {

    }



}
