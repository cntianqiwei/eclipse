package cn.mldn.action;

import java.util.Map;

import com.alibaba.fastjson.JSON;

import cn.mldn.service.IEmpResourceService;
import cn.mldn.service.IEmpService;
import cn.mldn.util.web.SplitPageUtil;
import cn.mldn.util.web.action.AbstractAction;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Controller;
import cn.mldn.util.web.annotation.RequestMapping;
import cn.mldn.util.web.servlet.ModelAndView;
import cn.mldn.util.web.servlet.ServletObjectUtil;
import cn.mldn.vo.Emp;
import cn.mldn.vo.EmpResource;
import cn.mldn.vo.Resource;
@Controller
@RequestMapping("/pages/back/admin/supply/*")
public class EmpResourceAction extends AbstractAction {
	@Autowired
	private IEmpResourceService erService;
	@Autowired
	private IEmpService empService;
//	@RequestMapping("supply_emp_apply_edit")
//	public ModelAndView editEmpResource(Long eresid,EmpResource vo)throws Exception{
//		ModelAndView mav = new ModelAndView(super.getPage("EmpResource.edit"));
//		boolean flag=false;
//		flag =this.erService.editEmpResource(eresid, vo);
//		mav.add("flag", flag);
//		return mav;
//	}
	@RequestMapping("supply_emp_apply_edit")
	public String editEmpResource(Long eresid,EmpResource vo) throws Exception{
		System.out.println(eresid);
		System.out.println(vo + "--");
		vo.setEid(super.getMid());
		if(this.erService.editEmpResource(eresid, vo)) {
			ServletObjectUtil.getRequest().setAttribute("msg", "审核成功！");
			ServletObjectUtil.getRequest().setAttribute("url", "supply_emp_apply_list.action");
			ServletObjectUtil.getRequest().setAttribute("urlClick", "/eop/pages/back/admin/supply/supply_emp_apply_list.action");
			return "/pages/plugins/forward1.jsp" ; 
		}else {
			ServletObjectUtil.getRequest().setAttribute("msg", "审核失败！");
			ServletObjectUtil.getRequest().setAttribute("url", "supply_emp_apply_list.action");
			ServletObjectUtil.getRequest().setAttribute("urlClick", "/eop/pages/back/admin/supply/supply_emp_apply_list.action");
			return "/pages/plugins/forward.jsp" ; 
		}
	}
	
	@RequestMapping("supply_emp_apply_list")
	public ModelAndView listEmpResource()throws Exception{
		ModelAndView mav = new ModelAndView(super.getPage("EmpResource.list"));
		String columnData = "申请名称:title";
		SplitPageUtil spu = new SplitPageUtil(columnData,super.getPageKey("EmpResource.action"));
		
		Map<String, Object> map = this.erService.listByEmpResource(spu.getCurrentPage(), spu.getLineSize(), spu.getColumn(), spu.getKeyword());
		mav.addMap(map);
		return mav;
	}
	@RequestMapping("supply_EmpResource_modal")
	public void modalEmp(String eid){
		String mid=super.getMid();
		Map<String,Object> all=null;
		try {
			all=this.empService.getCompeleteDetails(eid, mid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String data=JSON.toJSONString(all);
//		System.out.println(data);
		super.print(data);
	}
	@RequestMapping("supply_emp_apply_handle")
	public ModelAndView listHandel(Long eresid) throws Exception{
//		System.out.println(eresid);
		ModelAndView mav=new ModelAndView(super.getPage("EmpResourceDetails.list"));
		Map<String, Object> map = this.erService.handelByEresid(eresid);
		mav.addMap(map);
		return mav;
	}
	
	
	
	
}
