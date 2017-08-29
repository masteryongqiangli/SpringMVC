package system.core.interceptor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import system.core.util.ResourceUtil;
/**
 * 权限拦截
 * @author yongqiangli
 */
public class AuthInterceptor implements HandlerInterceptor{
	private List<String> excludeUrls;
	
	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object o) throws Exception {
		String requestPath = ResourceUtil.getRequestPath(request);// 用户访问的资源地址
		if (excludeUrls.contains(requestPath)||ResourceUtil.getSys_User()!=null) {//包括拦截路径或者用户已经登录
			return true;
		} else {
			forward(request, response);
			return false;
		}
	}
	/**
	 * 登录界面从定向
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @author yongqiangli
	 */
	public ModelAndView forward(HttpServletRequest request){
		return new ModelAndView(new RedirectView("loginController.do?login"));
	}
	private void forward(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("webpages/system/login/login.jsp").forward(request, response);
	}
}
