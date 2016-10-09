package cn.zhang.em.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.em.vo.Dept;
import cn.mldn.util.dao.IDAO;

public interface IDeptDAO extends IDAO<Integer, Dept> {
	/**
	 * 列出有空余人数的所有部门数据，这样可以在雇员添加的时候进行验证处理
	 * @return
	 * @throws SQLException
	 */
	public List<Dept> findAllByEmpty() throws SQLException;	
	/**
	 * 进行部门当前人数的更新处理操作
	 * @param id 部门编号
	 * @param num 要修改的人员的数量（currnum）
	 * @return
	 * @throws SQLException
	 */
	public boolean doUpdateCurrnum(Integer id,Integer num) throws SQLException;
	
}
