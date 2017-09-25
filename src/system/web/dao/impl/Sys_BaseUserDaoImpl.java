package system.web.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import system.core.dao.impl.BaseDaoImpl;
import system.web.dao.Sys_BaseUserDaoI;
import system.web.entity.Sys_BaseUser;
@Repository
public class Sys_BaseUserDaoImpl extends BaseDaoImpl implements Sys_BaseUserDaoI{
	@Override
	public Sys_BaseUser getLoginUser(Sys_BaseUser sys_BaseUser) {
		Map<String, String> datMap = new HashMap<String, String>();
		datMap.put("userName", sys_BaseUser.getUserName());
		List<Sys_BaseUser> list = getListByItems(Sys_BaseUser.class, datMap, new HashMap<String, String>());
		if (list.size()>0) {
			return list.get(0);
		}else{
			return null;
		}
	}
}