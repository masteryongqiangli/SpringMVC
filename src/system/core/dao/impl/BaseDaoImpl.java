package system.core.dao.impl;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import system.core.dao.BaseDaoI;
@Repository
public class BaseDaoImpl implements BaseDaoI{
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	public Session getSession(){
		return sessionFactory.openSession();
	}
	/**
	 * ��ʵ�����������ݿ�
	 * @param entity
	 * @return
	 */
	@Override
	public <T> Serializable save(T entity) {
		Serializable id;
		try{
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			id = session.save(entity);
			transaction.commit();
			session.flush();
			session.close();
		}catch(RuntimeException exception){
			throw exception;
		}
		return id;
	}
	/**
	 * ��ʵ����������������ݿ�
	 * @param list
	 */
	@Override
	public <T> void batchSave(List<T> list) {
		Serializable id;
		try{
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			int i=0;
			for(T entity:list){
				id = session.save(entity);
				if (i%25==0) {
					session.flush();
					session.clear();
				}
			}
			session.flush();
			transaction.commit();
			session.close();
		}catch(RuntimeException exception){
			throw exception;
		}
	}
	/**
	 * ���¶�Ӧʵ�����
	 * @param entity
	 */
	@Override
	public <T> void update(T entity) {
		try{
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(entity);
			transaction.commit();
			session.flush();
			session.close();
		}catch(RuntimeException exception){
			throw exception;
		}
	}
	/**
	 * ��ȡ����ʵ�����
	 * @param entityClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getAll(Class<T> entityClass) {
		return createCriteria(entityClass).list();
	}
	/**
	 * ����������ȡʵ�����
	 * @param entityClass
	 * @param id
	 * @return
	 */
	@Override
	public <T> T get(Class<T> entityClass, Serializable id) {
		return getSession().get(entityClass, id);
	}
	/**
	 * ������ȡʵ�����
	 * @param entityClass
	 * @param items
	 * @param object
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getListByItems(Class<T> entityClass, String items,
			Object object) {
		return createCriteria(entityClass).add(Restrictions.eq(items, object)).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getListByItemsIsNull(Class<T> entityClass, String items) {
		return createCriteria(entityClass).add(Restrictions.isNull(items)).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getListByItemsIsNotNull(Class<T> entityClass,
			String items) {
		return createCriteria(entityClass).add(Restrictions.isNotNull(items)).list();
	}
	/**
	 * ɾ��ʵ�����
	 * @param tableName
	 * @param items
	 * @param value
	 */
	@Override
	public void deleteByItems(String tableName, String items, String value) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("delete from "+tableName+" where "+items +" = '"+value+"'");
		Query query = session.createQuery(sqlBuffer.toString());
		query.executeUpdate();
		transaction.commit();
	}
	@Override
	public int doUpdateHql(Session session, Query query) {
		int i=0;
		try{
			Transaction transaction = session.beginTransaction();
			i = query.executeUpdate();
			transaction.commit();
		}catch(Exception exception){
			throw exception;
		}
		return i;
	}
	public <T> Criteria createCriteria(Class<T> entiClass){
		Criteria criteria = getSession().createCriteria(entiClass);
		return criteria;
	}
}
