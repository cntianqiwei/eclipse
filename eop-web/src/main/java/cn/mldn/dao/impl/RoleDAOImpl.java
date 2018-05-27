package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IRoleDAO;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
import cn.mldn.vo.Role;
@Repository
public class RoleDAOImpl extends AbstractDAO implements IRoleDAO {
	
	@Override
	public boolean doCreate(Role vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doEdit(Role vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Role findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount(String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> findByEmp(String eid) throws SQLException {
		Set<String> all = new HashSet<String>() ;
		String sql = "SELECT rid FROM dept_role WHERE did=(SELECT did FROM emp WHERE eid=?)" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, eid);
		ResultSet rs = super.pstmt.executeQuery() ;
		while(rs.next()) {
			all.add(rs.getString(1)) ;
		}
		return all;
	}

}
