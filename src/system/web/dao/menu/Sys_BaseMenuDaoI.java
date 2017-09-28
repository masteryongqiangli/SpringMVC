package system.web.dao.menu;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import system.core.dao.BaseDaoI;
import system.web.entity.menu.Sys_BaseMenu;

public interface Sys_BaseMenuDaoI extends BaseDaoI{

	public List<Sys_BaseMenu> getMenuList();

	public List<Sys_BaseMenu> getMenuById(String menuID);

}
