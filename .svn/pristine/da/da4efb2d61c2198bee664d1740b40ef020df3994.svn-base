package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.dao.IDeptDAO;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
import cn.mldn.vo.Dept;
import cn.mldn.vo.Emp;
@Repository
public class DeptDAOImpl extends AbstractDAO implements IDeptDAO {
 
	@Override
	public boolean doCreate(Dept vo) throws SQLException {
		String sql = "INSERT INTO dept(dname,eid,maxnum,currnum) VALUES (?,?,?,?)" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, vo.getDname());
		super.pstmt.setString(2, vo.getEid());
		super.pstmt.setInt(3, vo.getMaxnum());
		super.pstmt.setInt(4, vo.getCurrnum());
		return super.pstmt.executeUpdate() > 0 ;
	}

	@Override
	public boolean doEdit(Dept vo) throws SQLException {
		String sql="update dept set dname=?,maxnum=? where did=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getDname());
		super.pstmt.setInt(2, vo.getMaxnum());
		super.pstmt.setLong(3,vo.getDid());
		return super.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Dept findById(Long id) throws SQLException {
		String sql="select did,dname,eid,maxnum,currnum FROM dept where did=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, id);
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()) {
			Dept dept = new Dept() ;
			dept.setDid(rs.getLong(1));
			dept.setDname(rs.getString(2));
			dept.setEid(rs.getString(3));
			dept.setMaxnum(rs.getInt(4));
			dept.setCurrnum(rs.getInt(5));
			return dept;
		}
		return null;
	}

	@Override
	public List<Dept> findAll() throws SQLException {
		List<Dept> all = new ArrayList<Dept>() ;
		String sql = "SELECT did,dname,eid,maxnum,currnum FROM dept" ;
		super.pstmt = super.conn.prepareStatement(sql) ; 
		ResultSet rs = super.pstmt.executeQuery() ;
		while (rs.next()) {
			Dept dept = new Dept() ;
			dept.setDid(rs.getLong(1));
			dept.setDname(rs.getString(2));
			dept.setEid(rs.getString(3));
			dept.setMaxnum(rs.getInt(4));
			dept.setCurrnum(rs.getInt(5));
			all.add(dept) ;
		}
		return all;
	}


	@Override
	public Long getAllCount() throws SQLException {
		String sql="select count(*) from dept";
		super.pstmt=super.conn.prepareStatement(sql);
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()) {
			return rs.getLong(1);
		}
		return 0L;
	}

	@Override
	public Long getAllCount(String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doCreateDeptRoleDefault() throws SQLException {
		String[] rids= {"plan","reimbursement","resource","schedule"};
		Long did=super.findLastId();
		String sql="insert into dept_role(did,rid) values (?,?)";
		super.pstmt=super.conn.prepareStatement(sql);
		for(int x=0;x<rids.length;x++) {
			super.pstmt.setLong(1, did);
			super.pstmt.setString(2,rids[x]);
			super.pstmt.addBatch();
		}
		int[] result= super.pstmt.executeBatch();
		for(int y=0;y<result.length;y++) {
			if(result[y]==0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Integer getCurrnumById(Long did) throws SQLException {
		String sql="select currnum from dept where did=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, did);
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()) {
			int num=rs.getInt(1);
			return num;
		}
		return null;
	}

	@Override
	public boolean doEditCurrnum(Long did, Integer data) throws SQLException {
		String sql="update dept set currnum=currnum+("+data+") where did=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, did);
		return super.pstmt.executeUpdate()>0;
	}

	@Override
	public Map<Long, Dept> findByEmp(List<Emp> emps) throws SQLException {
		String sql="select did,dname,eid,maxnum,currnum FROM dept where did in(";
		StringBuffer strb=new StringBuffer(sql);
		Iterator<Emp> iter=emps.iterator();
		while(iter.hasNext()) {
			Emp emp=(Emp)iter.next();
			strb.append(emp.getDid()).append(",");
		}
		strb.delete(strb.length()-1, strb.length()).append(")");
		super.pstmt=super.conn.prepareStatement(strb.toString());
		ResultSet rs=super.pstmt.executeQuery();
		Map<Long, Dept> all=new HashMap<Long, Dept>();
		while(rs.next()) {
			Dept dept = new Dept() ;
			dept.setDid(rs.getLong(1));
			dept.setDname(rs.getString(2));
			dept.setEid(rs.getString(3));
			dept.setMaxnum(rs.getInt(4));
			dept.setCurrnum(rs.getInt(5));
			all.put(dept.getDid(),dept) ;
		}
		return all;
	}

	@Override
	public boolean doEditEid(Long did, String eid) throws SQLException {
		String sql="update dept set eid=? where did=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, eid);
		super.pstmt.setLong(2, did);
		return super.pstmt.executeUpdate()>0;
	}

}
