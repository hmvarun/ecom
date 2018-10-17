package com.ecom.orderProcessService.daoImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.ecom.orderProcessService.dao.DaoInterface;
import com.ecom.orderProcessService.model.AccountInfo;

public class DaoImpl implements DaoInterface {

	private Session currentSession;

	private Transaction currentTransaction;

	public DaoImpl() {

	}

	public <T> void persist(T entity) {
		getCurrentSession().save(entity);
	}

	public <T> void update(T entity) {
		getCurrentSession().update(entity);

	}

	public <T> T findEntity(String id, Class<T> classType) {
		T entity = (T) getCurrentSession().get(classType, id);
		return entity;
	}

	public <T> List<T> findAllWithCondition(String hql, Map<String, String> paramValues) {
		Query createQuery = getCurrentSession().createQuery(hql);
		for (Map.Entry<String, String> paramValue : paramValues.entrySet()) {
			createQuery.setParameter(paramValue.getKey(), paramValue.getValue());
		}
		List<T> resultEntities = (List<T>) createQuery.list();
		return resultEntities;
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	private static SessionFactory getSessionFactory() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		MetadataSources sources = new MetadataSources(registry);
		Metadata metadata = sources.getMetadataBuilder().build();
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		return sessionFactory;
	}

	public <T> void delete(T entity) {
		// TODO Auto-generated method stub

	}

	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		DaoImpl daoImpl = new DaoImpl();
		Session currentSession2 = daoImpl.openCurrentSession();
		AccountInfo accountInfo = currentSession2.get(AccountInfo.class, "b93d9f14-24eb-4367-8e94-91aec8e6f56a");
		System.out.println(accountInfo.getBilling_info());
		//List<AccountInfo> findAll = daoImpl.findAllWithCondition("from AccountInfo where email= :email", "email", "varun");
		//System.out.println(findAll.size());

	}

}
