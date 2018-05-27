package cn.mldn.dao;

import java.sql.SQLException;
import java.util.Set;

import cn.mldn.util.dao.IDAO;
import cn.mldn.vo.Role;
public interface IRoleDAO extends IDAO<String, Role> {
	public Set<String> findByEmp(String eid) throws SQLException ;
}
