package system.web.controller.menu;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.core.annotation.Log;
import system.core.util.QueryParmFormat;
import system.web.entity.menu.Sys_BaseMenu;
import system.web.service.menu.Sys_BaseMenuServiceI;

@Controller
@RequestMapping("/sys_BaseMenuController")
@Scope("prototype")
public class Sys_BaseMenuController {
	@Autowired
	Sys_BaseMenuServiceI sys_BaseMenuServiceI;
	
	@RequestMapping(params="getMenuList")
	@ResponseBody
	@Log(operationName="��ѯ�˵�",operationType=0)
	public JSONArray getMenuList(HttpServletRequest request){
		return sys_BaseMenuServiceI.getMenuList();
	}
	@ResponseBody
	@RequestMapping(params="list")
	@Log(operationName="��ת�˵�ҳ��",operationType=0)
	public ModelAndView list(HttpServletRequest request){
		return new ModelAndView("system/menu/menuList");
	}
	@ResponseBody
	@RequestMapping(params="dataGrid")
	@Log(operationName="��������",operationType=0)
	public JSONObject dataGrid(HttpServletRequest request){
		return sys_BaseMenuServiceI.getMenuDataGrid();
	}
	@ResponseBody
	@RequestMapping(params="goAddorUpdate")
	@Log(operationName="��תҳ��",operationType=0)
	public ModelAndView goAddorUpdate(HttpServletRequest request,Sys_BaseMenu sys_BaseMenu){
		if (sys_BaseMenu.getMenuID()!=null) {
			request.setAttribute("menu", sys_BaseMenuServiceI.getMenuById(sys_BaseMenu.getMenuID()));
		}
		return new ModelAndView("system/menu/menu-addAndUpdate");
	}
}
