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

import cn.mldn.util.bean.ResourceUtil;
import cn.mldn.util.web.CookieUtil;
@WebFilter("/pages/*")
public class LoginFileter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request ;
		HttpSession session = req.getSession() ;
		if(session.getAttribute("mid") == null) { //用户未登录
			
			HttpServletResponse rep = (HttpServletResponse) response ;
			CookieUtil cu = new CookieUtil(req, rep) ;
			String loadMid = cu.loadMid() ;
			if(loadMid  != null) {
			}
			System.out.println("***");
			rep.sendRedirect(ResourceUtil.getPage("cn.mldn.action.LoginAction.check.error"));
		}else {
			chain.doFilter(request, response);
		}
		
	}

}
