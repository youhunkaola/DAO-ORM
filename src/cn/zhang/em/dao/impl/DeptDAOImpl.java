package cn.zhang.em.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.em.vo.Dept;
import cn.mldn.util.dao.AbstractDAO;
import cn.zhang.em.dao.IDeptDAO;

public class DeptDAOImpl extends AbstractDAO implements IDeptDAO {

	@Override
	public boolean doCreate(Dept vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Dept vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Dept findById(Integer id) throws SQLException {
		Dept vo = null;
		String sql = "SELECT deptno,dname,maxnum,currnum FROM dept" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		ResultSet rs = super.pstmt.executeQuery() ;
		if (rs.next()) {
			vo = new Dept() ;
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2));
			vo.setMaxnum(rs.getInt(3));
			vo.setCurrnum(rs.getInt(4));
		}
		return vo;
	}

	@Override
	public List<Dept> findAll() throws SQLException {
		List<Dept> all = new ArrayList<Dept>() ;
		String sql = "SELECT deptno,dname,maxnum,currnum FROM dept" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		ResultSet rs = super.pstmt.executeQuery() ;
		while (rs.next()) {
			Dept vo = new Dept() ;
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2));
			vo.setMaxnum(rs.getInt(3));
			vo.setCurrnum(rs.getInt(4));
			all.add(vo) ;
		}
		return all;
	}

	@Override
	public List<Dept> findAllSplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> findAllSplit(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> findAllByEmpty() throws SQLException {
		List<Dept> all = new ArrayList<Dept>() ;
		String sql = "SELECT deptno,dname,maxnum,currnum FROM dept where currnum<maxnum" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		ResultSet rs = super.pstmt.executeQuery();
		while (rs.next()) {
			Dept vo = new Dept() ;
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2));
			vo.setMaxnum(rs.getInt(3));
			vo.setCurrnum(rs.getInt(4));
			all.add(vo) ;
		}
		return all;
	}

	@Override
	public boolean doUpdateCurrnum(Integer id, Integer num) throws SQLException {
		String sql="update dept set currnum=currnum+ "+num+" where deptno=?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, id);
		return super.pstmt.executeUpdate()>0;
	}

}
