package system.web.dao.login;

import java.util.Map;

import system.core.dao.BaseDaoI;
import system.web.entity.baseUser.Sys_BaseUser;

public interface LoginDaoI extends BaseDaoI{
	/**
	 * ����¼
	 * @param sys_BaseUser
	 * @return
	 */
	public Sys_BaseUser checkLogin(Sys_BaseUser sys_BaseUser,Map<String, String> itemMap);
}
