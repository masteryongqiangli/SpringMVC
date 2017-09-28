package system.web.dao.impl.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import system.core.dao.impl.BaseDaoImpl;
import system.web.dao.menu.Sys_BaseMenuDaoI;
import system.web.entity.menu.Sys_BaseMenu;
@Repository
public class Sys_BaseMenuDaoImpl extends BaseDaoImpl implements Sys_BaseMenuDaoI{

	@Override
	public List<Sys_BaseMenu> getMenuList() {
		Map<String, String> dataMap = new HashMap<String, String>();
		Map<String, String> pageMap = new HashMap<String, String>();
		dataMap.put("state", "1");
		return getListByItems(Sys_BaseMenu.class, dataMap, pageMap);
	}

	@Override
	public List<Sys_BaseMenu> getMenuById(String menuID) {
		Map<String, String> dataMap = new HashMap<String, String>();
		dataMap.put("menuID", menuID);
		dataMap.put("state", "1");
		Map<String, String> pageMap = new HashMap<String, String>();
		return getListByItems(Sys_BaseMenu.class, dataMap, pageMap);
	}
}
