package system.core.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.core.dao.BaseDaoI;
import system.core.service.CommonServiceI;
@Service("commonService")
public class CommonServiceImpl implements CommonServiceI{
	@Autowired
	public BaseDaoI baseDaoI;
	
	@Override
	public <T> Serializable save(T entity) {
		baseDaoI.save(entity);
		return null;
	}

	@Override
	public <T> void batchSave(List<T> list) {
		baseDaoI.batchSave(list);
	}

	@Override
	public <T> void update(T entity) {
		baseDaoI.update(entity);
	}

	@Override
	public <T> List<T> getAll(Class<T> entityClass) {
		return baseDaoI.getAll(entityClass);

	}

	@Override
	public <T> T get(Class<T> entityClass, Serializable id) {
		return baseDaoI.get(entityClass, id);
	}

	@Override
	public <T> List<T> getListByItems(Class entityClass,Map<String, String> itemMap,Map<String, String> pageMap) {
		return baseDaoI.getListByItems(entityClass, itemMap, pageMap);
	}

	@Override
	public void deleteByItems(String tableName, String items, String value) {
		baseDaoI.deleteByItems(tableName, items, value);
	}

	@Override
	public int doUpdateHql(Session session, Query query) {
		return baseDaoI.doUpdateHql(session, query);
	}
	
}
