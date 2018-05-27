package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IPlanDAO;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
import cn.mldn.util.web.servlet.ServletObjectUtil;
import cn.mldn.vo.Emp;
import cn.mldn.vo.Plan;
@Repository
public class PlanDAOImpl extends AbstractDAO implements IPlanDAO {
	@Override
	public boolean doCreate(Plan vo) throws SQLException {
		String sql = "INSERT INTO plan(title,item,starttime,endtime,note,status,amount,eid) VALUES(?,?,?,?,?,?,?,?)" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, vo.getTitle());
		super.pstmt.setString(2, vo.getItem());
		super.pstmt.setDate(3, new java.sql.Date(vo.getStarttime().getTime()));
		super.pstmt.setDate(4, new java.sql.Date(vo.getEndtime().getTime()));
		super.pstmt.setString(5, vo.getNote());
		super.pstmt.setInt(6, vo.getStatus());
		super.pstmt.setInt(7, vo.getAmount());
		super.pstmt.setString(8, vo.getEid());
		return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doEdit(Plan vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		StringBuffer sql = new StringBuffer("DELETE FROM plan WHERE status=0 AND pid IN(") ;
		for(Long id : ids) {
			sql.append(id).append(",") ;
		}
		sql.delete(sql.length()-1, sql.length()) ;
		sql.append(")") ;
		super.pstmt = super.conn.prepareStatement(sql.toString()) ;
		//删除数据必须和传入数据数量一致
		return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public Plan findById(Long id) throws SQLException {
		String sql = "SELECT pid,eid,title,item,starttime,endtime,note,status,amount FROM plan WHERE pid=?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setLong(1, id);
		ResultSet rs = super.pstmt.executeQuery() ;
		if(rs.next()) {
			Plan vo = new Plan() ;
			vo.setPid(rs.getLong("pid"));
			vo.setTitle(rs.getString("title"));
			vo.setItem(rs.getString("item"));
			vo.setStarttime(rs.getDate("starttime"));
			vo.setEndtime(rs.getDate("endtime"));
			vo.setNote(rs.getString("note"));
			vo.setStatus(rs.getInt("status"));
			vo.setAmount(rs.getInt("amount"));
			vo.setEid(rs.getString("eid"));
			return vo ;
		}
		return null;
	}

	@Override
	public List<Plan> findAll() throws SQLException {
		List<Plan> all = new ArrayList<Plan>() ;
		String sql = "SELECT pid,eid,title,item,starttime,endtime,note,status,amount FROM plan" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		ResultSet rs = super.pstmt.executeQuery() ;
		while(rs.next()) {
			Plan vo = new Plan() ;
			vo.setPid(rs.getLong("pid"));
			vo.setTitle(rs.getString("title"));
			vo.setItem(rs.getString("item"));
			vo.setStarttime(rs.getDate("starttime"));
			vo.setEndtime(rs.getDate("endtime"));
			vo.setNote(rs.getString("note"));
			vo.setStatus(rs.getInt("status"));
			vo.setAmount(rs.getInt("amount"));
			vo.setEid(rs.getString("eid"));
			all.add(vo) ;
		}
		return all;
	}

	@Override
	public List<Plan> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		List<Plan> all = new ArrayList<Plan>() ;
		String sql = "SELECT pid,eid,title,item,starttime,endtime,note,status,amount FROM plan WHERE status=1 or(eid=? and status=0)  limit ?,?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, (String)ServletObjectUtil.getRequest().getSession().getAttribute("mid"));
		super.pstmt.setLong(2, (currentPage - 1) * lineSize);
		super.pstmt.setLong(3, lineSize);
		ResultSet rs = super.pstmt.executeQuery() ;
		while(rs.next()) {
			Plan vo = new Plan() ;
			vo.setPid(rs.getLong("pid"));
			vo.setTitle(rs.getString("title"));
			vo.setItem(rs.getString("item"));
			vo.setStarttime(rs.getDate("starttime"));
			vo.setEndtime(rs.getDate("endtime"));
			vo.setNote(rs.getString("note"));
			vo.setStatus(rs.getInt("status"));
			vo.setAmount(rs.getInt("amount"));
			vo.setEid(rs.getString("eid"));
			all.add(vo) ;
		}
		return all;
	}

	@Override
	public List<Plan> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
		List<Plan> all = new ArrayList<Plan>() ;
		String sql = "SELECT pid,eid,title,item,starttime,endtime,note,status,amount FROM plan WHERE (status=1 or (eid=? and status=0)) AND "+column+" LIKE ? limit ?,?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, (String)ServletObjectUtil.getRequest().getSession().getAttribute("mid"));
		super.pstmt.setString(2, "%" + keyWord + "%");
		super.pstmt.setLong(3, (currentPage - 1) * lineSize);
		super.pstmt.setLong(4, lineSize);
		ResultSet rs = super.pstmt.executeQuery() ;
		while(rs.next()) {
			Plan vo = new Plan() ;
			vo.setPid(rs.getLong("pid"));
			vo.setTitle(rs.getString("title"));
			vo.setItem(rs.getString("item"));
			vo.setStarttime(rs.getDate("starttime"));
			vo.setEndtime(rs.getDate("endtime"));
			vo.setNote(rs.getString("note"));
			vo.setStatus(rs.getInt("status"));
			vo.setAmount(rs.getInt("amount"));
			vo.setEid(rs.getString("eid"));
			all.add(vo) ;
		}
		return all;
	}

	@Override
	public Long getAllCount() throws SQLException {
		String sql = "SELECT COUNT(*) FROM plan WHERE status=1 or (eid=? and status=0)" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, (String)ServletObjectUtil.getRequest().getSession().getAttribute("mid"));
		ResultSet rs = super.pstmt.executeQuery() ;
		if(rs.next()) {
			return rs.getLong(1) ;
		}
		return 0L;
	}

	@Override
	public Long getAllCount(String column, String keyWord) throws SQLException {
		String sql = "SELECT count(*) FROM plan WHERE (status=1 or (eid=? and status=0)) AND "+column+" LIKE ? " ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, (String)ServletObjectUtil.getRequest().getSession().getAttribute("mid"));
		super.pstmt.setString(2, "%" + keyWord + "%");
		ResultSet rs = super.pstmt.executeQuery() ;
		if(rs.next()) {
			return rs.getLong(1) ;
		}
		return 0L;
	}

	@Override
	public boolean doEditStatusById(long pid,int status) throws SQLException {
		String sql = "UPDATE plan SET status=? WHERE pid=?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setInt(1, status);
		super.pstmt.setLong(2, pid);
		return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public List<Emp> findEmpbyPid(long pid) throws SQLException {
		List<Emp> all = new ArrayList<Emp>() ;
		String sql = "select eid,lid,did,ename,salary,phone,password,"
				+ "photo,note,hiredate,ineid,status from emp where eid in( "
				+ "select eid from plan_details where pid=?)" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setLong(1, pid);
		ResultSet rs = super.pstmt.executeQuery();
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
			all.add(emp) ;
		}
		return all;
	}

	@Override
	public boolean doEditAmout(long pid, int count) throws SQLException {
		String sql = "UPDATE plan SET amount=amount+? WHERE pid=?" ;
		super.pstmt=super.conn.prepareStatement(sql) ;
		super.pstmt.setInt(1, count);
		super.pstmt.setLong(2, pid);
		return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean timeConflict(String eid, Plan plan) throws SQLException {
		String sql = "SELECT count(*) FROM "
				+ " (SELECT * FROM plan WHERE pid IN(SELECT pid FROM plan_details WHERE eid=?))emptask "
				+ " WHERE emptask.starttime > ? or emptask.endtime < ? ";
		//判断条件为逆向判断，即按照没有冲突来查询
		//雇员任务的开始时间 > 任务的结尾时间 
		//雇员任务的结束时间 < 任务的开始时间
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, eid);
		super.pstmt.setDate(2, new java.sql.Date(plan.getEndtime().getTime()));
		super.pstmt.setDate(3, new java.sql.Date(plan.getStarttime().getTime()));
		ResultSet rs = super.pstmt.executeQuery() ;
		if(rs.next()) {
			long count = rs.getLong(1) ;
			if(count > 0) {
				//没有冲突 返回false
				return false ;
			}
		}
		//有冲突
		return true ;
	}




}
