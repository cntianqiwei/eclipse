package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IEmpResourceDetailsDAO;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
import cn.mldn.vo.EmpResourceDetails;
@Repository
public class EmpResourceDetailsDAOImpl extends AbstractDAO implements IEmpResourceDetailsDAO {
	@Override
	public List<EmpResourceDetails> findByEresid(Long eresid) throws SQLException {
		List<EmpResourceDetails> all = new ArrayList<>();
		String sql = "SELECT eredid,eresid,resid,amount FROM emp_resource_details WHERE eresid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, eresid);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()) {
			EmpResourceDetails vo = new EmpResourceDetails();
			vo.setEredid(rs.getLong(1));
			vo.setEresid(rs.getLong(2));
			vo.setResid(rs.getLong(3));
			vo.setAmount(rs.getInt(4));
			all.add(vo);
		}
		return all;
	}

	@Override
	public boolean doCreate(EmpResourceDetails vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doEdit(EmpResourceDetails vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EmpResourceDetails findById(Long id) throws SQLException {
		String sql = "SELECT eredid,eresid,resid,amount FROM emp_resource_details WHERE eresid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, id);
		ResultSet rs = super.pstmt.executeQuery();
		if(rs.next()) {
			EmpResourceDetails vo = new EmpResourceDetails();
			vo.setEredid(rs.getLong(1));
			vo.setEresid(rs.getLong(2));
			vo.setResid(rs.getLong(3));
			vo.setAmount(rs.getInt(4));
			return vo;
		}
		return null;
		
	}

	@Override
	public List<EmpResourceDetails> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpResourceDetails> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpResourceDetails> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
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

}
