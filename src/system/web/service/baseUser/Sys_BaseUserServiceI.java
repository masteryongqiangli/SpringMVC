package system.web.service.baseUser;

import system.core.service.CommonServiceI;
import system.web.entity.baseUser.Sys_BaseUser;
import system.web.entity.user.Sys_User;

public interface Sys_BaseUserServiceI extends CommonServiceI{

	public Sys_BaseUser getLoginUser(Sys_BaseUser sys_BaseUser);

	public Sys_User getSysUserById(String userId);

	public void logout();

}
