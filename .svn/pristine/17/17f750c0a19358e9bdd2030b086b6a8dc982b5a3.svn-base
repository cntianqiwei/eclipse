package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mysql.jdbc.ResultSetRow;

import cn.mldn.dao.IEmpResourceDAO;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
import cn.mldn.vo.EmpResource;
@Repository
public class EmpResourceDAOImpl extends AbstractDAO implements IEmpResourceDAO {
	 @Override
		public boolean doEditEmpResource(Long eresid, EmpResource vo) throws SQLException {
			String sql = "UPDATE emp_resource SET aeid=?,renote=?,auditdate=?,status=? WHERE eresid=?";
			super.pstmt=super.conn.prepareStatement(sql);
			super.pstmt.setString(1, vo.getAeid());
			super.pstmt.setString(2, vo.getRenote());
			super.pstmt.setTimestamp(3, new java.sql.Timestamp(vo.getAuditdate().getTime()));
			super.pstmt.setInt(4, vo.getStatus());
			super.pstmt.setLong(5, eresid);
			return super.pstmt.executeUpdate()>0;
		}

	@Override
	public boolean doCreate(EmpResource vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doEdit(EmpResource vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EmpResource findById(Long id) throws SQLException {
		String sql = "SELECT eresid,eid,aeid,title,subdate,amount,money,status,renote,auditdate FROM emp_resource WHERE eresid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, id);
		ResultSet rs = super.pstmt.executeQuery();
		if(rs.next()) {
			EmpResource vo = new EmpResource();
			vo.setEresid(rs.getLong(1));
			vo.setEid(rs.getString(2));
			vo.setAeid(rs.getString(3));
			vo.setTitle(rs.getString(4));
			vo.setSubdate(rs.getDate(5));
			vo.setAmount(rs.getInt(6));
			vo.setMoney(rs.getDouble(7));
			vo.setStatus(rs.getInt(8));
			vo.setRenote(rs.getString(9));
			vo.setAuditdate(rs.getDate(10));
			return vo;
		}
		return null;
	}

	@Override
	public List<EmpResource> findAll() throws SQLException {
		List<EmpResource> all = new ArrayList<>();
		String sql ="SELECT eresid,eid,aeid,title,subdate,amount,money,status,renote,auditdate FROM emp_resource WHERE status=1";
		super.pstmt=super.conn.prepareStatement(sql);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()) {
			EmpResource vo = new EmpResource();
			vo.setEresid(rs.getLong(1));
			vo.setEid(rs.getString(2));
			vo.setAeid(rs.getString(3));
			vo.setTitle(rs.getString(4));
			vo.setSubdate(rs.getDate(5));
			vo.setAmount(rs.getInt(6));
			vo.setMoney(rs.getDouble(7));
			vo.setStatus(rs.getInt(8));
			vo.setRenote(rs.getString(9));
			vo.setAuditdate(rs.getDate(10));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<EmpResource> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		List<EmpResource> all = new ArrayList<>();
		String sql ="SELECT eresid,eid,aeid,title,subdate,amount,money,status,renote,auditdate FROM emp_resource WHERE status=1 LIMIT ?,?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, (currentPage-1)*lineSize);
		super.pstmt.setInt(2, lineSize);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()) {
			EmpResource vo = new EmpResource();
			vo.setEresid(rs.getLong(1));
			vo.setEid(rs.getString(2));
			vo.setAeid(rs.getString(3));
			vo.setTitle(rs.getString(4));
			vo.setSubdate(rs.getDate(5));
			vo.setAmount(rs.getInt(6));
			vo.setMoney(rs.getDouble(7));
			vo.setStatus(rs.getInt(8));
			vo.setRenote(rs.getString(9));
			vo.setAuditdate(rs.getDate(10));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<EmpResource> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
			throws SQLException {
		List<EmpResource> all = new ArrayList<>();
		String sql ="SELECT eresid,eid,aeid,title,subdate,amount,money,status,renote,auditdate FROM emp_resource WHERE status=1 AND "+column+" LIKE ?  LIMIT ?,?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, "%"+keyWord+"%");
		super.pstmt.setLong(2, (currentPage-1)*lineSize);
		super.pstmt.setInt(3, lineSize);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()) {
			EmpResource vo = new EmpResource();
			vo.setEresid(rs.getLong(1));
			vo.setEid(rs.getString(2));
			vo.setAeid(rs.getString(3));
			vo.setTitle(rs.getString(4));
			vo.setSubdate(rs.getDate(5));
			vo.setAmount(rs.getInt(6));
			vo.setMoney(rs.getDouble(7));
			vo.setStatus(rs.getInt(8));
			vo.setRenote(rs.getString(9));
			vo.setAuditdate(rs.getDate(10));
			all.add(vo);
		}
		return all;
	}

	@Override
	public Long getAllCount() throws SQLException {
		return super.getAllCountHandle("emp_resource");
	}

	@Override
	public Long getAllCount(String column, String keyWord) throws SQLException {
		return super.getAllCountSplitHandle("emp_resource", column, keyWord);
	}

}
