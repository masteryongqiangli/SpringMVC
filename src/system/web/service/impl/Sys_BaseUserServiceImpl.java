package system.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import system.core.service.impl.CommonServiceImpl;
import system.web.dao.Sys_BaseUserDaoI;
import system.web.entity.Sys_BaseUser;
import system.web.entity.Sys_User;
import system.web.service.Sys_BaseUserServiceI;
@Service("Sys_BaseUserServiceI")
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
		return null;
	}
	
}
