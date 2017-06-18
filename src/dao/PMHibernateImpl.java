/*
 * Copyright 2006 Centenum Software Solutions, Inc. All rights reserved.
 * CENTENUM PROPRIETARY/CONFIDENTIAL. 
 */
package dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A hibernate/Spring framework implementation for IObjectFactory
 * 
 * @author zhang tiange
 * 
 */
@Transactional
public class PMHibernateImpl extends HibernateDaoSupport implements IPersistenceManager, BeanFactoryAware {

	public static IPersistenceManager getInstance() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "HibernateApplicationContext.xml" });
		return (IPersistenceManager) ((BeanFactory) appContext)
				.getBean("objectFactory");
	}

	BeanFactory beanFactory;

	private Class getImplClass(Class clazz) {
		if (clazz.isInterface()) {
			return beanFactory.getBean(getBeanID(clazz)).getClass();
		} else {
			return clazz;
		}
	}

	private String getBeanID(Class clazz) {
		int pos = clazz.getName().lastIndexOf('.') + 1;
		return clazz.getName().substring(pos);
	}

	@Override
	public IModelObject create(Class clazz) {
		IModelObject bean = (IModelObject) beanFactory
				.getBean(getBeanID(clazz));
		return bean;
	}

	@Override
	public IModelObject get(Class clazz, Serializable id) {
		IModelObject bean = (IModelObject) getHibernateTemplate().get(
				getImplClass(clazz), id);
		return bean;
	}

	@Override
	public IModelObject load(IModelObject e) {
		getHibernateTemplate().load(e, e.getId());
		return e;
	}

	@Override
	public void delete(IModelObject obj) {
		getHibernateTemplate().delete(obj);
	}

	@Override
	public IModelObject save(IModelObject obj) {
		getHibernateTemplate().saveOrUpdate(obj);
		return obj;
	}

	@Override
	public IModelObject create(IModelObject obj) {
		getHibernateTemplate().saveOrUpdate(obj);
		return obj;
	}

	@Override
	public <T extends IModelObject> List<T> findByProperty(Class<T> clazz, String propertyName, String value) {
		System.out.println("from " + clazz.getName() +" clazz where clazz."+propertyName+" like '% :"+propertyName+"%'");
		return (List<T>)getHibernateTemplate().find("from " + clazz.getName() +" clazz where clazz."+propertyName+" like '%"+value+"%'");
	}

	@Override
	public <T extends IModelObject> List<T> findByFussyValue(Class<T> clazz, String value) {
		Field[] fields = clazz.getDeclaredFields();
		StringBuffer hql = new StringBuffer();
		hql.append("from " + clazz.getName() +" clazz where ");
		//String sql = "from " + clazz.getName() +" clazz where ";clazz."+propertyName+" like '%"+value+"%'"

		hql.append("clazz."+fields[0].getName()+" like '%"+value+"%'");
		for (int i = 1; i<fields.length; i++) {
			hql.append(" or clazz."+fields[i].getName()+" like '%"+value+"%'");
		}
		System.out.println(hql.toString());
		return (List<T>)getHibernateTemplate().find(hql.toString());


	}



	@Override
	public <T extends IModelObject> List<T> all(Class<T> clazz) {
		return (List<T>)getHibernateTemplate().find("from " + clazz.getName());
	}



	@Override
	public boolean exist(IModelObject value) {
		throw new RuntimeException("not supported");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.fudan.framework.persistence.IObjectFactory#deleteAll(java.lang.Class)
	 */
	@Override
	public void deleteAll(Class clazz) {
		getHibernateTemplate().deleteAll(all(clazz));
	}

	@Override
	public Criteria createCriteria(Class clazz) {
		return getHibernateSession().createCriteria(clazz);
	}

	@Override
	public void save(IModelObject model, Serializable id) {
		// getSession().persist(model, id);
	}

	@Override
	public Session getHibernateSession() {
		return currentSession();
	}

	@Override
	public void logicDelete(IModelObject modelObject) {
		save(modelObject);
	}

	@Override
	public Query createQuery(String hql) {
		return getHibernateSession().createQuery(hql);
	}
}
