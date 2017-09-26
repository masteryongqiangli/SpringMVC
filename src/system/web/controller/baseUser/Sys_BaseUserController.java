package system.web.controller.baseUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import system.core.controller.BaseController;
import system.web.service.Sys_BaseUserServiceI;

@Controller
@RequestMapping(params="/sys_BaseUserController")
@Scope("prototype")
public class Sys_BaseUserController extends BaseController{
	@Autowired
	Sys_BaseUserServiceI sys_BaseUserServiceI;
}
