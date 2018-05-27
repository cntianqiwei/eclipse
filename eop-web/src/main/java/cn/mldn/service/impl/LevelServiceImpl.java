package cn.mldn.service.impl;

import java.util.List;

import cn.mldn.dao.ILevelDAO;
import cn.mldn.service.ILevelService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
import cn.mldn.vo.Level;

@Service
public class LevelServiceImpl implements ILevelService {
	@Autowired
	private ILevelDAO levelDAO;
	@Override
	public List<Level> list() throws Exception {
		// TODO Auto-generated method stub
		return this.levelDAO.findAll();
	}
	@Override
	public Level get(Integer lid) throws Exception {
		if(lid==null) {
			return null;
		}
		return this.levelDAO.findById(lid);
	}

}
