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
	public BaseDaoI baseDaoImpl;
	
	@Override
	public <T> Serializable save(T entity) {
		baseDaoImpl.save(entity);
		return null;
	}

	@Override
	public <T> void batchSave(List<T> list) {
		baseDaoImpl.batchSave(list);
	}

	@Override
	public <T> void update(T entity) {
		baseDaoImpl.update(entity);
	}

	@Override
	public <T> List<T> getAll(Class<T> entityClass) {
		return baseDaoImpl.getAll(entityClass);

	}

	@Override
	public <T> T get(Class<T> entityClass, Serializable id) {
		return baseDaoImpl.get(entityClass, id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public <T> List<T> getListByItems(Class entityClass,Map<String, String> itemMap,Map<String, String> pageMap) {
		return baseDaoImpl.getListByItems(entityClass, itemMap, pageMap);
	}

	@Override
	public void deleteByItems(String tableName, String items, String value) {
		baseDaoImpl.deleteByItems(tableName, items, value);
	}

	@Override
	public int doUpdateHql(Session session, Query query) {
		return baseDaoImpl.doUpdateHql(session, query);
	}
	
}
