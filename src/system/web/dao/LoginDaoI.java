package system.web.dao;

import system.core.dao.BaseDaoI;

public interface LoginDaoI extends BaseDaoI{
	public String checkUser(String userName);
}
