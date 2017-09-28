package system.web.service.menu;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import system.core.service.CommonServiceI;
import system.web.entity.menu.Sys_BaseMenu;

public interface Sys_BaseMenuServiceI extends CommonServiceI{

	public JSONArray getMenuList();

	public JSONObject getMenuDataGrid();

	public Sys_BaseMenu getMenuById(String menuID);

}
