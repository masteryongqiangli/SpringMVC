package system.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import system.core.util.ResourceUtil;
/**
 * Ȩ������
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
		String requestPath = ResourceUtil.getRequestPath(request);// �û����ʵ���Դ��ַ
		if (excludeUrls.contains(requestPath)||ResourceUtil.getSys_User()!=null) {//��������·�������û��Ѿ���¼
			return true;
		} else {
			forward(request, response);
			return false;
		}
	}
	
}
