/*
 * Copyright 2006 Centenum Software Solutions, Inc. All rights reserved.
 * CENTENUM PROPRIETARY/CONFIDENTIAL. 
 */
package main.common;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Object Factory is used to process O-R mapping for main.model objects
 * 
 * @author zhangtiange
 */
public interface IPersistenceManager {

	/**
	 * create an instance of specified type
	 * 
	 * @param <E>
	 * @param clazz
	 * @return instance of class
	 */
	IModelObject create(Class<? extends IModelObject> clazz);

	/**
	 * load a persistened object
	 * 
	 * @param <E>
	 * @param clazz
	 *            type of persistened object
	 * @param id
	 *            object ID
	 * @return result object
	 */
	<T extends IModelObject> T get(Class<T> clazz, Serializable id);

	/**
	 * load the main.model object and synchronize the object with DB
	 * 
	 * @param e
	 * @return the loaded main.model object
	 */
	IModelObject load(IModelObject e);

	/**
	 * delete the main.model object
	 * 
	 * @param obj
	 */
	void delete(IModelObject obj);

	/**
	 * logic delete the main.model object
	 * 
	 * @param obj
	 */
	void logicDelete(IModelObject obj);

	/**
	 * delete all the main.model object of specified type
	 * 
	 * @param clazz
	 */
	void deleteAll(Class<? extends IModelObject> clazz);

	/**
	 * save the main.model object
	 * 
	 * @param obj
	 */
	IModelObject save(IModelObject obj);

	IModelObject create(IModelObject obj);
	
	/**
	 * save the main.model object with specified id
	 * 
	 * @param obj
	 * @param id
	 */
	void save(IModelObject obj, Serializable id);

	<T extends IModelObject> List<T> findByProperty(Class<T> clazz, String propertyName, String value);

	<T extends IModelObject> List<T> findByFussyValue(Class<T> clazz, String value);

	/**
	 * get all objects of specified type
	 * 
	 * @param clazz
	 * @return
	 */

	<T extends IModelObject> List<T> all(Class<T> clazz);

	/**
	 * check if the specified object is exist
	 * 
	 * @param value
	 * @return
	 */
	boolean exist(IModelObject value);

	/**
	 * get hibernate session
	 * 
	 * @return Hibernate Session
	 */
	Session getHibernateSession();
	
	Query createQuery(String hql);
	
	Criteria createCriteria(Class<? extends IModelObject> clazz);

}
