package cn.mldn.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.mldn.dao.IDeptDAO;
import cn.mldn.dao.IEmpCareerDAO;
import cn.mldn.dao.IEmpDAO;
import cn.mldn.dao.IEmpEducationDAO;
import cn.mldn.dao.ILevelDAO;
import cn.mldn.service.IEmpService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
import cn.mldn.vo.Dept;
import cn.mldn.vo.Emp;
import cn.mldn.vo.EmpCareer;
import cn.mldn.vo.EmpEducation;
import cn.mldn.vo.Level;
@Service
public class EmpServiceImpl implements IEmpService {
	@Autowired
	private IEmpDAO empDAO;
	@Autowired
	private IDeptDAO deptDAO;
	@Autowired
	private ILevelDAO levelDAO;
	@Autowired
	private IEmpEducationDAO empEducationDAO;
	@Autowired
	private IEmpCareerDAO empCareerDAO;
	@Override
	public boolean add(Emp vo) throws Exception {
		
		if(this.deptDAO.findById(vo.getDid()).getCurrnum()>=this.deptDAO.findById(vo.getDid()).getMaxnum()) {
			return false;
		}
		Level level=this.levelDAO.findById(vo.getLid());
		if(vo.getSalary()<level.getLosal()||vo.getSalary()>level.getHisal()) {
			return false;
		}
		if(this.empDAO.doCreate(vo)) {
			if(vo.getLid()<3) {
				Dept dept=this.deptDAO.findById(vo.getDid());
				if(dept.getEid()!=null) {
					if(this.empDAO.findById(dept.getEid()).getLid()>=vo.getLid()) {//此时，原领导降一级，部门领导变更
						Emp oldHead=this.empDAO.findById(dept.getEid());
						if(oldHead.getLid()<4) { //原领导不是最末一级时降一级,工资变为下一级的最高工资
							oldHead.setLid(oldHead.getLid()+1);
							Level newLevel=this.levelDAO.findById(oldHead.getLid());
							oldHead.setSalary(newLevel.getHisal());
							this.empDAO.doEdit(oldHead);         
						}
						this.deptDAO.doEditEid(vo.getDid(), vo.getEid());
					}
				}
			}
			return this.deptDAO.doEditCurrnum(vo.getDid(), 1);
		}
		return false;
	}
	@Override
	public List<Emp> list() throws Exception {
		// TODO Auto-generated method stub
		return this.empDAO.findAll();
	}
	@Override
	public Map<String, Object> list(Long currentPage, Integer lineSize) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> all=new HashMap<String,Object>();
		all.put("allEmps", this.empDAO.findSplit(currentPage,lineSize));
		all.put("allRecorders", this.empDAO.getAllCount());
		return all;
	}
	@Override
	public Map<String, Object> list(Long currentPage, Integer lineSize, String column, String keyWord,String mid)
			throws Exception {
		Map<String,Object> all=new HashMap<String,Object>();
		if(column==null||"".equals(column)||keyWord==null||"".equals(keyWord)) {
			List<Emp> allEmps=this.empDAO.findSplit(currentPage,lineSize);
			all.put("allEmps", allEmps);
			all.put("allRecorders", this.empDAO.getAllCount());
			all.put("allDepts", this.deptDAO.findByEmp(allEmps));
			all.put("allLevels",this.levelDAO.findByEmps(allEmps));
		}else {
			List<Emp> allEmps=this.empDAO.findSplit(currentPage,lineSize,column,keyWord);
			all.put("allEmps", allEmps);
			all.put("allRecorders", this.empDAO.getAllCount(column,keyWord));
			all.put("allDepts", this.deptDAO.findByEmp(allEmps));
			all.put("allLevels",this.levelDAO.findByEmps(allEmps));
		}
		Emp operate=this.empDAO.findById(mid);
		all.put("operate", operate);
		return all;
	}
	@Override
	public Map<String, Object> listPre() throws Exception {
		List<Dept> allDepts=null;
		List<Level> allLevels=null;
		allDepts=this.deptDAO.findAll();
		allLevels=this.levelDAO.findAll();
		Map<String, Object> all=new HashMap<String,Object>();
		all.put("allDepts", allDepts);
		all.put("allLevels", allLevels);
		return all;
	}
	@Override
	public boolean deleteByIds(List<String> ids) throws Exception {
		// TODO Auto-generated method stub
		if(this.empDAO.doRemoveByIds(ids)) {
			List<Long> dids=this.empDAO.findDidsByEids(ids);
			Iterator iter=dids.iterator();
			int count=0;
			while(iter.hasNext()) {
				boolean flag=this.deptDAO.doEditCurrnum((Long)iter.next(),-1);
				if(!flag) {
					count++;
				}
			}
			return count==0;
		}
		return false;
	}
	@Override
	public Emp get(String id) throws Exception {
		return this.empDAO.findById(id);
	}
	@Override
	public Map<String, Object> editPre(String id) throws Exception {
		Map<String,Object> all=new HashMap<String,Object>();
		Emp emp=this.empDAO.findById(id);
		List<Dept> allDepts=this.deptDAO.findAll();
		List<Level> allLevels=this.levelDAO.findAll();
		all.put("emp", emp);
		all.put("allDepts",allDepts);
		all.put("allLevels", allLevels);
		return all; 
	}
	@Override
	public boolean edit(Emp vo) throws Exception {  //需进行部门人数修改，若为部门领导且变更了部门，则原部门领导为null；新部门领导与增加逻辑相同
		Level level=this.levelDAO.findById(vo.getLid());
		if(vo.getSalary()<level.getLosal()||vo.getSalary()>level.getHisal()) { //工资应与级别对应
			return false;
		}
		Emp old=this.empDAO.findById(vo.getEid());
		if(old.getDid()!=vo.getDid()) {
			this.deptDAO.doEditCurrnum(old.getDid(), -1);
			this.deptDAO.doEditCurrnum(vo.getDid(), 1);
		}
		if(this.deptDAO.findById(old.getDid()).getEid()==vo.getEid()) {  //为原部门领导
			if(old.getDid()!=vo.getDid()) {  //变更了部门
				this.deptDAO.doEditEid(old.getDid(), null);
				if(vo.getLid()<3) {  //变更后仍为领导级别
					Dept dept=this.deptDAO.findById(vo.getDid());
					if(dept.getEid()!=null) {
						if(this.empDAO.findById(dept.getEid()).getLid()>=vo.getLid()) {//此时，原领导降一级，部门领导变更
							Emp oldHead=this.empDAO.findById(dept.getEid());
							if(oldHead.getLid()<=4) { //仅当原领导不是最末一级时降级
								oldHead.setLid(oldHead.getLid()+1);
							}
							this.empDAO.doEdit(oldHead);         //原领导降一级
							this.deptDAO.doEditEid(vo.getDid(), vo.getEid());
						}
					}
				}
			}
		}
		return this.empDAO.doEdit(vo);
	}
	@Override
	public Map<String, Object> getCompeleteDetails(String eid,String mid) throws Exception {
		Map<String,Object> all=new HashMap<String,Object>();
		Emp emp=this.empDAO.findById(eid);
		Emp operate=this.empDAO.findById(mid);
		List<EmpEducation> allEmpEducations=this.empEducationDAO.findByEid(eid);
		List<EmpCareer> allEmpCareers=this.empCareerDAO.findByEid(eid);
		List<Emp> empList=new ArrayList<Emp>();
		empList.add(emp);
		Map<Long,Dept> allDepts=this.deptDAO.findByEmp(empList);
		Map<Integer,Level> allLevels=this.levelDAO.findByEmps(empList);
		all.put("operate", operate);
		all.put("emp", emp);
		all.put("dept", allDepts.get(emp.getDid()));
		all.put("level", allLevels.get(emp.getLid()));
		all.put("allEmpEducations", allEmpEducations);
		all.put("allEmpCareers", allEmpCareers);
		return all;
	}
	@Override
	public Map<String, Object> getSimpleDetails(String eid) throws Exception {
		Map<String,Object> all=new HashMap<String,Object>();
		Emp emp=this.empDAO.findById(eid);
		all.put("emp", emp);
		return all;
	}
	@Override
	public boolean getCheck(String eid) throws Exception {
		// TODO Auto-generated method stub
		return this.empDAO.findByIdCheck(eid);
	}

}
