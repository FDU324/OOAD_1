package common;

import junit.framework.TestCase;

import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
@Rollback(value = false)
@Transactional(transactionManager = "transactionManager")
public class BasePersistenceTest extends TestCase implements
        ApplicationContextAware {
	protected ApplicationContext appContext;
	private static final Logger logger = LogManager.getLogger(BasePersistenceTest.class);

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		appContext = context;

	}

	public IPersistenceManager getPersistenceManager() {
		return (IPersistenceManager) appContext.getBean("DAO");
	}
	
	protected void assertObjectPersisted(IModelObject object) {
		assertNotNull(object.getId());
	}

}
