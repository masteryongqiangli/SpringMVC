package system.web.dao.menu;

import java.util.List;

import net.sf.json.JSONObject;
import system.core.dao.BaseDaoI;
import system.web.entity.menu.Sys_BaseMenu;

public interface Sys_BaseMenuDaoI extends BaseDaoI{

	public List<Sys_BaseMenu> getMenuList();

}
