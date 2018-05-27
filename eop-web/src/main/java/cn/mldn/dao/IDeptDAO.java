package cn.mldn.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.mldn.util.dao.IDAO;
import cn.mldn.vo.Dept;
import cn.mldn.vo.Emp;

public interface IDeptDAO extends IDAO <Long,Dept>{
	/**
	 * 实现部门角色的增加操作，由于没有角色增加页面，所以部门添加时均默认设置有所有部门都有的角色，包括plan，reimbursement，resource，schedule
	 * @return增加成功返回true,否则返回false
	 */
	public boolean doCreateDeptRoleDefault() throws SQLException ;
	/**
	 * 根据部门ID查询部门当前人数
	 * @param did 部门ID
	 * @return 部门当前人数
	 * @throws SQLException
	 */
	public Integer getCurrnumById(Long did) throws SQLException;
	/**
	 * 根据部门ID以及变化的数字改变部门当前人数
	 * @param did 部门ID
	 * @param data 人数变化值
	 * @return 修改成功返回true
	 * @throws SQLException
	 */
	public boolean doEditCurrnum(Long did,Integer data) throws SQLException;
	/**
	 * 根据雇员数据找到雇员所在的部门数据
	 * @param emps 所有需要查找所在部门的雇员
	 * @return key=did,value=dept
	 * @throws SQLException SQL错误
	 */
	public Map<Long,Dept> findByEmp(List<Emp> emps) throws SQLException;
	public boolean doEditEid(Long did,String eid) throws SQLException;
}
