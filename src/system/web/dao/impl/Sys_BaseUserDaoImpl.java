package system.web.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import system.core.dao.impl.BaseDaoImpl;
import system.web.dao.Sys_BaseUserDaoI;
import system.web.entity.Sys_BaseUser;
import system.web.entity.Sys_User;
@Repository
public class Sys_BaseUserDaoImpl extends BaseDaoImpl implements Sys_BaseUserDaoI{
	@Override
	public Sys_BaseUser getLoginUser(Sys_BaseUser sys_BaseUser) {
		Map<String, String> dataMap = new HashMap<String, String>();
		dataMap.put("userName", sys_BaseUser.getUserName());
		Map<String, String> map = new HashMap<String, String>();
		List<Sys_BaseUser> list = getListByItems(Sys_BaseUser.class, dataMap, map);
		if (list.size()>0) {
			return list.get(0);
		}else{
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sys_User> getSysUserById(String userId) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" SELECT a.*,c.roleId,c.roleCode,c.roleName FROM dbo.Sys_BaseUser a ");
		buffer.append(" LEFT JOIN dbo.Sys_BaseRoleUser b ON a.userId = b.baseUserId");
		buffer.append(" LEFT JOIN dbo.Sys_BaseRole c ON b.roleId = c.roleId");
		buffer.append(" WHERE a.userId = '"+userId+"'");
		SQLQuery query = this.getSession().createSQLQuery(buffer.toString());
		query.addEntity(Sys_User.class);
		return query.list();
	}
}
