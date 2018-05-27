package cn.mldn.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.util.dao.IDAO;
import cn.mldn.vo.Emp;
import cn.mldn.vo.Plan;

public interface IPlanDAO extends IDAO<Long, Plan> {
	
	/**
	 * 判断某雇员的时间是否与分配任务所冲突
	 * @param eid 指定的雇员id
	 * @param plan 分配的任务
	 * @return 有冲突不能分配返回true 没有冲突返回false
	 * @throws SQLException
	 */
	public boolean timeConflict(String eid,Plan plan) throws SQLException ;
	public boolean doEditStatusById(long pid,int status) throws SQLException ;
	/**
	 * 根据任务id查询所有的雇员信息列表
	 * @param pid 
	 * @return 
	 * @throws SQLException
	 */
	public List<Emp> findEmpbyPid(long pid) throws SQLException ;
	
	/**
	 * 通过雇员的id 修改雇员人数
	 * @param pid 
	 * @param count
	 * @return
	 * @throws SQLException
	 */
	public boolean doEditAmout(long pid,int count) throws SQLException ;
	
}
