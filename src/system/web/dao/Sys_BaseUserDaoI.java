package system.web.dao;

import java.util.List;

import system.core.dao.BaseDaoI;
import system.web.entity.Sys_BaseUser;
import system.web.entity.Sys_User;

public interface Sys_BaseUserDaoI extends BaseDaoI{

	public Sys_BaseUser getLoginUser(Sys_BaseUser sys_BaseUser);

	public List<Sys_User> getSysUserById(String userId);
	
}
