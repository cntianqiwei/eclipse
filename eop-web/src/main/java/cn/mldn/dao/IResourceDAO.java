package cn.mldn.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import cn.mldn.util.dao.IDAO;
import cn.mldn.vo.Resource;

public interface IResourceDAO extends IDAO<Long, Resource> {
	/**
	 * 查询关于申请表里详细清单
	 * @param spid  申请表的ID
	 * @return 返回清单的list集合
	 * @throws SQLException SQL异常
	 */
	public List<Resource> findBySpid(Long spid) throws SQLException;
	/**
	 * 进行清单列表的更新操作
	 * @param resid 清单ID
	 * @return 更新成功返回true
	 * @throws SQLException SQL异常
	 */
	public boolean doEditResource(Long resid,Resource vo)throws SQLException;
	/**
	 * 删除订单表里的购物清单
	 * @param ids 要删除的清单号
	 * @return 删除成功返回true
	 * @throws SQLException
	 */
	public boolean doRemoveByResource(Set<Long> resids)throws SQLException;
	/**
	 * 查询出清单号所对应的表信息
	 * @param resids 清单号
	 * @return 返回表集合
	 * @throws SQLException SQL异常
	 */
	public List<Resource> findByResids(Set<Long> resids) throws SQLException;
	/**
	 * 查询出库存的办公用品列表
	 * @param currentPage 页数
	 * @param lineSize 每页显示
	 * @return 返回用品表集合
	 * @throws SQLException SQL异常
	 */
	public List<Resource> findBySplitResource(long currentPage,int lineSize)throws SQLException;
	/**
	 * 查询出库存的办公用品列表
	 * @param currentPage 页数
	 * @param lineSize 每页显示
	 * @param column 列
	 * @param keyWord 关键字
	 * @return 返回用品表集合
	 * @throws SQLException SQL异常
	 */
	public List<Resource> findBySplitResource(long currentPage,int lineSize,String column,String keyWord)throws SQLException;
	/**
	 * 进行库存数值的批量增加
	 * @param resid 库存办公用品清单号
	 * @param amount 数量
	 * @return  增加成功返回true
	 * @throws SQLException SQL异常
	 */
	public boolean doEditAmount(Long resid,Integer amount) throws SQLException;
	/**
	 * 根据雇员用品申请单编号查询出里面所有的用品
	 * @param eresid 编号
	 * @return 返回所有用品
	 * @throws SQLException SQL异常
	 */
	public List<Resource> findByEresid(Long eresid)throws SQLException;

	

}
