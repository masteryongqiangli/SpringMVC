package system.web.service;

import javax.servlet.http.HttpServletRequest;

import system.core.service.CommonServiceI;
import system.web.entity.Sys_BaseUser;
import system.web.entity.Sys_User;

public interface LoginServiceI extends CommonServiceI{
	/**
	 * ¼ì²éµÇÂ¼
	 * @param sys_BaseUser
	 * @return
	 */
	public Sys_BaseUser checkLogin(Sys_BaseUser sys_BaseUser,HttpServletRequest request);

	public boolean checkUserName(String parameter);

	public boolean checkUserPswd(String endcoderByMd5Utile);

	public Sys_BaseUser getLoginUser(Sys_BaseUser sys_BaseUser);

	public Sys_User getSysUserById(String userId);
}
