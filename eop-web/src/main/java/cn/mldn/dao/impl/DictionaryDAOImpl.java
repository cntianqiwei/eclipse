package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IDictionaryDAO;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
import cn.mldn.vo.Dictionary;
@Repository
public class DictionaryDAOImpl extends AbstractDAO implements IDictionaryDAO {

	@Override
	public boolean doCreate(Dictionary vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doEdit(Dictionary vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Dictionary findById(Long id) throws SQLException {
		
		return null;
	}

	@Override
	public List<Dictionary> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dictionary> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dictionary> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
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
	public List<Dictionary> findByType(String type) throws SQLException {
		List<Dictionary> all = new ArrayList<>() ;
		String sql = "SELECT dctid,type,title,value FROM dictionary WHERE type=?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, type);
		ResultSet rs = super.pstmt.executeQuery() ;
		while(rs.next()) {
			Dictionary vo = new Dictionary() ;
			vo.setDctid(rs.getLong(1));
			vo.setType(rs.getString(2));
			vo.setTitle(rs.getString(3));
			vo.setValue(rs.getString(4));
			all.add(vo) ;
		}
		return all;
	}

}
