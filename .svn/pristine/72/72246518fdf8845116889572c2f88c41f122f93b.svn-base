package cn.mldn.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mldn.dao.IDeptDAO;
import cn.mldn.dao.IEmpDAO;
import cn.mldn.service.IDeptService;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
import cn.mldn.vo.Dept;
import cn.mldn.vo.Emp;

@Service
public class DeptServiceImpl extends AbstractService implements IDeptService {
	@Autowired
	private IDeptDAO deptDAO ; 	// 把所有可能使用到的DAO接口都要定义在属性里面 
	@Autowired
	private IEmpDAO empDAO;
	@Override
	public boolean add(Dept dept) throws Exception {
		if(this.deptDAO.doCreate(dept)) {
			return this.deptDAO.doCreateDeptRoleDefault();
		}
		return false;
	}

	@Override
	public List<Dept> list() throws Exception {
		return this.deptDAO.findAll(); 
	}
	@Override
	public Map<String,Object> listDeptAndCount(String mid) throws Exception{
		Emp operate=this.empDAO.findById(mid);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("allRecorders", this.deptDAO.getAllCount());
		List<Dept> depts=this.deptDAO.findAll();
		map.put("allDepts", depts);
		map.put("allEmps", this.empDAO.findByDept(depts));
		map.put("operate",operate);
		return map;
	}

	@Override
	public boolean edit(Dept vo) throws Exception {
		int currnum=this.deptDAO.getCurrnumById(vo.getDid());
		if(vo.getMaxnum()<currnum) {
			return false;
		}
		return this.deptDAO.doEdit(vo);
	}

}
