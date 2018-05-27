package cn.mldn.service.impl;


import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.dao.IResourceDAO;
import cn.mldn.dao.ISupplypurchaseDAO;
import cn.mldn.service.ISupplypurchaseService;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
import cn.mldn.vo.Resource;
import cn.mldn.vo.Supplypurchase;
@Service
public class SupplypurchaseServiceImpl extends AbstractService implements ISupplypurchaseService {
	@Autowired
	private ISupplypurchaseDAO supplypurchaseDAO;
	@Autowired
	private IResourceDAO resourceDAO;
	@Override
	public boolean editSupByResource(Long spid, Set<Long> resids) throws Exception {
		List<Resource> allResource = this.resourceDAO.findByResids(resids);//获取申请表中所有的订单信息
		double sum = 0.0;
		int amount=0;
		Iterator<Resource> resIter = allResource.iterator();
		while(resIter.hasNext()) {
			Resource res = resIter.next();
			amount +=res.getAmount();
			sum += res.getAmount()*res.getPrice();
		}
//		Supplypurchase vo = this.supplypurchaseDAO.findById(spid);
//		vo.setMoney(sum);
//		vo.setAmount(amount);
//		vo.setStatus(1);
		int status = 1;
		if(this.supplypurchaseDAO.doEditSup(spid, sum, amount, status)) {
			return true;
		}
		return false;
	}
	@Override
	public Map<String, Object> listSupByFindSplit(String column, String keyWord, long currentPage, int lineSize)
			throws Exception {
		Map<String, Object> map = new  HashMap<>();
		if(column==null||"".equals(column)||keyWord==null||"".equals(keyWord)) {
			map.put("allRecorders", supplypurchaseDAO.getAllCount());
			map.put("allSup", supplypurchaseDAO.findSplit(currentPage, lineSize));
		}else {
			map.put("allRecorders", supplypurchaseDAO.getAllCount(column, keyWord));
			map.put("allSup", supplypurchaseDAO.findSplit(currentPage, lineSize, column, keyWord));
		}
		return map;
	}

	@Override
	public boolean addSup(Supplypurchase vo) throws Exception {
		vo.setStatus(0);
		vo.setPubdate(new Date());
//		System.out.println(vo);
		return supplypurchaseDAO.doCreate(vo);
	}

	@Override
	public Map<String, Object> listSupByFindAll() throws Exception {
		Map<String, Object>  map = new HashMap<>();
		map.put("allSup", this.supplypurchaseDAO.findAll());
		return map;
	}


	

}
