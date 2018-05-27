package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IEmpLogDAO;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
import cn.mldn.vo.EmpLog;
@Repository
public class EmpLogDAOImpl extends AbstractDAO implements IEmpLogDAO {
	
	@Override
	public boolean doCreate(EmpLog vo) throws SQLException {
		String sql = "INSERT INTO emp_logs(eid,logintime) VALUES(?,?)" ;
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getEid());
		super.pstmt.setTimestamp(2, new java.sql.Timestamp(vo.getLogintime().getTime()));
		return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doEdit(EmpLog vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EmpLog findById(Long id) throws SQLException {
		
		return null;
	}

	@Override
	public List<EmpLog> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpLog> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpLog> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
			throws SQLException {
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
	public EmpLog findByEid(String eid) throws SQLException {
		String sql = "SELECT elid,eid,MAX(logintime) FROM emp_logs WHERE eid=? group by elid,eid" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, eid);
		ResultSet rs = super.pstmt.executeQuery();
		if(rs.next()) {
			EmpLog vo = new EmpLog() ;
			vo.setElid(rs.getLong(1));
			vo.setEid(rs.getString(2));
			vo.setLogintime(rs.getTimestamp(3));
			return vo ;
		}
		return null;
	}

}
