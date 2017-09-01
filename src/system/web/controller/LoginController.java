package system.web.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.core.annotation.Log;
import system.core.controller.BaseController;
import system.web.service.LoginServiceI;

@Controller
@RequestMapping(params="loginController")
@Scope("prototype")
public class LoginController extends BaseController{
	@Autowired
	LoginServiceI loginServiceI;
	/**
	 * ��֤�û����Ƿ����
	 * @param request
	 * @return {@link JSONObject}
	 */
	@RequestMapping(params="checkUser")
	@ResponseBody
	public JSONObject checkUser(HttpServletRequest request){
		/*Sys_BaseUser loginUser = loginServiceI.checkLogin(sys_BaseUser,request);
		return loginUser;*/
		JSONObject jsonObject = new JSONObject();
		return jsonObject;
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
