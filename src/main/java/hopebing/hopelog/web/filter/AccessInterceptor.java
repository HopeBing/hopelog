package hopebing.hopelog.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import hopebing.hopelog.service.model.UserContext;



/**
 * 
 * @author hopebing
 *
 */
public class AccessInterceptor extends HandlerInterceptorAdapter {
	private static final Logger log = Logger.getLogger(AccessInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String requestURI = request.getRequestURI();
		String toLogin = request.getRequestURL().toString();
		String doName = request.getServletPath();
		if(doName != null && doName.contains("WEB-INF")){
			return true;
		}
		String cannotAccess = toLogin.substring(0,
				toLogin.length() - doName.length())
				+ "/login.do";
		UserContext user = (UserContext) request.getSession().getAttribute(
				"user");
		if (user == null) {
			if (requestURI.endsWith("/login.do")||requestURI.endsWith("/test.do")) {
				return true;
			} else {
				log.warn("����ķ���ҳ�档requestURI:" + requestURI);
				response.sendRedirect(cannotAccess);
				return false;
			}
		} else {
			return true;
		}
	}

}
