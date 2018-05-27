package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.dao.IEmpDAO;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
import cn.mldn.vo.Dept;
import cn.mldn.vo.Emp;
@Repository
public class EmpDAOImpl extends AbstractDAO implements IEmpDAO {

	@Override
	public boolean doCreate(Emp vo) throws SQLException {
		String sql="insert into emp(eid,lid,did,ename,salary,phone,password,photo,note,hiredate,ineid,status) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1,vo.getEid());
		super.pstmt.setInt(2,vo.getLid());
		
		super.pstmt.setLong(3,vo.getDid());
		super.pstmt.setString(4,vo.getEname());
		super.pstmt.setDouble(5,vo.getSalary());
		super.pstmt.setString(6,vo.getPhone());
		super.pstmt.setString(7,vo.getPassword());
		super.pstmt.setString(8,vo.getPhoto());
		super.pstmt.setString(9,vo.getNote());
		super.pstmt.setDate(10,new java.sql.Date(vo.getHiredate().getTime()));
		super.pstmt.setString(11,vo.getIneid());
		super.pstmt.setInt(12,vo.getStatus());
		
		return super.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doEdit(Emp vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Emp findById(String id) throws SQLException {
		String sql = "SELECT eid,lid,did,ename,salary,phone,password,photo,note,hiredate,ineid,status from emp WHERE eid=?" ;
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, id);
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()) {
			Emp emp = new Emp() ;
			emp.setEid(rs.getString(1));
			emp.setLid(rs.getInt(2));
			emp.setDid(rs.getLong(3));
			emp.setEname(rs.getString(4));
			emp.setSalary(rs.getDouble(5));
			emp.setPhone(rs.getString(6));
			emp.setPassword(rs.getString(7));
			emp.setPhoto(rs.getString(8));
			emp.setNote(rs.getString(9));
			emp.setHiredate(rs.getDate(10));
			emp.setIneid(rs.getString(11));
			emp.setStatus(rs.getInt(12));
			return emp ;
		}
		return null;
	}

	@Override
	public List<Emp> findAll() throws SQLException {
		String sql="select eid,lid,did,ename,salary,phone,password,photo,note,hiredate,ineid,status from emp where status!=2";
		super.pstmt=super.conn.prepareStatement(sql);
		ResultSet rs=super.pstmt.executeQuery();
		List<Emp> all=new ArrayList<Emp>();
		while(rs.next()) {
			Emp emp=new Emp();
			emp.setEid(rs.getString(1));
			emp.setLid(rs.getInt(2));
			emp.setDid(rs.getLong(3));
			emp.setEname(rs.getString(4));
			emp.setSalary(rs.getDouble(5));
			emp.setPhone(rs.getString(6));
			emp.setPassword(rs.getString(7));
			emp.setPhoto(rs.getString(8));
			emp.setNote(rs.getString(9));
			emp.setHiredate(rs.getDate(10));
			emp.setIneid(rs.getString(11));
			emp.setStatus(rs.getInt(12));
			all.add( emp);
		}
		return all;
	}

	@Override
	public List<Emp> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		String sql="select eid,lid,did,ename,salary,phone,password,photo,note,hiredate,ineid,status from emp where status!=2 limit ?,?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, (currentPage-1)*lineSize);
		super.pstmt.setInt(2, lineSize);
		ResultSet rs=super.pstmt.executeQuery();
		List<Emp> all=new ArrayList<Emp>();
		while(rs.next()) {
			Emp emp=new Emp();
			emp.setEid(rs.getString(1));
			emp.setLid(rs.getInt(2));
			emp.setDid(rs.getLong(3));
			emp.setEname(rs.getString(4));
			emp.setSalary(rs.getDouble(5));
			emp.setPhone(rs.getString(6));
			emp.setPassword(rs.getString(7));
			emp.setPhoto(rs.getString(8));
			emp.setNote(rs.getString(9));
			emp.setHiredate(rs.getDate(10));
			emp.setIneid(rs.getString(11));
			emp.setStatus(rs.getInt(12));
			all.add( emp);
		}
		return all;
	}

	@Override
	public List<Emp> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
		String sql="select eid,lid,did,ename,salary,phone,password,photo,note,hiredate,ineid,status from emp where "+column+" like ? and status!=2 limit ?,?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, "%"+keyWord+"%");
		super.pstmt.setLong(2, (currentPage-1)*lineSize);
		super.pstmt.setInt(3, lineSize);
		ResultSet rs=super.pstmt.executeQuery();
		List<Emp> all=new ArrayList<Emp>();
		while(rs.next()) {
			Emp emp=new Emp();
			emp.setEid(rs.getString(1));
			emp.setLid(rs.getInt(2));
			emp.setDid(rs.getLong(3));
			emp.setEname(rs.getString(4));
			emp.setSalary(rs.getDouble(5));
			emp.setPhone(rs.getString(6));
			emp.setPassword(rs.getString(7));
			emp.setPhoto(rs.getString(8));
			emp.setNote(rs.getString(9));
			emp.setHiredate(rs.getDate(10));
			emp.setIneid(rs.getString(11));
			emp.setStatus(rs.getInt(12));
			all.add( emp);
		}
		return all;
	}

	@Override
	public Long getAllCount() throws SQLException {
		String sql="select count(*) from emp";
		super.pstmt=super.conn.prepareStatement(sql);
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()) {
			return rs.getLong(1);
		}
		return 0L;
	}

	@Override
	public Long getAllCount(String column, String keyWord) throws SQLException {
		String sql="select count(*) from emp where "+column+" like ?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, "%"+keyWord+"%");
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()) {
			return rs.getLong(1);
		}
		return 0L;
	}

	@Override
	public Map<String, Emp> findByDept(List<Dept> depts) throws SQLException {
		String sql="select eid,lid,did,ename,salary,phone,password,photo,note,hiredate,ineid,status from emp where eid in(";
		StringBuffer strb=new StringBuffer(sql);
		Iterator<Dept> iter=depts.iterator();
		while(iter.hasNext()) {
			Dept dept=(Dept)iter.next();
			strb.append("'").append(dept.getEid()).append("'").append(",");
		}
		strb.delete(strb.length()-1, strb.length()).append(")");
		super.pstmt=super.conn.prepareStatement(strb.toString());
		ResultSet rs=super.pstmt.executeQuery();
		Map<String,Emp> all=new HashMap<String,Emp>();
		while(rs.next()) {
			Emp emp=new Emp();
			emp.setEid(rs.getString(1));
			emp.setLid(rs.getInt(2));
			emp.setDid(rs.getLong(3));
			emp.setEname(rs.getString(4));
			emp.setSalary(rs.getDouble(5));
			emp.setPhone(rs.getString(6));
			emp.setPassword(rs.getString(7));
			emp.setPhoto(rs.getString(8));
			emp.setNote(rs.getString(9));
			emp.setHiredate(rs.getDate(10));
			emp.setIneid(rs.getString(11));
			emp.setStatus(rs.getInt(12));
			all.put(rs.getString(1), emp);
		}
		return all;
	}

	@Override
	public List<Emp> findByEidAndDid(String eid,long did) throws SQLException {
		List<Emp> all=new ArrayList<Emp>();
		String sql="select eid,lid,did,ename,salary,phone,password,photo,note,hiredate,ineid,status from emp "
				+ " where lid>(select lid from emp where eid=?) and did=? and status=0";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, eid);
		super.pstmt.setLong(2, did);
		ResultSet rs=super.pstmt.executeQuery();
		while(rs.next()) {
			Emp emp=new Emp();
			emp.setEid(rs.getString(1));
			emp.setLid(rs.getInt(2));
			emp.setDid(rs.getLong(3));
			emp.setEname(rs.getString(4));
			emp.setSalary(rs.getDouble(5));
			emp.setPhone(rs.getString(6));
			emp.setPassword(rs.getString(7));
			emp.setPhoto(rs.getString(8));
			emp.setNote(rs.getString(9));
			emp.setHiredate(rs.getDate(10));
			emp.setIneid(rs.getString(11));
			emp.setStatus(rs.getInt(12));
			all.add( emp);
		}
		return all;
	}
	@Override
	public boolean doRemoveByIds(List<String> ids) throws SQLException {
		String sql="update emp set status=2 where eid in (";
		StringBuffer strb=new StringBuffer(sql);
		@SuppressWarnings("rawtypes")
		Iterator iter=ids.iterator();
		while(iter.hasNext()) {
			strb.append("'").append(iter.next()).append("'").append(",");
		}
		strb.delete(strb.length()-1, strb.length()).append(")");
		super.pstmt=super.conn.prepareStatement(strb.toString());
		return super.pstmt.executeUpdate()>0;
	}
	@Override
	public List<Long> findDidsByEids(List<String> eids) throws SQLException {
		String sql="select did from emp where eid in(";
		StringBuffer strb=new StringBuffer(sql);
		@SuppressWarnings("rawtypes")
		Iterator iter=eids.iterator();
		while(iter.hasNext()) {
			strb.append("'").append(iter.next()).append("'").append(",");
		}
		strb.delete(strb.length()-1, strb.length()).append(")");
		super.pstmt=super.conn.prepareStatement(strb.toString());
		List<Long> dids=new ArrayList<Long>();
		ResultSet rs=super.pstmt.executeQuery();
		while(rs.next()) {
			dids.add(rs.getLong(1));
		}
		return dids;
	}
	@Override
	public boolean findByIdCheck(String eid) throws SQLException {
		String sql="select ename from emp where eid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, eid);
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()) {
			return false;
		}else {
			return true;
		}
	}

}
