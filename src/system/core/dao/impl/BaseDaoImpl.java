package system.core.dao.impl;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Disjunction;
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
		@SuppressWarnings("unused")
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
	 * ����������ȡʵ�����
	 * @param entityClass
	 * @param dataMap ��ѯ������ɵ�map<id=12222>
	 * @param pageMap ��ҳ����
	 * @return {@link JSONObject}
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> List<T> getListByItems(Class entityClass, Map<String, String> dataMap,Map<String, String> pageMap) {
		Criteria criteria = this.createCriteria(entityClass);
		Disjunction disjunction = Restrictions.disjunction();
		for(String key:dataMap.keySet()){
			if (key.equals("state")) {
				disjunction.add(Restrictions.eq(key, Integer.parseInt(dataMap.get(key))));
			}else{
				disjunction.add(Restrictions.eq(key, dataMap.get(key)));
			}
		}
		if (!pageMap.isEmpty()) {
			int pageNumber = Integer.parseInt(pageMap.get("page"));
			int pageRows = Integer.parseInt(pageMap.get("rows"));
			int startNumber = (pageNumber-1)*pageRows;
			criteria.setFirstResult(startNumber);
			criteria.setMaxResults(pageRows);
		}
		return criteria.add(disjunction).list();
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
	@SuppressWarnings("unchecked")
	public <T> List<T> findByProperty(Class<T> entityClass, String propertyName, Object value) {
		return  createCriteria(entityClass).add(Restrictions.eq(propertyName, value)).list();
	}
}
