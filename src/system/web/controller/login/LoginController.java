package system.web.controller.login;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.core.annotation.Log;
import system.core.controller.BaseController;
import system.core.enums.loginStateTypeEnum;
import system.core.util.EncoderByMd5Util;
import system.web.entity.Sys_BaseUser;
import system.web.entity.Sys_User;
import system.web.service.LoginServiceI;
import system.web.service.Sys_BaseUserServiceI;

@Scope("prototype")
@RequestMapping("/loginController")
@Controller
public class LoginController extends BaseController{
	@Autowired
	LoginServiceI LoginServiceI;
	@Autowired
	Sys_BaseUserServiceI Sys_BaseUserServiceI;
	/**
	 * 系统登录
	 * @param request
	 */
	@RequestMapping(params="login")
	@ResponseBody
	@Log(operationName="跳转登录页面",operationType=1)
	public ModelAndView login(HttpServletRequest request){
		return new ModelAndView("system/main/main");
	}
	/**
	 * 验证用户名是否存在
	 * @param request
	 * @return 
	 */
	@SuppressWarnings({ "static-access" })
	@RequestMapping(params="checkLogin")
	@ResponseBody
	public JSONObject checkLogin(HttpServletRequest request,Sys_BaseUser sys_BaseUser){
		JSONObject jsonObject = new JSONObject();
		Sys_BaseUser loginUser = Sys_BaseUserServiceI.getLoginUser(sys_BaseUser);
		if (loginUser!=null) {
			EncoderByMd5Util byMd5Util = new EncoderByMd5Util();
			if (loginUser.getPassWord().equals((byMd5Util.endcoderByMd5Utile(sys_BaseUser.getPassWord())))) {
				Sys_User sys_User = Sys_BaseUserServiceI.getSysUserById(loginUser.getUserId());
				request.getSession().setAttribute(loginStateTypeEnum.LOGIN_SUCCESS.getCode(), sys_User);
				jsonObject.put("msg", loginStateTypeEnum.LOGIN_SUCCESS);
			}else{
				jsonObject.put("msg", loginStateTypeEnum.ERROR_PASSWD);
			}
		}else{
			jsonObject.put("msg", loginStateTypeEnum.NO_USER);
		}
		return jsonObject;
	}
}
