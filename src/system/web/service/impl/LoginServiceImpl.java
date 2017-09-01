package system.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import system.core.service.impl.CommonServiceImpl;
import system.web.dao.LoginDaoI;
import system.web.service.LoginServiceI;
@Service("LoginServiceI")
@Transactional
public class LoginServiceImpl extends CommonServiceImpl implements LoginServiceI{
	@Autowired
	LoginDaoI loginDaoI;
	public String checkUser(String userName) {
		return loginDaoI.checkUser(userName);
	}
}
