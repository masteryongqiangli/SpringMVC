package system.web.dao;

import system.core.dao.BaseDaoI;
import system.web.entity.Sys_BaseUser;

public interface Sys_BaseUserDaoI extends BaseDaoI{

	public Sys_BaseUser getLoginUser(Sys_BaseUser sys_BaseUser);
	
}
