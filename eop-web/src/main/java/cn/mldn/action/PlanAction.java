package cn.mldn.action;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import com.alibaba.fastjson.JSON;
import cn.mldn.service.IDeptService;
import cn.mldn.service.IDictionaryService;
import cn.mldn.service.IPlanService;
import cn.mldn.util.web.SplitPageUtil;
import cn.mldn.util.web.action.AbstractAction;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Controller;
import cn.mldn.util.web.annotation.RequestMapping;
import cn.mldn.util.web.servlet.ModelAndView;
import cn.mldn.vo.Plan;

@Controller
@RequestMapping("/pages/back/admin/plan/*")
public class PlanAction extends AbstractAction {
	@Autowired
	private IDictionaryService dictionaryService ;
	@Autowired
	private IPlanService planService ; 
	@Autowired
	private IDeptService deptService ;
	
	@RequestMapping("plan_add_pre")
	public ModelAndView addPre() {
		//增加前的类型准备
		ModelAndView mav = new ModelAndView(super.getPage("add.pre")) ;
		try {
			mav.add("allDictionarys", dictionaryService.findByType("plan"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav ;
	} 
	
	@RequestMapping("plan_add")
	public ModelAndView add(Plan plan) {
		//跳转到增加页面，并显示信息
		plan.setEid(super.getMid());
		ModelAndView mav = new ModelAndView(super.getPage("add.action")) ;
		try {
			if (planService.add(plan)) {
				mav.add("msg", "添加成功!");
			}else {
				mav.add("msg", "添加失败!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav ;
	}
	@RequestMapping("plan_history_list")
	public ModelAndView list() {
		//跳转到分页列表页面
		ModelAndView mav = new ModelAndView(super.getPage("list.page")) ;
		//分页工具设置模糊查询列的标签 ，重新调用本方法以重新设置request属性范围
		SplitPageUtil spu = new SplitPageUtil("任务名称:title|发起人:eid|任务类型:item", super.getPageKey("list.action"));
		try {
			//map集合包括所有的记录数allRecorders和查询结果集合allPlans
			mav.addMap(planService.list(spu.getCurrentPage(), spu.getLineSize(), spu.getColumn(), spu.getKeyword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav ;
	}
	
	@RequestMapping("plan_history_delete")
	public void delete(String ids) {
		Set<Long> pids =  super.handleIdToLong(ids) ;
		try {
			Map<String,Object> result = new HashMap<String,Object>() ;
			result.put("flag", planService.delete(pids)) ;
			super.print(JSON.toJSONString(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("plan_history_publish")
	public void publish(long pid) {
		try {
			Map<String,Object> result = new HashMap<String,Object>() ;
			result.put("flag", planService.editStatusById(pid, 1)) ;
			super.print(JSON.toJSONString(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//pages/back/admin/plan/plan_details_list.jsp
	@RequestMapping("plan_details_pre")
	public ModelAndView listDetailsPre(long pid) {
		ModelAndView mav = new ModelAndView(super.getPage("details.page")) ;
		try {
			mav.addMap(planService.findById(pid));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav ;
	}
	
		@RequestMapping("plan_details_delete")
		public void deleteEmp(long pid,String eid) {
			
			try {
				Map<String,Object> result = new HashMap<String,Object>() ;
				//删除一个参与人员
				result.put("flag", planService.editAmount(pid, eid, -1)) ;
				super.print(JSON.toJSONString(result));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//model界面的部门异步查询
		@RequestMapping("plan_details_modal_pre")
		public void addEmpPre(long did) {
			try {
				//super.getMid()  假定当前权限账号为:mldn-president 
				Map<String, Object> map = planService.addEmpPre("mldn-sale", did);
				String json1 = JSON.toJSONString(map) ;
				super.print(json1);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//model界面的部门异步添加员工
		@RequestMapping("plan_details_modal_add")
		public void addEmp(long pid,String eid) {
			try {
				super.print(JSON.toJSONString(planService.editAmount(pid, eid, 1)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		
		
		
		
		
		
		
		
		
		
		
		
}
