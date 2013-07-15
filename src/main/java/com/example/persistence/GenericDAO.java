package com.example.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Anirudh
 *
 * @param <T> : Class
 * @param <ID> :Id
 */
public interface GenericDAO<T, ID extends Serializable> {

	T findById(ID id);
	List<T> findAll();
	List<T> findByExample(T exampleInstance, String... excludeProperty);
	T makePersistant(T entity);
	void delete(T entity);
	void flush();
	void clear();
	
}
