package system.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import system.core.enums.loginStateTypeEnum;
import system.web.entity.role.Sys_BaseRole;
import system.web.entity.user.Sys_User;
/**
 * 
 * @author yongqiangli
 */
public class ResourceUtil {
	/**
	 * 获取请求路径
	 * @param request
	 * @return
	 */
	public static String getRequestPath(HttpServletRequest request) {
		String requestPath = request.getRequestURI()+ "?" + request.getQueryString();//loginController.do?list
		if (requestPath.indexOf("&") > -1) {// 去掉其他参数
			requestPath = requestPath.substring(0, requestPath.indexOf("&"));
		}
		requestPath = requestPath.substring(request.getContextPath().length() + 1);// 去掉项目路径
		return requestPath;
	}
	/**
	 * 获得springmvc下HttpServletRequest
	 * @return
	 */
	public static HttpServletRequest getRequest(){
		return  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	/**
	 * 获得springmvc下HttpSession
	 * @return
	 */
	public static HttpSession Session(){
		return getRequest().getSession();
	}
	/**
	 * 获得当前用户
	 * @return
	 */
	public static Sys_User getSys_User(){
		return (Sys_User) getRequest().getSession().getAttribute(loginStateTypeEnum.LOGIN_SUCCESS.getCode());
	}
	public static List<Sys_BaseRole> getSys_UserRoles() {
		List<Sys_BaseRole> list =new ArrayList<>();
		String ids[]=getSys_User().getRoleId().split(",");
		for (int i = 0; i < ids.length; i++) {
			Sys_BaseRole role=new Sys_BaseRole();
			role.setRoleId(ids[i]);
			list.add(role);
		}
		return list;
	}
	public static List<String> getSys_UserRoleList() {
		return Arrays.asList(getSys_User().getRoleCode());
	}
}
