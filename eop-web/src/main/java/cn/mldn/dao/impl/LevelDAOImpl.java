package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.dao.ILevelDAO;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
import cn.mldn.vo.Emp;
import cn.mldn.vo.Level;

@Repository
public class LevelDAOImpl extends AbstractDAO implements ILevelDAO {

	@Override
	public Long findLastId() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doCreate(Level vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doEdit(Level vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Level findById(Integer id) throws SQLException {
		String sql="select lid,title,losal,hisal from level where lid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, id);
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()) {
			Level level=new Level();
			level.setLid(rs.getInt(1));
			level.setTitle(rs.getString(2));
			level.setLosal(rs.getDouble(3));
			level.setHisal(rs.getDouble(4));
			return level;
		}
		return null;
	}

	@Override
	public List<Level> findAll() throws SQLException {
		String sql="select lid,title,losal,hisal from level";
		super.pstmt=super.conn.prepareStatement(sql);
		List<Level> all=new ArrayList<Level>();
		ResultSet rs=super.pstmt.executeQuery();
		while(rs.next()) {
			Level level=new Level();
			level.setLid(rs.getInt(1));
			level.setTitle(rs.getString(2));
			level.setLosal(rs.getDouble(3));
			level.setHisal(rs.getDouble(4));
			all.add(level);
		}
		return all;
	}

	@Override
	public List<Level> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Level> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
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
	public Map<Integer, Level> findByEmps(List<Emp> emps) throws SQLException {
		String sql="select lid,title,losal,hisal FROM level where lid in(";
		StringBuffer strb=new StringBuffer(sql);
		Iterator<Emp> iter=emps.iterator();
		while(iter.hasNext()) {
			Emp emp=(Emp)iter.next();
			strb.append(emp.getLid()).append(",");
		}
		strb.delete(strb.length()-1, strb.length()).append(")");
		super.pstmt=super.conn.prepareStatement(strb.toString());
		ResultSet rs=super.pstmt.executeQuery();
		Map<Integer, Level> all=new HashMap<Integer, Level>();
		while(rs.next()) {
			Level level=new Level();
			level.setLid(rs.getInt(1));
			level.setTitle(rs.getString(2));
			level.setLosal(rs.getDouble(3));
			level.setHisal(rs.getDouble(4));
			all.put(level.getLid(),level) ;
		}
		return all;
	}

}
