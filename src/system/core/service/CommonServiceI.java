package system.core.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

public interface CommonServiceI {
	public <T> Serializable save(T entity);
	public <T> void batchSave(List<T> list);
	public <T> void update(T entity);
	public <T> List<T> getAll(Class<T> entityClass);
	/**
	 * 根据id获取对象
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public <T> T get(Class<T> entityClass,final Serializable id);
	
	/**
	 * 根据属性获取对象列表
	 * @param entityClass
	 * @param items
	 * @param object
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public <T> List<T> getListByItems(Class entityClass,Map<String, String> itemMap,Map<String, String> pageMap);
	
	public void deleteByItems(String tableName,String items,String value);
	
	public int doUpdateHql(Session session,Query query);
}
