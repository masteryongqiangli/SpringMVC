package system.web.service.impl.baseUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import system.core.service.impl.CommonServiceImpl;
import system.core.util.ResourceUtil;
import system.web.dao.baseUser.Sys_BaseUserDaoI;
import system.web.entity.baseUser.Sys_BaseUser;
import system.web.entity.user.Sys_User;
import system.web.service.baseUser.Sys_BaseUserServiceI;
@Service("sys_BaseUserService")
@Transactional
public class Sys_BaseUserServiceImpl extends CommonServiceImpl implements Sys_BaseUserServiceI{
	@Autowired
	Sys_BaseUserDaoI Sys_BaseUserDaoI;
	@Override
	
	public Sys_BaseUser getLoginUser(Sys_BaseUser sys_BaseUser) {
		return Sys_BaseUserDaoI.getLoginUser(sys_BaseUser);
	}

	@Override
	public Sys_User getSysUserById(String userId) {
		return Sys_BaseUserDaoI.getSysUserById(userId).get(0);
	}

	@Override
	public void logout() {
	 ResourceUtil.Session().invalidate();
	}
	
}
