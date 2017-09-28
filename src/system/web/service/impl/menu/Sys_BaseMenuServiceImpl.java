package system.web.service.impl.menu;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import system.core.service.impl.CommonServiceImpl;
import system.web.dao.menu.Sys_BaseMenuDaoI;
import system.web.entity.menu.Sys_BaseMenu;
import system.web.service.menu.Sys_BaseMenuServiceI;
@Service("sys_BaseMenuServiceI")
@Transactional
public class Sys_BaseMenuServiceImpl extends CommonServiceImpl implements Sys_BaseMenuServiceI{
	@Autowired
	Sys_BaseMenuDaoI sys_BaseMenuDaoI;
	
	@Override
	public JSONArray getMenuList() {
		List<Sys_BaseMenu> menuList = sys_BaseMenuDaoI.getMenuList();
		JSONArray array = new JSONArray();
		for (int i = 0; i < menuList.size(); i++) {
			if (menuList.get(i).getParentMenuID()==null) {
				JSONObject jsonObject2 = JSONObject.fromObject(menuList.get(i));
				JSONArray jsonArray = new JSONArray();
				for (int j = 0; j < menuList.size(); j++) {
					if (jsonObject2.get("menuID").equals(menuList.get(j).getParentMenuID())) {
						jsonArray.add(menuList.get(j));
					}
				}
				jsonObject2.put("sonMenu", jsonArray);
				array.add(jsonObject2);
				jsonObject2.clear();
			}
		}
		return array;
	}

	@Override
	public JSONObject getMenuDataGrid() {
		List<Sys_BaseMenu> menuList = sys_BaseMenuDaoI.getMenuList();
		JSONArray array = new JSONArray();
		for (int i = 0; i < menuList.size(); i++) {
			if (menuList.get(i).getParentMenuID()==null) {
				JSONObject jsonObject2 = JSONObject.fromObject(menuList.get(i));
				JSONArray jsonArray = new JSONArray();
				for (int j = 0; j < menuList.size(); j++) {
					if (jsonObject2.get("menuID").equals(menuList.get(j).getParentMenuID())) {
						jsonArray.add(JSONObject.fromObject(menuList.get(j)));
					}
				}
				jsonObject2.put("children", jsonArray);
				array.add(jsonObject2);
				jsonObject2.clear();
			}
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", array.size());
		jsonObject.put("rows", array);
		return jsonObject;
	}

	@Override
	public Sys_BaseMenu getMenuById(String menuID) {
		return sys_BaseMenuDaoI.getMenuById(menuID).get(0);
	}
}
