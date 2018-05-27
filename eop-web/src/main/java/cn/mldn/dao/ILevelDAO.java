package cn.mldn.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.mldn.util.dao.IDAO;
import cn.mldn.vo.Emp;
import cn.mldn.vo.Level;

public interface ILevelDAO extends IDAO<Integer, Level> {
	/**
	 * 根据雇员信息找到所有的职位信息
	 * @param emps 需要查找职位级别的雇员集合
	 * @return k=lid,value=level
	 * @throws SQLException
	 */
	public Map<Integer,Level> findByEmps(List<Emp> emps) throws SQLException;
}
