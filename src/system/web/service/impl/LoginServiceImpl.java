package system.web.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import system.core.service.impl.CommonServiceImpl;
import system.web.dao.LoginDaoI;
import system.web.entity.Sys_BaseUser;
import system.web.service.LoginServiceI;
@Service("LoginServiceI")
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
}