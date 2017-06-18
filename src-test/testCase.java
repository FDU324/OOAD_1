import dao.BasePersistenceTest;
import model.*;
import org.junit.Test;

/**
 * Created by asus on 2017/6/18.
 */
public class testCase extends BasePersistenceTest {

    @Test
    public void deletePlanTest(){

        getPersistenceManager().deleteAll(Riskchecktemplateitem.class);
    }
}
