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
	 * 根据id获取对象
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public <T> T get(Class<T> entityClass,final Serializable id);
	/**
	 * 根据条件查询
	 * @param entityClass 实体对象
	 * @param itemMap  查询条件
	 * @param pageMap  分页参数
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public <T> List<T> getListByItems(Class entityClass,Map<String, String> itemMap,Map<String, String> pageMap);
	
	public void deleteByItems(String tableName,String items,String value);
	
	public int doUpdateHql(Session session,Query query);
}
