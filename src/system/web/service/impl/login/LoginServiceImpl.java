package system.web.service.impl.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import system.core.service.impl.CommonServiceImpl;
import system.web.dao.login.LoginDaoI;
import system.web.entity.baseUser.Sys_BaseUser;
import system.web.entity.user.Sys_User;
import system.web.service.login.LoginServiceI;
@Service("loginService")
@Transactional
public class LoginServiceImpl extends CommonServiceImpl implements LoginServiceI{
	@Autowired
	LoginDaoI loginDaoI;

	@Override
	public Sys_BaseUser checkLogin(Sys_BaseUser sys_BaseUser,HttpServletRequest request) {
		Map<String, String> itemMap = new HashMap<String, String>();
		itemMap.put("userName", request.getParameter("userName"));
		return loginDaoI.checkLogin(sys_BaseUser,itemMap);
	}

	@Override
	public boolean checkUserName(String parameter) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkUserPswd(String endcoderByMd5Utile) {
		// TODO Auto-generated method stub
		return false;
	}
}
