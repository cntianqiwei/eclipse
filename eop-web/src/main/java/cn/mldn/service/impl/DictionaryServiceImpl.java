package cn.mldn.service.impl;

import java.util.List;

import cn.mldn.dao.IDictionaryDAO;
import cn.mldn.service.IDictionaryService;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
import cn.mldn.vo.Dictionary;

@Service
public class DictionaryServiceImpl extends AbstractService implements IDictionaryService {
	@Autowired
	private IDictionaryDAO dictionaryDAO ;
	@Override
	public List<Dictionary> findByType(String type) throws Exception {
		if(type == null || "".equals(type)) {
			return null ;
		}
		return dictionaryDAO.findByType(type) ;
	}

}
