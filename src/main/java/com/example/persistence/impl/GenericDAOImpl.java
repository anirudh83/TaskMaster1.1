package com.example.persistence.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.persistence.GenericDAO;

@Repository
public abstract class GenericDAOImpl<T, ID extends Serializable> implements
		GenericDAO<T, ID> {

	private Class<T> persistenceClass;
	private Session session;

	@Autowired
	private SessionFactory sessionFactory;

	//getting Persistence class by reflection
	public GenericDAOImpl() {
		this.persistenceClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getPersistenceClass() {
		return persistenceClass;
	}

	public Session getSession() {
		if (session == null) {
			return sessionFactory.getCurrentSession();
		}
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public T findById(ID id){
		return (T)getSession().load(getPersistenceClass(), id);
	}
	
	@Override
	public T makePersistant(T entity){
		getSession().saveOrUpdate(entity);
		return entity;
	}
	
	public void delete(T entity){
		getSession().delete(entity);
	}

	@Override
	public List<T> findAll() {
		return findByCriteria();
	}

	@Override
	public List<T> findByExample(T exampleInstance,
			String... excludeProperty) {
		Criteria criteria = getSession().createCriteria(getPersistenceClass());
		Example example = Example.create(exampleInstance);
		for(String exclude : excludeProperty){
			example.excludeProperty(exclude);
		}
		criteria.add(example);
		return criteria.list();
	}

	@Override
	public void flush() {
		getSession().flush();
		
	}

	@Override
	public void clear() {
		getSession().clear();
	}
	
	public List<T> findByCriteria(Criterion... criterion){
		Criteria criteria = getSession().createCriteria(getPersistenceClass());
		for (Criterion c : criterion) {
			criteria.add(c);
		}
		return criteria.list();
	}
}
