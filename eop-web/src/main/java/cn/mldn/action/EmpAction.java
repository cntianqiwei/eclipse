package cn.mldn.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.mldn.service.IDeptService;
import cn.mldn.service.IEmpCareerService;
import cn.mldn.service.IEmpEducationService;
import cn.mldn.service.IEmpService;
import cn.mldn.service.ILevelService;
import cn.mldn.util.bean.ResourceUtil;
import cn.mldn.util.encrypt.EncryptUtil;
import cn.mldn.util.web.SplitPageUtil;
import cn.mldn.util.web.action.AbstractAction;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Controller;
import cn.mldn.util.web.annotation.RequestMapping;
import cn.mldn.util.web.servlet.ModelAndView;
import cn.mldn.util.web.servlet.ServletObjectUtil;
import cn.mldn.vo.Emp;
import cn.mldn.vo.EmpCareer;
import cn.mldn.vo.EmpEducation;
import cn.mldn.vo.Level;

@Controller
@RequestMapping("/pages/back/admin/emp/*")
public class EmpAction extends AbstractAction {
	@Autowired
	private IEmpService empService;
	@Autowired
	private IDeptService deptService;
	@Autowired
	private ILevelService levelService;
	@Autowired
	private IEmpEducationService empEducationService;
	@Autowired
	private IEmpCareerService empCareerService;
	@RequestMapping("emp_add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView("/pages/back/admin/emp/emp_add.jsp");
		Map<String,Object> map=null;
		try {
			map = this.empService.listPre();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.add("allDepts", map.get("allDepts"));
		mav.add("allLevels", map.get("allLevels"));
		return mav;
	} 
	@RequestMapping("emp_edit_pre")
	public ModelAndView editPre(String eid) {
		Map map=null;
		try {
			map=this.empService.editPre(eid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mv=new ModelAndView("/pages/back/admin/emp/emp_edit.jsp");
		mv.add("emp",map.get("emp"));
		mv.add("allDepts", map.get("allDepts"));
		mv.add("allLevels",map.get("allLevels"));
		return mv;
	} 
	@RequestMapping("emp_edit")
	public String edit(Emp emp,String pic) {
		emp.setIneid((String)ServletObjectUtil.getRequest().getSession().getAttribute("mid"));
		String photo=null;
		if(ServletObjectUtil.getParameter().isUpload()) {
			photo=(String)new ArrayList(ServletObjectUtil.getParameter().createUUIDFileName("photo")).get(0);
			@SuppressWarnings("deprecation")
			String realPath=ServletObjectUtil.getRequest().getRealPath("/");
			ServletObjectUtil.getParameter().saveUpload("photo", realPath+"upload/emp/"+photo);
		}else {
			photo=pic;
		}
		emp.setPhoto(photo);
		String oldPSW=emp.getPassword();
		String newPSW=EncryptUtil.encrypt(oldPSW);
		emp.setPassword(newPSW);
		Boolean flag=false;
		try {
			flag=this.empService.edit(emp);
		} catch (Exception e) {
			e.printStackTrace();
			ServletObjectUtil.getRequest().setAttribute("msg", "雇员修改失败！");
			ServletObjectUtil.getRequest().setAttribute("url", "\"emp_list.action\"");
			ServletObjectUtil.getRequest().setAttribute("urlClick", "\"/eop/pages/back/admin/emp/emp_list.action\"");
			return "/pages/plugins/forward.jsp" ; 
		}
		if(flag) {
			ServletObjectUtil.getRequest().setAttribute("msg", "雇员修改成功！");
			ServletObjectUtil.getRequest().setAttribute("url", "\"emp_list.action\"");
			ServletObjectUtil.getRequest().setAttribute("urlClick", "\"/eop/pages/back/admin/emp/emp_list.action\"");
			return "/pages/plugins/forward.jsp" ; 
		}else {
			ServletObjectUtil.getRequest().setAttribute("msg", "雇员修改失败！");
			ServletObjectUtil.getRequest().setAttribute("url", "\"emp_list.action\"");
			ServletObjectUtil.getRequest().setAttribute("urlClick", "\"/eop/pages/back/admin/emp/emp_list.action\"");
			return "/pages/plugins/forward.jsp" ; 
		}
	}
	@RequestMapping("emp_list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView(ResourceUtil.getPage("cn.mldn.action.EmpAction.list.page")) ;
		String columnData = "姓名:ename|简介:note" ;
		String url = "cn.mldn.action.EmpAction.list.action" ;
		SplitPageUtil spu = new SplitPageUtil(columnData, url);
		Map<String,Object> all=null;
		try {
			String mid=super.getMid();
			all=this.empService.list(spu.getCurrentPage(), spu.getLineSize(), spu.getColumn(), spu.getKeyword(),mid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.addMap(all);
		return mav ;
	}
	
	@RequestMapping("emp_check_eid")
	public void checkEid(String eid) {
		System.out.println(eid);
		boolean flag=false;
		try {
			flag=this.empService.getCheck(eid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag) {
			super.print("true");
		}else {
			super.print("flase");
		}
	}
	
	@RequestMapping("emp_check_salary")
	public void checkSalary(Integer lid,Double salary) {
		try {
			System.out.println(lid);
			Level level=this.levelService.get(lid);
			if(salary<level.getLosal()||salary>level.getHisal()) {
				super.print("false");
			}else {
				super.print("true");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("emp_add")
	public String add(Emp emp) {
		
		String photo=null;
		if(ServletObjectUtil.getParameter().isUpload()) {
			photo=(String)new ArrayList(ServletObjectUtil.getParameter().createUUIDFileName("photo")).get(0);
			@SuppressWarnings("deprecation")
			String realPath=ServletObjectUtil.getRequest().getRealPath("/");
			ServletObjectUtil.getParameter().saveUpload("photo", realPath+"upload/emp/"+photo);
		}else {
			photo="nophoto.png";
		}
		emp.setPhoto(photo);
		emp.setStatus(0);
		emp.setHiredate(new Date());
		emp.setIneid(super.getMid());
		String oldPSW=emp.getPassword();
		String newPSW=EncryptUtil.encrypt(oldPSW);
		emp.setPassword(newPSW);
		Boolean flag=false;
		try {
			flag=this.empService.add(emp);
		} catch (Exception e) {
			e.printStackTrace();
			ServletObjectUtil.getRequest().setAttribute("msg", "雇员增加失败！");
			ServletObjectUtil.getRequest().setAttribute("url", "\"emp_list.action\"");
			ServletObjectUtil.getRequest().setAttribute("urlClick", "\"/eop/pages/back/admin/emp/emp_list.action\"");
			return "/pages/plugins/forward.jsp" ; 
		}
		if(flag) {
			ServletObjectUtil.getRequest().setAttribute("msg", "雇员增加成功！");
			ServletObjectUtil.getRequest().setAttribute("url", "\"emp_list.action\"");
			ServletObjectUtil.getRequest().setAttribute("urlClick", "\"/eop/pages/back/admin/emp/emp_list.action\"");
			return "/pages/plugins/forward.jsp" ; 
		}else {
			ServletObjectUtil.getRequest().setAttribute("msg", "雇员增加失败！");
			ServletObjectUtil.getRequest().setAttribute("url", "\"emp_list.action\"");
			ServletObjectUtil.getRequest().setAttribute("urlClick", "\"/eop/pages/back/admin/emp/emp_list.action\"");
			return "/pages/plugins/forward.jsp" ; 
		}
//		ServletObjectUtil.getRequest().setAttribute("msg", "雇员信息增加成功！");s
//		return ResourceUtil.getPage("forward.page");
	}
	@RequestMapping("emp_remove")
	public void remove(String ids) {
		String[] idArray=ids.split(",");
		boolean flag=false;
		List<String> idList=Arrays.asList(idArray);
		try {
			flag=this.empService.deleteByIds(idList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.print(flag);
	}
	@RequestMapping("emp_detail")
	public void detail(String id) {
		Emp emp=null;
		try {
			emp=this.empService.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("emp_simple_details")
	public void simpleDetails(String eid) {
		Map<String,Object> all=null;
		try {
			all=this.empService.getSimpleDetails(eid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String data=JSON.toJSONString(all);
		System.out.println(data);
		super.print(data);
	}
	@RequestMapping("emp_compelete_details")
	public void compeleteDetails(String eid) {
		String mid=super.getMid();
		Map<String,Object> all=null;
		try {
			all=this.empService.getCompeleteDetails(eid,mid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String data=JSON.toJSONString(all);
		System.out.println(data);
		super.print(data);
		JSONArray jsonArray=JSON.parseObject(data).getJSONArray("allEmpEducations");
		System.out.println(jsonArray);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//---------------------------------------------emp_edu分割线---------------------------------
	
	
	/**
	 * 增加雇员教育经历
	 * @param vo 雇员教育经历
	 * @return 增加成功返回雇员教育经历列表页
	 */
	@RequestMapping("emp_edu_add")
	public void eduAdd(EmpEducation vo) {
		boolean flag=false;
		try {
			flag=this.empEducationService.add(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.print(flag);;
	}
	@RequestMapping("emp_edu_list")
	public ModelAndView eduList(String eid) {
		ModelAndView mv=new ModelAndView("/pages/back/admin/emp/emp_edu_list.jsp");
		List<EmpEducation> all=null;
		try {
			all=this.empEducationService.getByEid(eid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.add("allEmpEducations", all);
		return mv;
	}
	@RequestMapping("emp_edu_edit_pre")
	public void eduEditPre(Long eeduid) {
		EmpEducation vo=null;
		try {
			vo=this.empEducationService.get(eeduid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String json=JSON.toJSONString(vo);
		super.print(json);
	}
	@RequestMapping("emp_edu_delete")
	public void eduDelete(String ids) {
		String[] stringID=ids.split(",");
		Long[] longID=new Long[stringID.length];
		for(int x=0;x<stringID.length;x++) {
			longID[x]=Long.parseLong(stringID[x]);
		}
		List<Long> idList=Arrays.asList(longID);
		Set<Long> idSet=new HashSet<Long>(idList);
		boolean flag=false;
		try {
			flag=this.empEducationService.delete(idSet);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.print(flag);
	}
	@RequestMapping("emp_edu_edit")
	public void eduEdit(EmpEducation vo) {
		System.out.println(vo.getDegree()+" "+vo.getGraduation()+" "+vo.getNote()+" "+vo.getEntrance());
		System.out.println(new java.sql.Date(vo.getGraduation().getTime()));
		System.out.println(new java.sql.Date(vo.getEntrance().getTime()));
		boolean flag=false;
		try {
			flag=this.empEducationService.edit(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.print(flag);
	}
	
	
	
	
	
	
	
	
	
	//---------------------------------------------emp_career分割线--------------------------------------------
	@RequestMapping("emp_career_list")
	public ModelAndView careerList(String eid) {
		ModelAndView mv=new ModelAndView("emp_career_list.jsp");
		List<EmpCareer> allEmpCareers=null;
		try {
			allEmpCareers=this.empCareerService.getByEid(eid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.add("allEmpCareers",allEmpCareers );
		return mv;
	}
	@RequestMapping("emp_career_add")
	public void careerAdd(EmpCareer vo) {
		boolean flag=false;
		try {
			flag=this.empCareerService.add(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.print(flag);
	}
	@RequestMapping("emp_career_edit_pre")
	public void careerEditPre(Long ecarid) {
		EmpCareer vo=null;
		try {
			vo=this.empCareerService.get(ecarid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String data=JSON.toJSONString(vo);
		super.print(data);
	}
	@RequestMapping("emp_career_edit")
	public void careerEdit(EmpCareer vo) {
		boolean flag=false;
		try {
			flag=this.empCareerService.edit(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.print(flag);
	}
	@RequestMapping("emp_career_delete")
	public void careerDelete(String ecarids) {
		String[] stringIds=ecarids.split(",");
		Long[] longIds=new Long[stringIds.length];
		for(int x=0;x<stringIds.length;x++) {
			longIds[x]=Long.parseLong(stringIds[x]);
		}
		List<Long> listIds=Arrays.asList(longIds);
		Set<Long> setIds=new HashSet<Long>(listIds);
		boolean flag=false;
		try {
			flag=this.empCareerService.delete(setIds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.print(flag);
	}
}
