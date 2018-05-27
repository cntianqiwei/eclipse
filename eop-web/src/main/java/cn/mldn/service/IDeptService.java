package cn.mldn.service;

import java.util.List;
import java.util.Map;

import cn.mldn.vo.Dept;

public interface IDeptService {
	public boolean add(Dept dept) throws Exception ;
	public List<Dept> list() throws Exception ;
	
	/**
	 * 在不分页时得到总共的dept记录数,以及所有的dept集合
	 * @return key="allRecorders".value=dept总记录数
	 * key="allDepts",value=dept的List集合
	 * @throws Exception
	 */
	public Map<String,Object> listDeptAndCount(String mid) throws Exception;
	/**
	 * 修改部门名称与部门最大人数，当部门最大人数小于当前人数时，修改失败
	 * @param vo 前端传入的希望修改的部门信息
	 * @return 修改成功返回true,失败false
	 * @throws Exception
	 */
	public boolean edit(Dept vo) throws Exception;
}
