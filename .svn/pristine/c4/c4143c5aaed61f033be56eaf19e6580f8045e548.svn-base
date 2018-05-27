package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IResourceDAO;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
import cn.mldn.vo.Resource;
@Repository
public class ResourceDAOImpl extends AbstractDAO implements IResourceDAO {
	@Override
	public boolean doEditAmount(Long resid, Integer amount) throws SQLException {
		String sql = "UPDATE resource SET amount=amount+"+amount+" WHERE resid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, resid);
		return super.pstmt.executeUpdate()>0;
	}
	@Override
	public List<Resource> findBySplitResource(long currentPage, int lineSize, String column, String keyWord)
			throws SQLException {
		List<Resource> all = new ArrayList<>();
		String sql="SELECT resid,spid,title,price,appdate,amount,photo FROM resource WHERE spid IN ("
				+ " SELECT spid FROM supply_purchase WHERE status=3) AND "+column+" LIKE ? LIMIT ?,?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, "%"+keyWord+"%");
		super.pstmt.setLong(2, (currentPage-1)*lineSize);
		super.pstmt.setInt(3, lineSize);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()) {
			Resource vo = new Resource();
			vo.setResid(rs.getLong(1));
			vo.setSpid(rs.getLong(2));
			vo.setTitle(rs.getString(3));
			vo.setPrice(rs.getDouble(4));
			vo.setAppdate(rs.getDate(5));
			vo.setAmount(rs.getInt(6));
			vo.setPhoto(rs.getString(7));
			all.add(vo);
		}
		return all;
	}
	@Override
	public List<Resource> findBySplitResource(long currentPage,int lineSize) throws SQLException {
		List<Resource> all = new ArrayList<>();
		String sql="SELECT resid,spid,title,price,appdate,amount,photo FROM resource WHERE spid IN ("
				+ " SELECT spid FROM supply_purchase WHERE status=3) LIMIT ?,?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, (currentPage-1)*lineSize);
		super.pstmt.setInt(2, lineSize);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()) {
			Resource vo = new Resource();
			vo.setResid(rs.getLong(1));
			vo.setSpid(rs.getLong(2));
			vo.setTitle(rs.getString(3));
			vo.setPrice(rs.getDouble(4));
			vo.setAppdate(rs.getDate(5));
			vo.setAmount(rs.getInt(6));
			vo.setPhoto(rs.getString(7));
			all.add(vo);
		}
		return all;
	}
	@Override
	public List<Resource> findByResids(Set<Long> resids) throws SQLException {
		List<Resource> all = new ArrayList<>();
		StringBuffer buf = new StringBuffer();
		buf.append(" SELECT resid,spid,title,price,appdate,amount,photo FROM resource WHERE resid IN(");
		for(Long resid : resids) {
			buf.append(resid).append(",");
		}
		buf.delete(buf.length()-1, buf.length()).append(")");
		super.pstmt=super.conn.prepareStatement(buf.toString());
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()) {
			Resource vo = new Resource();
			vo.setResid(rs.getLong(1));
			vo.setSpid(rs.getLong(2));
			vo.setTitle(rs.getString(3));
			vo.setPrice(rs.getDouble(4));
			vo.setAppdate(rs.getDate(5));
			vo.setAmount(rs.getInt(6));
			vo.setPhoto(rs.getString(7));
			all.add(vo);
		}
		return all;
	}
	@Override
	public boolean doRemoveByResource(Set<Long> resids) throws SQLException {
		StringBuffer buf = new StringBuffer();
		buf.append("DELETE FROM resource WHERE  resid IN(");
		for(Long resid : resids) {
			buf.append(resid).append(",");
		}
		buf.delete(buf.length()-1, buf.length()).append(")");
		super.pstmt=super.conn.prepareStatement(buf.toString());
		return super.pstmt.executeUpdate()>0;
	}
	@Override
	public boolean doEditResource(Long resid,Resource vo) throws SQLException {
		String sql = "UPDATE resource SET title=?,price=?,amount=?,photo=? WHERE resid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getTitle());
		super.pstmt.setDouble(2, vo.getPrice());
		super.pstmt.setInt(3, vo.getAmount());
		super.pstmt.setString(4, vo.getPhoto());
		super.pstmt.setLong(5, resid);
		return super.pstmt.executeUpdate()>0;
	}
	@Override
	public List<Resource> findBySpid(Long spid) throws SQLException {
		List<Resource> all = new ArrayList<>();
		String sql = "SELECT resid,spid,title,price,appdate,amount,photo FROM resource WHERE spid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, spid);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()) {
			Resource vo = new Resource();
			vo.setResid(rs.getLong(1));
			vo.setSpid(rs.getLong(2));
			vo.setTitle(rs.getString(3));
			vo.setPrice(rs.getDouble(4));
			vo.setAppdate(rs.getDate(5));
			vo.setAmount(rs.getInt(6));
			vo.setPhoto(rs.getString(7));
			all.add(vo);
		}
		return all;
	}

	@Override
	public Long findLastId() throws SQLException {
		String sql = "SELECT LAST_INSERT_ID()";
		super.pstmt=super.conn.prepareStatement(sql);
		ResultSet rs = super.pstmt.executeQuery();
		if(rs.next()) {
			return rs.getLong(1);
		}
		return 0L;
	}
		

	@Override
	public boolean doCreate(Resource vo) throws SQLException {
		String sql = "INSERT INTO resource (spid,title,price,appdate,amount,photo)VALUES(?,?,?,?,?,?)";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, vo.getSpid());
		super.pstmt.setString(2, vo.getTitle());
		super.pstmt.setDouble(3, vo.getPrice());
		super.pstmt.setTimestamp(4, new java.sql.Timestamp(vo.getAppdate().getTime()));
		super.pstmt.setInt(5, vo.getAmount());
		super.pstmt.setString(6, vo.getPhoto());
		return super.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doEdit(Resource vo) throws SQLException {
		String sql = "UPDATE resource SET title=?,price=?,amount=?,photo=? WHERE resid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getTitle());
		super.pstmt.setDouble(2, vo.getPrice());
		super.pstmt.setInt(3, vo.getAmount());
		super.pstmt.setString(4, vo.getPhoto());
		super.pstmt.setLong(5, vo.getResid());
		return super.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Resource findById(Long id) throws SQLException {
		String sql = "SELECT resid,spid,title,price,appdate,amount,photo FROM resource WHERE resid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, id);
		ResultSet rs = super.pstmt.executeQuery();
		if(rs.next()) {
			Resource vo =new Resource();
			vo.setResid(rs.getLong(1));
			vo.setSpid(rs.getLong(2));
			vo.setTitle(rs.getString(3));
			vo.setPrice(rs.getDouble(4));
			vo.setAppdate(rs.getDate(5));
			vo.setAmount(rs.getInt(6));
			vo.setPhoto(rs.getString(7));
			return vo;
		}
		return null;
	}

	@Override
	public List<Resource> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resource> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resource> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount() throws SQLException {
		return super.getAllCountHandle("resource");
	}

	@Override
	public Long getAllCount(String column, String keyWord) throws SQLException {
		return super.getAllCountSplitHandle("resource", column, keyWord);
	}



}
