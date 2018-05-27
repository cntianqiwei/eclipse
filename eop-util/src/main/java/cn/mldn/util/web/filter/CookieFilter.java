package cn.mldn.util.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.mldn.util.web.CookieUtil;
import cn.mldn.util.web.PrivilegeUtil;
@WebFilter("/*")
public class CookieFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request ;
		HttpSession session = req.getSession();
		if(session.getAttribute("mid") == null) {
			HttpServletResponse resp = (HttpServletResponse) response;
			CookieUtil cu = new CookieUtil(req, resp) ;
			String loadMid = cu.loadMid();
			if(loadMid != null) {
				session.setAttribute("mid", loadMid);
				session.setAttribute("privilege", PrivilegeUtil.getPrivilege().get(loadMid));
			}
		}
		
		chain.doFilter(request, response);
		
	}

}
