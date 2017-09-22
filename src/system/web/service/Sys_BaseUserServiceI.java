package system.web.service;

import system.core.service.CommonServiceI;
import system.web.entity.Sys_BaseUser;
import system.web.entity.Sys_User;

public interface Sys_BaseUserServiceI extends CommonServiceI{

	public Sys_BaseUser getLoginUser(Sys_BaseUser sys_BaseUser);

	public Sys_User getSysUserById(String userId);

}
