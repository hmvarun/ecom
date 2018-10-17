package com.ecom.orderProcessService.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.Id;

import org.hibernate.Session;

public interface DaoInterface {

	public <T> void persist(T entity);

	public <T> void update(T entity);

	public <T> T findEntity(String id, Class<T> classType);

	public <T> void delete(T entity);

	public <T> List<T> findAllWithCondition(String hql, Map<String, String> paramValues);

	public void deleteAll();

	public Session openCurrentSession();

	public Session openCurrentSessionwithTransaction();

	public void closeCurrentSessionwithTransaction();

	public void closeCurrentSession();

}
