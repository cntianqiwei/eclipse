package cn.mldn.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.util.dao.IDAO;
import cn.mldn.vo.EmpEducation;

public interface IEmpEducationDAO extends IDAO<Long, EmpEducation> {
	/**
	 * 根据雇员id查找雇员教育经历
	 * @param eid 雇员id
	 * @return 雇员所有教育经历
	 * @throws SQLException SQL错误
	 */
	public List<EmpEducation> findByEid(String eid) throws SQLException;
	
}
