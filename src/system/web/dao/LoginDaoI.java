package system.web.dao;

import java.util.Map;

import system.core.dao.BaseDaoI;
import system.web.entity.Sys_BaseUser;

public interface LoginDaoI extends BaseDaoI{
	/**
	 * ¼ì²éµÇÂ¼
	 * @param sys_BaseUser
	 * @return
	 */
	public Sys_BaseUser checkLogin(Sys_BaseUser sys_BaseUser,Map<String, String> itemMap);
}
