package cn.mldn.action;

import cn.mldn.service.ILonginService;
import cn.mldn.util.encrypt.EncryptUtil;
import cn.mldn.util.web.CookieUtil;
import cn.mldn.util.web.action.AbstractAction;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Controller;
import cn.mldn.util.web.annotation.RequestMapping;
import cn.mldn.util.web.servlet.ModelAndView;
import cn.mldn.util.web.servlet.ServletObjectUtil;
import cn.mldn.vo.Emp;
@Controller
@RequestMapping("/login/*")
public class LoginAction extends AbstractAction {
	@Autowired
	private ILonginService loginService ;
	
	@RequestMapping("loginout")
	public ModelAndView loginOut() {
		ModelAndView mav = new ModelAndView(super.getForwardPage());
		ServletObjectUtil.getRequest().getSession().invalidate();
		CookieUtil cu = new CookieUtil(ServletObjectUtil.getRequest(), ServletObjectUtil.getResponse()) ;
		cu.cleanMid();
		mav.add("msg", "注销成功！");
		mav.add("url", super.getPage("check.error")) ;
		mav.add("urlClick", super.getPage("check.error")) ;
		return mav;
	}
	
	//异步验证码校验
	@RequestMapping("validatecode")
	public void validateCode(String code) {
		String realCode = (String)ServletObjectUtil.getRequest().getSession().getAttribute("rand") ;
		if(code == null || realCode == null) {
			super.print(false);
			return ;
		}
		super.print(realCode.equalsIgnoreCase(code));
	}
	
	//登录成功的导航显示
	@RequestMapping("login_pre")
	public ModelAndView listPre() {
		ModelAndView mav = new ModelAndView(super.getCommonPage("index.page")) ;
		return mav ;
	}
	
	//登录检测
	@RequestMapping("login_check")
	public ModelAndView check(Emp vo) {
		ModelAndView mav = new ModelAndView(super.getForwardPage()) ;
		vo.setPassword(EncryptUtil.encrypt(vo.getPassword()));
		try {
			//登录成功
			if(loginService.login(vo)) {
				//登录成功保存用户账号
				ServletObjectUtil.getRequest().getSession().setAttribute("mid", vo.getEid());
				CookieUtil cu = new CookieUtil(ServletObjectUtil.getRequest(), ServletObjectUtil.getResponse()) ;
				cu.saveMid(vo.getEid());
 				mav.add("msg", "登录成功！");
				mav.add("url", super.getPage("login.pre")) ;
				mav.add("urlClick", super.getPage("login.pre")) ;
			} else {
				mav.add("msg", "登录失败！错误的账号或密码");
				mav.add("url", super.getPage("check.error")) ;
				mav.add("urlClick", super.getPage("check.error")) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav ;
	}
	
}
