package system.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import system.core.enums.LoginStateTypeEnum;
import system.web.entity.base.Sys_Base_Role;
import system.web.entity.base.Sys_User;
/**
 * 
 * @author yongqiangli
 */
public class ResourceUtil {
	/**
	 * ��ȡ����·��
	 * @param request
	 * @return
	 */
	public static String getRequestPath(HttpServletRequest request) {
		String requestPath = request.getRequestURI()+ "?" + request.getQueryString();//loginController.do?list
		if (requestPath.indexOf("&") > -1) {// ȥ����������
			requestPath = requestPath.substring(0, requestPath.indexOf("&"));
		}
		requestPath = requestPath.substring(request.getContextPath().length() + 1);// ȥ����Ŀ·��
		return requestPath;
	}
	/**
	 * ���springmvc��HttpServletRequest
	 * @return
	 */
	public static HttpServletRequest getRequest(){
		return  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	/**
	 * ���springmvc��HttpSession
	 * @return
	 */
	public static HttpSession Session(){
		return getRequest().getSession();
	}
	/**
	 * ��õ�ǰ�û�
	 * @return
	 */
	public static Sys_User getSys_User(){
		return (Sys_User) getRequest().getSession().getAttribute(LoginStateTypeEnum.LOGIN_SUCCESS.getCode());
	}
	public static List<Sys_Base_Role> getSys_UserRoles() {
		List<Sys_Base_Role> list =new ArrayList<>();
		String ids[]=getSys_User().getRoleIdList().split(",");
		for (int i = 0; i < ids.length; i++) {
			Sys_Base_Role role=new Sys_Base_Role();
			role.setRoleId(ids[i]);
			list.add(role);
		}
		return list;
	}
	public static List<String> getSys_UserRoleList() {
		return Arrays.asList(getSys_User().getRoleCodeList());
	}
}
