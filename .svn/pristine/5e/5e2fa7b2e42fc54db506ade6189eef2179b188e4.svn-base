package com.uadec.core.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class BaseDao<T, PK extends Serializable> {

	private SessionFactory sessionFactory;
	private Class<T> clazz;

//	public BaseDao(Class<T> clazz) {
//		super();
//		this.clazz = clazz;
//	}

	@SuppressWarnings("unchecked")
	public PK save(T entity) {
		return (PK) getSession().save(entity);
	}

	public T update(T entity) {
		getSession().merge(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public T findById(PK id) {
		return (T) getSession().get(getEntity(), id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Criteria criteria = getSession().createCriteria(getEntity());
		List<T> result = criteria.list();
		System.out.println("Total de "+getEntity().getSimpleName()+":" + result.size());
		return result;
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}
	public void delete(PK id) {
		getSession().delete(findById(id));
	}

	// public void deleteEmployeeBySsn(String ssn) {
	// Query query = getSession().createSQLQuery("delete from Employee where ssn
	// = :ssn");
	// query.setString("ssn", ssn);
	// query.executeUpdate();
	// }
	//
	//
	// public Employee findBySsn(String ssn){
	// Criteria criteria = getSession().createCriteria(Employee.class);
	// criteria.add(Restrictions.eq("ssn",ssn));
	// return (Employee) criteria.uniqueResult();
	// }

	protected void init(SessionFactory session) {
		this.sessionFactory = session;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public Class<T> getEntity() {
		if (clazz == null) {
			ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
			clazz = (Class<T>) thisType.getActualTypeArguments()[0];
		}
		return clazz;
	}
}
