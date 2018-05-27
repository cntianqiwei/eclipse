package cn.mldn.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mldn.dao.IEmpDAO;
import cn.mldn.dao.IEmpResourceDAO;
import cn.mldn.dao.IEmpResourceDetailsDAO;
import cn.mldn.dao.IResourceDAO;
import cn.mldn.dao.impl.EmpResourceDAOImpl;
import cn.mldn.service.IEmpResourceService;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
import cn.mldn.vo.EmpResource;
import cn.mldn.vo.Resource;
@Service
public class EmpResourceServiceImpl extends AbstractService implements IEmpResourceService {
	@Autowired
	private IEmpResourceDAO erDAO;
	@Autowired
	private IEmpDAO empDAO;
	@Autowired
	private IEmpResourceDetailsDAO erdDAO;
	@Autowired
	private IResourceDAO resourceDAO;
	@Override
	public boolean editEmpResource(Long eresid, EmpResource vo) throws Exception {
		vo.setAuditdate(new Date());
		return this.erDAO.doEditEmpResource(eresid, vo);
	}
	@Override
	public Map<String, Object> listByEmpResource(Long currentPage, Integer lineSize, String column, String keyWord)
			throws Exception {
		Map<String, Object> map = new HashMap<>();
		if(column==null||"".equals(column)||keyWord==null||"".equals(keyWord)) {
			map.put("allRecorders", this.erDAO.getAllCount());
			map.put("allEmpResource", this.erDAO.findSplit(currentPage, lineSize));
		}else {
			map.put("allRecorders", this.erDAO.getAllCount(column, keyWord));
			map.put("allEmpResource", this.erDAO.findSplit(currentPage, lineSize, column, keyWord));
		}
		return map;
	}
	@Override
	public Map<String, Object> handelByEresid(Long eresid) throws Exception {
		Map<String, Object> map = new HashMap<>();
//		System.out.println(erDAO);
		map.put("EmpResource", this.erDAO.findById(eresid));
		map.put("allDetails", this.erdDAO.findByEresid(eresid));
		map.put("allResource", this.resourceDAO.findByEresid(eresid));
		List<Resource> all = this.resourceDAO.findByEresid(eresid);
		double sum=0.0;
		int amount =0;
		for(Resource res : all) {
			sum=res.getAmount()*res.getPrice();
			amount+=res.getAmount();
		}
		map.put("sum", sum);
		map.put("amount", amount);
//		System.out.println(map);
		return map;
	}

}
