package cn.mldn.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.util.dao.IDAO;
import cn.mldn.vo.EmpCareer;

public interface IEmpCareerDAO extends IDAO<Long, EmpCareer> {
	/**
	 * 根据雇员id查找雇员职业经历
	 * @param eid 雇员id
	 * @return 雇员职业经历
	 * @throws SQLException SQL错误
	 */
	public List<EmpCareer> findByEid(String eid) throws SQLException;
	/**
	 * 根据ecarid删除雇员职业背景信息
	 * @param ids 雇员职业背景id
	 * @return 删除成功返回true
	 * @throws SQLException sql错误
	 */
	public boolean doRemoveByIds(Set<Long> ids) throws SQLException;
}
