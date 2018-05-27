package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IEmpEducationDAO;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
import cn.mldn.vo.EmpEducation;
@Repository
public class EmpEducationDAOImpl extends AbstractDAO implements IEmpEducationDAO {

	@Override
	public Long findLastId() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doCreate(EmpEducation vo) throws SQLException {
		String sql="insert into emp_education(eid,school,degree,major,entrance,graduation,note) values (?,?,?,?,?,?,?)";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getEid());
		super.pstmt.setString(2, vo.getSchool());
		super.pstmt.setString(3, vo.getDegree());
		super.pstmt.setString(4, vo.getMajor());
		super.pstmt.setDate(5, new java.sql.Date(vo.getEntrance().getTime()));
		super.pstmt.setDate(6,  new java.sql.Date(vo.getGraduation().getTime()));
		super.pstmt.setString(7, vo.getNote());
		
		return super.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doEdit(EmpEducation vo) throws SQLException {
		String sql="update emp_education set school=?,degree=?,major=?,entrance=?,graduation=?,note=? where eeduid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getSchool());
		super.pstmt.setString(2, vo.getDegree());
		super.pstmt.setString(3, vo.getMajor());
		super.pstmt.setDate(4, new java.sql.Date(vo.getEntrance().getTime()));
		super.pstmt.setDate(5, new java.sql.Date(vo.getGraduation().getTime()));
		super.pstmt.setString(6, vo.getNote());
		super.pstmt.setLong(7, vo.getEeduid());
		return super.pstmt.executeUpdate()>0;
				
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		String sql="delete from emp_education where eeduid in(";
		StringBuffer strb=new StringBuffer(sql);
		Iterator iter=ids.iterator();
		while(iter.hasNext()) {
			strb.append(iter.next()).append(",");
		}
		strb.delete(strb.length()-1, strb.length()).append(")");
		super.pstmt=super.conn.prepareStatement(strb.toString());
		
		return super.pstmt.executeUpdate()>0;
	}

	@Override
	public EmpEducation findById(Long id) throws SQLException {
		String sql="select eeduid,eid,school,degree,major,entrance,graduation,note from emp_education where eeduid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, id);
		ResultSet rs=super.pstmt.executeQuery();
		EmpEducation vo=null;
		if(rs.next()) {
			vo=new EmpEducation();
			vo.setEeduid(rs.getLong(1));
			vo.setEid(rs.getString(2));
			vo.setSchool(rs.getString(3));
			vo.setDegree(rs.getString(4));
			vo.setMajor(rs.getString(5));
			vo.setEntrance(rs.getDate(6));
			vo.setGraduation(rs.getDate(7));
			vo.setNote(rs.getString(8));
			return vo;
		}
		return null;
	}

	@Override
	public List<EmpEducation> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpEducation> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpEducation> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
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
	public List<EmpEducation> findByEid(String eid) throws SQLException {
		String sql="select eeduid,eid,school,degree,major,entrance,graduation,note from emp_education where eid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, eid);
		List<EmpEducation> all=new ArrayList<EmpEducation>();
		ResultSet rs=super.pstmt.executeQuery();
		while(rs.next()) {
			EmpEducation vo=new EmpEducation();
			vo.setEeduid(rs.getLong(1));
			vo.setEid(rs.getString(2));
			vo.setSchool(rs.getString(3));
			vo.setDegree(rs.getString(4));
			vo.setMajor(rs.getString(5));
			vo.setEntrance(rs.getDate(6));
			vo.setGraduation(rs.getDate(7));
			vo.setNote(rs.getString(8));
			all.add(vo);
		}
		return all;
	}

}
