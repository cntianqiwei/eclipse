package cn.mldn.dao;


import java.sql.SQLException;

import cn.mldn.util.dao.IDAO;
import cn.mldn.vo.Supplypurchase;

public interface ISupplypurchaseDAO extends IDAO<Long, Supplypurchase> {
	/**
	 * 根据申请表中待购商品动态修改订单的价格，数量，状态
	 * @param 申请表ID
	 * @param money 申请表的总价
	 * @param amount 申请表的总数量
	 * @param status 申请表状态
	 * @return 修改成功返回true,否则返回false
	 * @throws SQLException sql异常
	 */
	public boolean doEditSup(Long spid,Double money,Integer amount,Integer status)throws SQLException;

}
