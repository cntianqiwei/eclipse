package cn.mldn.service;

import java.util.List;
import java.util.Set;

import cn.mldn.vo.EmpEducation;

public interface IEmpEducationService {
	public boolean add(EmpEducation vo) throws Exception;
	/**
	 * 根据雇员id查询雇员教育经历
	 * @param eid 雇员id
	 * @return 雇员教育经历
	 * @throws Exception 执行错误
	 */
	public List<EmpEducation> getByEid(String eid) throws Exception;
	
	public boolean delete(Set<Long> ids) throws Exception;
	public EmpEducation get(Long id) throws Exception;
	public boolean edit(EmpEducation vo) throws Exception;
}
