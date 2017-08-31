package system.core.dao;

import java.io.Serializable;
import java.util.List;



import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
public interface BaseDaoI {
	public <T> Serializable save(T entity);
	public <T> void batchSave(List<T> list);
	public <T> void update(T entity);
	public <T> List<T> getAll(Class<T> entityClass);
	/**
	 * ����id��ȡ����
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public <T> T get(Class<T> entityClass,final Serializable id);
	
	/**
	 * �������Ի�ȡ�����б�
	 * @param entityClass
	 * @param items
	 * @param object
	 * @return
	 */
	public <T> List<T> getListByItems(Class<T> entityClass,Map<String, String> map);
	
	public <T> List<T> getListByItemsIsNull(Class<T> entityClass,String items);
	
	public <T> List<T> getListByItemsIsNotNull(Class<T> entityClass,String items);
	
	public void deleteByItems(String tableName,String items,String value);
	
	public int doUpdateHql(Session session,Query query);
}
