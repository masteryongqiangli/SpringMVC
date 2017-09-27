package system.web.controller.menu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import system.core.annotation.Log;
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
	@Log(operationName="≤È—Ø≤Àµ•",operationType=0)
	public JSONArray getMenuList(HttpServletRequest request){
		return sys_BaseMenuServiceI.getMenuList();
	}
}
