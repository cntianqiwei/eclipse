package cn.mldn.service.impl;

import java.util.List;
import java.util.Set;

import cn.mldn.dao.IEmpCareerDAO;
import cn.mldn.service.IEmpCareerService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
import cn.mldn.vo.EmpCareer;
@Service
public class EmpCareerServiceImpl implements IEmpCareerService {
	@Autowired
	private IEmpCareerDAO empCareerDAO;
	@Override
	public List<EmpCareer> getByEid(String eid) throws Exception {
		if(eid==null||"".equals(eid)) {
			return null;
		}
		return this.empCareerDAO.findByEid(eid);
	}
	@Override
	public boolean add(EmpCareer vo) throws Exception {
		// TODO Auto-generated method stub
		return this.empCareerDAO.doCreate(vo);
	}
	@Override
	public boolean edit(EmpCareer vo) throws Exception {
		// TODO Auto-generated method stub
		return this.empCareerDAO.doEdit(vo);
	}
	@Override
	public boolean delete(Set<Long> ids) throws Exception {
		// TODO Auto-generated method stub
		return this.empCareerDAO.doRemove(ids);
	}
	@Override
	public EmpCareer get(Long id) throws Exception {
		// TODO Auto-generated method stub
		return this.empCareerDAO.findById(id);
	}

}
