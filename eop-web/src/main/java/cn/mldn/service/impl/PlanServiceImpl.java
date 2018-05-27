package cn.mldn.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.dao.IDeptDAO;
import cn.mldn.dao.IEmpDAO;
import cn.mldn.dao.ILevelDAO;
import cn.mldn.dao.IPlanDAO;
import cn.mldn.dao.IPlanDetailsDAO;
import cn.mldn.service.IPlanService;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
import cn.mldn.util.web.servlet.ServletObjectUtil;
import cn.mldn.vo.Dept;
import cn.mldn.vo.Emp;
import cn.mldn.vo.Level;
import cn.mldn.vo.Plan;
@Service
public class PlanServiceImpl extends AbstractService implements IPlanService {
	@Autowired
	private IPlanDAO planDAO ;
	@Autowired
	private IPlanDetailsDAO PlanDetailsDAO ;
	@Autowired
	private IDeptDAO deptDAO ;
	@Autowired
	private ILevelDAO levelDAO ;
	@Autowired
	private IEmpDAO empDAO ;
	@Override
	public boolean add(Plan plan) throws Exception {
		Map<String,String> errors = new HashMap<String,String>() ;
		if(plan == null) {
			return false ;
		}
		if(plan.getStarttime().getTime() < new Date().getTime()) {
			errors.put("starttime_error", "任务开始日期不能在当前日期之前！") ;
			ServletObjectUtil.getRequest().setAttribute("errors",errors);
			return false ;
		}
		if(plan.getStarttime().getTime() > plan.getEndtime().getTime()) {
			errors.put("starttime_error", "任务开始日期不能大于结束日期！") ;
			ServletObjectUtil.getRequest().setAttribute("errors",errors);
			return false ;
		}
		plan.setStatus(0); //新增计划设置为草稿状态
		plan.setAmount(0); //初始化0个人参与
		return planDAO.doCreate(plan) ;
	}

	@Override
	public Map<String, Object> list(Long currentPage, Integer lineSize, String column, String keyWord)
			throws Exception {
		Map<String, Object> map = new HashMap<>() ;
		if (super.isSearch(column, keyWord)) {
			map.put("allPlans", planDAO.findSplit(currentPage, lineSize, column, keyWord)) ;
			map.put("allRecorders", planDAO.getAllCount(column, keyWord))  ;
		}else {
			map.put("allPlans", planDAO.findSplit(currentPage, lineSize)) ;
			map.put("allRecorders",planDAO.getAllCount()) ;
		}
		return map ;
	}

	@Override
	public boolean delete(Set<Long> ids) throws Exception {
		if(ids == null || ids.size() == 0) {
			return false ;
		}
		return planDAO.doRemove(ids) ;
	}

	@Override
	public boolean editStatusById(long pid, int status) throws Exception {
		return planDAO.doEditStatusById(pid, status) ;
	}

	@Override
	public Map<String, Object> findById(long pid) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>() ;
		map.put("plan", planDAO.findById(pid)) ;
		map.put("allEmps", planDAO.findEmpbyPid(pid)) ;
		
		
		Map<Integer, String> levelMap = new HashMap<Integer,String>() ;
		List<Level> allLevels = levelDAO.findAll() ;
		for(Level vo : allLevels) {
			levelMap.put(vo.getLid(), vo.getTitle()) ;
		}
		map.put("allLevels", levelMap) ;
		Map<Long, String> deptMap = new HashMap<Long,String>() ;
		List<Dept> allDepts = deptDAO.findAll();
		for(Dept vo : allDepts) {
			deptMap.put(vo.getDid(), vo.getDname()) ;
		}
		map.put("allDepts", deptMap) ;
		
		return map;
	}

	@Override
	public Map<String,Object> editAmount(long pid, String eid, int count) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>() ;
		if(eid == null) {
			map.put("flag", false) ;
			map.put("msg", "非法eid,空值") ;
			return map ;
		}
		if (count > 0) {
			//增加参与人员
			//1，不能重复添加参与人员。
			if(PlanDetailsDAO.findByPidAndEid(pid, eid)) {
				map.put("flag", false) ;
				map.put("msg", "该员工已加入该项任务！") ;
				return map ;
			}
			//2，如果该员工有任务，则该员工同一时间不能被安排多个任务
			if(PlanDetailsDAO.findByEid(eid)) {
				if(planDAO.timeConflict(eid, planDAO.findById(pid))) {
					map.put("flag", false) ;
					map.put("msg", "该员工当前时段已经有任务安排！") ;
					return map ;
				}
			}
			//真实增加业务
			if(PlanDetailsDAO.doCreateByPidAndEid(pid, eid)) {
				if(planDAO.doEditAmout(pid, count)) {
					map.put("flag", true) ;
					map.put("msg", "添加成功！") ;
					return map ;
				}
			}
		} else { //删除参与人员
			if(PlanDetailsDAO.doRemoveByPidAndEid(pid, eid)) {
				if(planDAO.doEditAmout(pid, count)) {
					map.put("flag", true) ;
					map.put("msg", "删除成功！") ;
					return map ;
				} 
			}
			map.put("flag", false) ;
			map.put("msg", "删除失败") ;
			return map ;
		}
		map.put("flag", false) ;
		map.put("msg", "操作失败！未知的原因") ;
		return map ;
	}
	
	@Override
	public Map<String, Object> addEmpPre(String eid, long did) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>() ;
		List<Emp> allEmps = empDAO.findByEidAndDid(eid, did);
		map.put("allEmps", allEmps) ;
		//map.put("allLevels", levelDAO.findByEmps(allEmps)) ;
		map.put("allLevels", levelDAO.findAll()) ;
		return map;
	}

}
