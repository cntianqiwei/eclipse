package cn.mldn.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.util.dao.IDAO;
import cn.mldn.vo.EmpResourceDetails;

public interface IEmpResourceDetailsDAO extends IDAO<Long, EmpResourceDetails> {
	/**
	 * 查询出申请单下的所有的雇员申请清单列表
	 * @param eresid 雇员申请单ID
	 * @return 返回清单列表
	 * @throws SQLException SQL异常
	 */
	public List<EmpResourceDetails> findByEresid(Long eresid)throws SQLException;

}
