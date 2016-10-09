package cn.zhang.em.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.em.vo.Emp;
import cn.mldn.util.dao.AbstractDAO;
import cn.zhang.em.dao.IEmpDAO;

public class EmpDAOImpl extends AbstractDAO implements IEmpDAO {

	@Override
	public boolean doCreate(Emp vo) throws SQLException {
		String sql="insert into emp(ename,job,sal,comm,hiredate,photo,flag,mid,lid,deptno) "
				+ " values (?,?,?,?,?,?,?,?,?,?)";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getEname());
		super.pstmt.setString(2, vo.getJob());
		super.pstmt.setDouble(3, vo.getSal());
		super.pstmt.setDouble(4, vo.getComm());
		super.pstmt.setDate(5, new java.sql.Date(vo.getHiredate().getTime()));
		super.pstmt.setString(6, vo.getPhoto());
		super.pstmt.setInt(7, vo.getFlag());
		super.pstmt.setString(8, vo.getMid());
		super.pstmt.setInt(9, vo.getLid());
		super.pstmt.setInt(10, vo.getDeptno());
		return super.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doUpdate(Emp vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Emp findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> findAllSplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> findAllSplit(String column, String keyWord, Integer currentPage, Integer lineSize)
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


}
