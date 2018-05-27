package cn.mldn.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.mldn.dao.IResourceDAO;
import cn.mldn.service.IResourceService;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
import cn.mldn.vo.Resource;

@Service
public class ResourceServiceImpl extends AbstractService implements IResourceService {
	@Autowired
	private IResourceDAO reourceDAO;
	@Override
	public boolean addAmount(long resid, int amount) throws Exception {
//		if(resid==null||amount==null) {
//			return false;
//		}
		return this.reourceDAO.doEditAmount(resid, amount);
	}
	@Override
	public Map<String, Object> listByStatus3(long currentPage, int lineSize, String column, String keyWord)
			throws Exception {
		Map<String, Object> map = new HashMap<>();
		if(column==null||"".equals(column)||keyWord==null||"".equals(keyWord)) {
			map.put("allRecorders", reourceDAO.getAllCount());
			map.put("allResource", reourceDAO.findBySplitResource(currentPage, lineSize));
		}else {
			map.put("allRecorders", reourceDAO.getAllCount(column, keyWord));
			map.put("allResource", reourceDAO.findBySplitResource(currentPage, lineSize, column, keyWord));
		}
		return map;
	}
	@Override
	public boolean deleteResource(Set<Long> resids) throws Exception {
		if(resids.size()==0||resids==null) {
			return false;
		}
		return this.reourceDAO.doRemoveByResource(resids);
	}
	@Override
	public boolean editResource(Resource vo, Long resid) throws Exception {
		return this.reourceDAO.doEditResource(resid, vo);
	}

	@Override
	public boolean editResource(Resource vo) throws Exception {
		return this.reourceDAO.doEdit(vo);
	}


	@Override
	public Map<String, Object> listBySup(Long spid) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("allResource", this.reourceDAO.findBySpid(spid));
		return map;

	}

	@Override
	public boolean addResource(Resource vo) throws Exception {
		vo.setAppdate(new Date());
		return this.reourceDAO.doCreate(vo);
	}

	@Override
	public Resource resourceFindByResid(Long resid) throws Exception {
		if (resid == null) {
			return null;
		}else {
			return this.reourceDAO.findById(resid);
		}
	}

}
