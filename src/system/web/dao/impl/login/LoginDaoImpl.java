package system.web.dao.impl.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import system.core.dao.impl.BaseDaoImpl;
import system.web.dao.login.LoginDaoI;
import system.web.entity.baseUser.Sys_BaseUser;
@Repository
public class LoginDaoImpl extends BaseDaoImpl implements LoginDaoI{
	@Override
	public Sys_BaseUser checkLogin(Sys_BaseUser sys_BaseUser,Map<String, String> itemMap) {
		Map<String, String> pageMap = new HashMap<String, String>();
		pageMap=null;
		return (Sys_BaseUser) getListByItems(sys_BaseUser.getClass(), itemMap, pageMap);
	}
}
