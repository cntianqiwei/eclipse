package cn.mldn.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.mldn.util.dao.IDAO;
import cn.mldn.vo.Dept;
import cn.mldn.vo.Emp;

public interface IEmpDAO extends IDAO<String, Emp> {
	/**
	 * 根据部门的list
	 * 集合查找相应的部门领导信息
	 * @param depts 给出的部门集合
	 * @return key=dept中的eid，value=eid对应的雇员信息（雇员为该部门主管）；
	 * @throws SQLException
	 */
	public Map<String,Emp> findByDept(List<Dept> depts) throws SQLException;
	
	/**
	 * 根据指定部门id查询小于指定员工eid的职位等级lid之下的所有正常状态的员工
	 * （查询该账号能够调度的人员集合）
	 * @param eid 雇员id
	 * @param did 部门
	 * @return 返回满足条件的雇员集合
	 * @throws SQLException
	 */
	public List<Emp> findByEidAndDid(String eid,long did) throws SQLException ;
	public boolean doRemoveByIds(List<String> ids) throws SQLException;
	public List<Long> findDidsByEids(List<String> eids) throws SQLException;
	public boolean findByIdCheck(String eid) throws SQLException;
}
