package cn.mldn.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import cn.mldn.dao.IActionDAO;
import cn.mldn.dao.IEmpDAO;
import cn.mldn.dao.IEmpLogDAO;
import cn.mldn.dao.IRoleDAO;
import cn.mldn.service.ILonginService;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.util.web.PrivilegeUtil;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
import cn.mldn.util.web.servlet.ServletObjectUtil;
import cn.mldn.vo.Emp;
import cn.mldn.vo.EmpLog;
@Service
public class LoginServiceImpl extends AbstractService implements ILonginService {
	@Autowired
	private IEmpDAO empDAO ;
	@Autowired
	private IActionDAO actionDAO;
	@Autowired
	private IRoleDAO roleDAO; 
	@Autowired
	private IEmpLogDAO emplogDAO;
	@Override
	public boolean login(Emp vo) throws Exception {
		
		Emp emp = empDAO.findById(vo.getEid()) ;
		if(emp != null) {
			if(emp.getStatus() == 0 && emp.getPassword().equals(vo.getPassword())) {
				//验证通过保存用户的权限信息,以及个人信息
				Date logintime= new Date() ;
				EmpLog log = new EmpLog() ;
				log.setEid(vo.getEid());
				log.setLogintime(logintime);
				//日志记录
				Date previousDate = null ;
				EmpLog preLog = emplogDAO.findByEid(vo.getEid());
				if(preLog != null) {
					previousDate = preLog.getLogintime() ;
				}
				if(!emplogDAO.doCreate(log)) {
					return false ;
				}
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("emp",emp) ;
				map.put("priviousdate",previousDate) ;
				map.put("logintime",emp) ;
				map.put("allRoles", roleDAO.findByEmp(vo.getEid())) ;
				map.put("allActions", actionDAO.findAllByEmp(vo.getEid()));
				PrivilegeUtil.setPrivilege(emp.getEid(), map);
				ServletObjectUtil.getRequest().getSession().setAttribute("privilege", map);
				return  true;
			}
		}
		return false ;
	}

}
