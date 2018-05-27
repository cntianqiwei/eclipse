package cn.mldn.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.util.dao.IDAO;
import cn.mldn.vo.Dictionary;


public interface IDictionaryDAO extends IDAO<Long, Dictionary> {
	/**
	 * 通过类型查找所有的字典对象
	 * @return List<Dictionary>字典对象
	 * @throws SQLException
	 */
	public List<Dictionary> findByType(String type) throws SQLException ;
}
