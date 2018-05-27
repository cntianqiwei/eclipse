package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IEmpCareerDAO;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
import cn.mldn.vo.EmpCareer;
@Repository
public class EmpCareerDAOImpl extends AbstractDAO implements IEmpCareerDAO{

	@Override
	public boolean doCreate(EmpCareer vo) throws SQLException {
		String sql="insert into emp_career(eid,company,position,salary,entry,quit,reason,note) values (?,?,?,?,?,?,?,?)";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getEid());
		super.pstmt.setString(2, vo.getCompany());
		super.pstmt.setString(3, vo.getPosition());
		super.pstmt.setDouble(4, vo.getSalary());
		super.pstmt.setDate(5, new java.sql.Date(vo.getEntry().getTime()));
		super.pstmt.setDate(6, new java.sql.Date(vo.getQuit().getTime()));
		super.pstmt.setString(7, vo.getReason());
		super.pstmt.setString(8, vo.getNote());
		return super.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doEdit(EmpCareer vo) throws SQLException {
		String sql="update emp_career set company=?,position=?,salary=?,entry=?,quit=?,reason=?,note=? where ecarid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getCompany());
		super.pstmt.setString(2, vo.getPosition());
		super.pstmt.setDouble(3, vo.getSalary());
		super.pstmt.setDate(4,new java.sql.Date(vo.getEntry().getTime()));
		super.pstmt.setDate(5, new java.sql.Date(vo.getQuit().getTime()));
		super.pstmt.setString(6, vo.getReason());
		super.pstmt.setString(7, vo.getNote());
		super.pstmt.setLong(8,vo.getEcarid());
		return super.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		String sql="delete from emp_career where ecarid in(";
		StringBuffer strb=new StringBuffer(sql);
		Iterator iter=ids.iterator();
		while(iter.hasNext()) {
			strb.append(iter.next()).append(",");
		}
		strb=strb.delete(strb.length()-1, strb.length()).append(")");
		super.pstmt=super.conn.prepareStatement(strb.toString());
		return super.pstmt.executeUpdate()>0;
	}

	@Override
	public EmpCareer findById(Long id) throws SQLException {
		String sql="select ecarid,eid,company,position,salary,entry,quit,reason,note from emp_career where ecarid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, id);
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()) {
			EmpCareer vo=new EmpCareer();
			vo.setEcarid(rs.getLong(1));
			vo.setEid(rs.getString(2));
			vo.setCompany(rs.getString(3));
			vo.setPosition(rs.getString(4));
			vo.setSalary(rs.getDouble(5));
			vo.setEntry(rs.getDate(6));
			vo.setQuit(rs.getDate(7));
			vo.setReason(rs.getString(8));
			vo.setNote(rs.getString(9));
			return vo;
		}
		return null;
	}

	@Override
	public List<EmpCareer> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpCareer> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpCareer> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
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
	public List<EmpCareer> findByEid(String eid) throws SQLException {
		String sql="select ecarid,eid,company,position,salary,entry,quit,reason,note from emp_career where eid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, eid);
		ResultSet rs=super.pstmt.executeQuery();
		List<EmpCareer> all=new ArrayList<EmpCareer>();
		while(rs.next()) {
			EmpCareer vo=new EmpCareer();
			vo.setEcarid(rs.getLong(1));
			vo.setEid(rs.getString(2));
			vo.setCompany(rs.getString(3));
			vo.setPosition(rs.getString(4));
			vo.setSalary(rs.getDouble(5));
			vo.setEntry(rs.getDate(6));
			vo.setQuit(rs.getDate(7));
			vo.setReason(rs.getString(8));
			vo.setNote(rs.getString(9));
			all.add(vo);
		}
		return all;
	}

	@Override
	public boolean doRemoveByIds(Set<Long> ids) throws SQLException {
		String sql="delete from emp_career where ecarid in (";
		StringBuffer strb=new StringBuffer(sql);
		Iterator iter=ids.iterator();
		while(iter.hasNext()) {
			strb.append(iter.next()).append(",");
		}
		strb.delete(strb.length()-1, strb.length()).append(")");
		super.pstmt=super.conn.prepareStatement(strb.toString());
		return super.pstmt.executeUpdate()>0;
	}

}
