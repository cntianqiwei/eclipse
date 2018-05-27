package cn.mldn.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.mldn.dao.IEmpResourceDAO;
import cn.mldn.dao.IResourceDAO;
import cn.mldn.dao.impl.EmpResourceDAOImpl;
import cn.mldn.dao.impl.ResourceDAOImpl;
import cn.mldn.service.IEmpResourceService;
import cn.mldn.service.impl.EmpResourceServiceImpl;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.vo.EmpResource;
import cn.mldn.vo.Resource;

public class Test {
	@Autowired
	private static  IResourceDAO resourceDAO = new ResourceDAOImpl();
	@Autowired
	private static IEmpResourceService erService = new EmpResourceServiceImpl();
	@Autowired
	private static IEmpResourceDAO erDAO = new EmpResourceDAOImpl();
	public static void main(String[] args) throws Exception{
//		Resource vo =  new Resource();
//		vo.setTitle("辣条");
//		vo.setSpid(1L);
//		vo.setPrice(20.0);
//		vo.setAppdate(new Date());
//		vo.setPhoto("xyz");
//		vo.setAmount(20);
//		vo.setItem("硬件");
//		vo.setNote("呵呵");
//		boolean  flag= false;
//		flag= resourceDAO.doCreate(vo);
//		System.out.println(flag);
//		EmpResource vo = erDAO.findById(1L);
//		Map<String, Object> map =erService.handelByEresid(1L);
//		System.out.println(map);
		Map<String, Object> map = new HashMap<>();
		
		map=erService.handelByEresid(1L);
		System.out.println(map);
	}
}
