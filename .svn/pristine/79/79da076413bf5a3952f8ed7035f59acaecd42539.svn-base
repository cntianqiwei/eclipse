package cn.mldn.dao;


import java.sql.SQLException;

import cn.mldn.util.dao.IDAO;
import cn.mldn.vo.PlanDetails;

public interface IPlanDetailsDAO extends IDAO<Long, PlanDetails> {
	/**
	 * 分配某项任务给一个员工
	 * @param pid
	 * @param eid
	 * @return
	 * @throws SQLException
	 */
	public boolean doCreateByPidAndEid(long pid,String eid) throws SQLException ;
	/**
	 * 移除某项任务的员工
	 * @param pid
	 * @param eid
	 * @return
	 * @throws SQLException
	 */
	public boolean doRemoveByPidAndEid(long pid,String eid) throws SQLException ;
	/**
	 * 查询指定任务下的员工是否已经存在
	 * @param pid
	 * @param eid
	 * @return
	 * @throws SQLException
	 */
	public boolean findByPidAndEid(long pid,String eid) throws SQLException ;
	/**
	 * 查询该雇员当前是否有任务
	 * @param eid
	 * @return
	 * @throws SQLException
	 */
	public boolean findByEid(String eid) throws SQLException ; 
	
}
