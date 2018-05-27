package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IPlanDetailsDAO;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
import cn.mldn.vo.PlanDetails;
@Repository
public class PlanDetailsDAOImpl extends AbstractDAO implements IPlanDetailsDAO {

	@Override
	public boolean doCreate(PlanDetails vo) throws SQLException {
		String sql = "INSERT INTO plan_details(pid,eid) VALUES(?,?)" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setLong(1, vo.getPid());
		super.pstmt.setString(2, vo.getEid());
		return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doEdit(PlanDetails vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		return false;
	}

	@Override
	public PlanDetails findById(Long id) throws SQLException {
		return null;
	}

	@Override
	public List<PlanDetails> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanDetails> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanDetails> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
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
	public boolean doRemoveByPidAndEid(long pid,String eid) throws SQLException {
		String sql = "DELETE FROM plan_details WHERE pid=? AND eid=?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setLong(1, pid);
		super.pstmt.setString(2, eid);
		return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean findByPidAndEid(long pid, String eid) throws SQLException {
		String sql = "SELECT COUNT(eid) FROM plan_details WHERE pid=? AND eid=?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setLong(1, pid);
		super.pstmt.setString(2, eid);
		ResultSet rs = super.pstmt.executeQuery() ;
		if(rs.next()) {
			if(rs.getLong(1) > 0) {
				return true ;
			}
		}
		return false ;
	}

	@Override
	public boolean doCreateByPidAndEid(long pid, String eid) throws SQLException {
		String sql = "INSERT INTO plan_details(pid,eid) VALUES(?,?)" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setLong(1, pid);
		super.pstmt.setString(2, eid);
		return super.pstmt.executeUpdate() > 0;
			
	}

	@Override
	public boolean findByEid(String eid) throws SQLException {
		String sql = "SELECT COUNT(eid) FROM plan_details WHERE eid=?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, eid);
		ResultSet rs = super.pstmt.executeQuery() ;
		if(rs.next()) {
			if(rs.getLong(1) > 0) {
				return true ;
			}
		}
		return false ;
	}

}
