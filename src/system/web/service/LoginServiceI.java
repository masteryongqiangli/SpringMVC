package system.web.service;

import system.core.service.CommonServiceI;

public interface LoginServiceI extends CommonServiceI{
	public String checkUser(String userName);
}
