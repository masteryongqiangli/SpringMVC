package system.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class loginController {
	@RequestMapping(params="login")
	@ResponseBody
	public ModelAndView login(HttpServletRequest request){
		return new ModelAndView("system/main/main");
	}
}
