package cn.mldn.service.impl;

import java.util.List;
import java.util.Set;

import cn.mldn.dao.IEmpEducationDAO;
import cn.mldn.service.IEmpEducationService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
import cn.mldn.vo.EmpEducation;
@Service
public class EmpEducationServiceImpl implements IEmpEducationService {
	@Autowired
	private IEmpEducationDAO empEducationDAO;
	@Override
	public boolean add(EmpEducation vo) throws Exception {
		// TODO Auto-generated method stub
		return this.empEducationDAO.doCreate(vo);
	}
	@Override
	public List<EmpEducation> getByEid(String eid) throws Exception {
		// TODO Auto-generated method stub
		return this.empEducationDAO.findByEid(eid);
	}
	@Override
	public boolean delete(Set<Long> ids) throws Exception {
		if(ids.size()==0||ids==null) {
			return false;
		}
		return this.empEducationDAO.doRemove(ids);
	}
	@Override
	public EmpEducation get(Long id) throws Exception {
		if(id==null) {
			return null;
		}
		return this.empEducationDAO.findById(id);
	}
	@Override
	public boolean edit(EmpEducation vo) throws Exception {
		// TODO Auto-generated method stub
		return this.empEducationDAO.doEdit(vo);
	}

}
