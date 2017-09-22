package system.web.controller;

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
import system.web.service.LoginServiceI;

@Controller
@RequestMapping(params="/loginController")
@Scope("prototype")
public class LoginController extends BaseController{
	@Autowired
	LoginServiceI loginServiceI;
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
	/**
	 * ��֤�û����Ƿ����
	 * @param request
	 * @return 
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(params="checkLogin")
	@ResponseBody
	public JSONObject checkLogin(HttpServletRequest request){
		JSONObject jsonObject = new JSONObject();
		if (loginServiceI.checkUserName(request.getParameter("userName"))) {
			EncoderByMd5Util byMd5Util = new EncoderByMd5Util();
			if (loginServiceI.checkUserPswd(byMd5Util.endcoderByMd5Utile(request.getParameter("userPswd")))) {
				
			}else{
				jsonObject.put("msg", loginStateTypeEnum.ERROR_PASSWD);
			}
		}else{
			jsonObject.put("msg", loginStateTypeEnum.NO_USER);
		}
		return jsonObject;
	}
}
