package main.common;

import junit.framework.TestCase;

import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/ApplicationContext.xml"})
@Rollback(value = false)
@Transactional(transactionManager = "transactionManager")
public abstract class BasePersistenceTest extends TestCase implements
        ApplicationContextAware {
	protected ApplicationContext appContext;


	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		appContext = context;

	}

	public IPersistenceManager getPersistenceManager() {
		return (IPersistenceManager) appContext.getBean("DAO");
	}
	


}
