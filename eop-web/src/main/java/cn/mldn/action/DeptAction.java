package cn.mldn.action;

import java.io.IOException;
import java.util.Map;

import cn.mldn.service.IDeptService;
import cn.mldn.util.web.action.AbstractAction;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Controller;
import cn.mldn.util.web.annotation.RequestMapping;
import cn.mldn.util.web.servlet.ModelAndView;
import cn.mldn.util.web.servlet.ServletObjectUtil;
import cn.mldn.vo.Dept;
@Controller 
@RequestMapping("/pages/back/admin/dept/*")
public class DeptAction extends AbstractAction{
	@Autowired
	private IDeptService deptService ;  
	
	@RequestMapping("dept_add_pre")
	public String addPre() { 
		return "/pages/back/admin/dept/dept_add.jsp" ; 
	}
	@RequestMapping("dept_add")
	public String add(Dept dept) { 
		dept.setCurrnum(0);
		boolean flag=false;
		try {
			flag=this.deptService.add(dept) ;
		} catch (Exception e) {
			e.printStackTrace();
			ServletObjectUtil.getRequest().setAttribute("msg", "部门增加失败！");
			ServletObjectUtil.getRequest().setAttribute("url", "\"dept_list.action\"");
			ServletObjectUtil.getRequest().setAttribute("urlClick", "\"/eop/pages/back/admin/dept/dept_list.action\"");
			return "/pages/plugins/forward.jsp" ; 
		}
		if(flag) {
			ServletObjectUtil.getRequest().setAttribute("msg", "部门增加成功！");
			ServletObjectUtil.getRequest().setAttribute("url", "\"dept_list.action\"");
			ServletObjectUtil.getRequest().setAttribute("urlClick", "\"/eop/pages/back/admin/dept/dept_list.action\"");
			return "/pages/plugins/forward.jsp" ; 
		}else {
			ServletObjectUtil.getRequest().setAttribute("msg", "部门增加失败！");
			ServletObjectUtil.getRequest().setAttribute("url", "\"dept_list.action\"");
			ServletObjectUtil.getRequest().setAttribute("urlClick", "\"/eop/pages/back/admin/dept/dept_list.action\"");
			return "/pages/plugins/forward.jsp" ; 
		}
	}
	@RequestMapping("dept_list") 
	public ModelAndView list() throws Exception {
		ModelAndView mav = new ModelAndView("/pages/back/admin/dept/dept_list.jsp") ;
		String mid=super.getMid();
		Map<String,Object> all=this.deptService.listDeptAndCount(mid);
		mav.add("allRecorders", all.get("allRecorders"));
		mav.add("allDepts", all.get("allDepts"));
		mav.add("allEmps", all.get("allEmps"));
		mav.add("operate", all.get("operate"));
		return mav ;
	}
	@RequestMapping("dept_info") 
	public void info() {
		try {
			ServletObjectUtil.getResponse().getWriter().println("www.mldn.cn");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("dept_edit") 
	public void edit(Dept vo) { 
		boolean flag=false;
		try {
			flag=this.deptService.edit(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ServletObjectUtil.getResponse().setContentType("text/html");
			super.print(flag) ; 
		}
		if(flag) {
			super.print(flag) ;
		}else {
			
			super.print(flag) ; 
		}
	}
}
