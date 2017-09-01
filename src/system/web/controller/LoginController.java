package system.web.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.core.annotation.Log;
import system.web.entity.Sys_BaseUser;
import system.web.service.LoginServiceI;

@Controller
public class LoginController {
	
	LoginServiceI loginServiceI;
	/**
	 * ��֤�û����Ƿ����
	 * @param request
	 * @return {@link JSONObject}
	 */
	@RequestMapping(params="checkUser")
	@ResponseBody
	@Log(operationName="��֤�û���",operationType=1)
	public Sys_BaseUser checkUser(HttpServletRequest request,Sys_BaseUser sys_BaseUser){
		Sys_BaseUser loginUser = loginServiceI.checkLogin(sys_BaseUser,request);
		return loginUser;
	}
	/**
	 * ϵͳ��¼
	 * @param request
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(params="login")
	@ResponseBody
	@Log(operationName="��ת��¼ҳ��",operationType=1)
	public ModelAndView login(HttpServletRequest request){
		return new ModelAndView("system/main/main");
	}
}
