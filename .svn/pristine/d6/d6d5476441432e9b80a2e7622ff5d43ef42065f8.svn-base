package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.jsp.jstl.sql.Result;

import cn.mldn.dao.ISupplypurchaseDAO;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
import cn.mldn.vo.Supplypurchase;

@Repository
public class SupplypurchaseDAOImpl extends AbstractDAO implements ISupplypurchaseDAO {
	@Override
	public boolean doEditSup(Long spid, Double money, Integer amount, Integer status) throws SQLException {
		String sql = "UPDATE supply_purchase SET money=?,amount=?,status=? WHERE spid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setDouble(1, money);
		super.pstmt.setInt(2, amount);
		super.pstmt.setInt(3, status);
		super.pstmt.setLong(4, spid);
		return super.pstmt.executeUpdate()>0;
	}
	@Override
	public boolean doCreate(Supplypurchase vo) throws SQLException {
		String sql = "INSERT INTO supply_purchase (eid,aeid,title,note,status,pubdate)VALUES(?,?,?,?,?,?)";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getEid());
		super.pstmt.setString(2, vo.getAeid());
		super.pstmt.setString(3, vo.getTitle());
		super.pstmt.setString(4, vo.getNote());
		super.pstmt.setInt(5, vo.getStatus());
		super.pstmt.setTimestamp(6, new java.sql.Timestamp(vo.getPubdate().getTime()));
		return super.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doEdit(Supplypurchase vo) throws SQLException {
		return false;
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Supplypurchase findById(Long id) throws SQLException {
		String sql = "SELECT spid,eid,aeid,title,note,money,amount,status,pubdate,auditdate,anote FROM supply_purchase WHERE spid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, id);
		ResultSet rs = super.pstmt.executeQuery();
		if(rs.next()) {
			Supplypurchase vo = new Supplypurchase();
			vo.setSpid(rs.getLong(1));
			vo.setEid(rs.getString(2));
			vo.setAeid(rs.getString(3));
			vo.setTitle(rs.getString(4));
			vo.setNote(rs.getString(5));
			vo.setMoney(rs.getDouble(6));
			vo.setAmount(rs.getInt(7));
			vo.setStatus(rs.getInt(8));
			vo.setPubdate(rs.getTimestamp(9));
			vo.setAuditdate(rs.getTimestamp(10));
			vo.setAnote(rs.getString(11));
			return vo;
		}
		
		return null;
	}

	@Override
	public List<Supplypurchase> findAll() throws SQLException {
		List<Supplypurchase> all = new ArrayList<>();
		String sql = "SELECT spid,eid,aeid,title,note,money,amount,status,pubdate,auditdate,anote FROM supply_purchase WHERE status=0";
		super.pstmt=super.conn.prepareStatement(sql);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()) {
			Supplypurchase vo = new Supplypurchase();
			vo.setSpid(rs.getLong(1));
			vo.setEid(rs.getString(2));
			vo.setAeid(rs.getString(3));
			vo.setTitle(rs.getString(4));
			vo.setNote(rs.getString(5));
			vo.setMoney(rs.getDouble(6));
			vo.setAmount(rs.getInt(7));
			vo.setStatus(rs.getInt(8));
			vo.setPubdate(rs.getTimestamp(9));
			vo.setAuditdate(rs.getTimestamp(10));
			vo.setAnote(rs.getString(11));
			all.add(vo);
		}
		
		return all;
	}

	@Override
	public List<Supplypurchase> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		List<Supplypurchase> all = new ArrayList<>();
		String sql = "SELECT spid,eid,aeid,title,note,money,amount,status,pubdate,auditdate,anote FROM supply_purchase WHERE status=0 LIMIT ?,?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, (currentPage-1)*lineSize);
		super.pstmt.setLong(2, lineSize);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()) {
			Supplypurchase vo = new Supplypurchase();
			vo.setSpid(rs.getLong(1));
			vo.setEid(rs.getString(2));
			vo.setAeid(rs.getString(3));
			vo.setTitle(rs.getString(4));
			vo.setNote(rs.getString(5));
			vo.setMoney(rs.getDouble(6));
			vo.setAmount(rs.getInt(7));
			vo.setStatus(rs.getInt(8));
			vo.setPubdate(rs.getTimestamp(9));
			vo.setAuditdate(rs.getTimestamp(10));
			vo.setAnote(rs.getString(11));
			all.add(vo);
		}
		
		return all;
	}

	@Override
	public List<Supplypurchase> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
			throws SQLException {
		List<Supplypurchase> all = new ArrayList<>();
		String sql = "SELECT spid,eid,aeid,title,note,money,amount,status,pubdate,auditdate,anote FROM supply_purchase  WHERE "+column+" LIKE ? AND status=0 LIMIT ?,?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, "%"+keyWord+"%");
		super.pstmt.setLong(2, (currentPage-1)*lineSize);
		super.pstmt.setLong(3, lineSize);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()) {
			Supplypurchase vo = new Supplypurchase();
			vo.setSpid(rs.getLong(1));
			vo.setEid(rs.getString(2));
			vo.setAeid(rs.getString(3));
			vo.setTitle(rs.getString(4));
			vo.setNote(rs.getString(5));
			vo.setMoney(rs.getDouble(6));
			vo.setAmount(rs.getInt(7));
			vo.setStatus(rs.getInt(8));
			vo.setPubdate(rs.getTimestamp(9));
			vo.setAuditdate(rs.getTimestamp(10));
			vo.setAnote(rs.getString(11));
			all.add(vo);
		}
		
		return all;
	}

	@Override
	public Long getAllCount() throws SQLException {
		return super.getAllCountHandle("supply_purchase");
	}

	@Override
	public Long getAllCount(String column, String keyWord) throws SQLException {
		return super.getAllCountSplitHandle("supply_purchase", column, keyWord);
	}

}
