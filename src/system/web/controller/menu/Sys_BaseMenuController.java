package system.web.controller.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import system.web.service.menu.Sys_BaseMenuServiceI;

@Controller
@RequestMapping("/sys_BaseMenuController")
@Scope("prototype")
public class Sys_BaseMenuController {
	@Autowired
	Sys_BaseMenuServiceI sys_BaseMenuServiceI;
}
