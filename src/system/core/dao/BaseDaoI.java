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
	 * ����������ѯ
	 * @param entityClass ʵ�����
	 * @param itemMap  ��ѯ����
	 * @param pageMap  ��ҳ����
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public <T> List<T> getListByItems(Class entityClass,Map<String, String> itemMap,Map<String, String> pageMap);
	
	public void deleteByItems(String tableName,String items,String value);
	
	public int doUpdateHql(Session session,Query query);
}
