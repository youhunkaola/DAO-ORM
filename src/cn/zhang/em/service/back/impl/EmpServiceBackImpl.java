package cn.zhang.em.service.back.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.mldn.em.vo.Dept;
import cn.mldn.em.vo.Emp;
import cn.mldn.em.vo.Level;
import cn.mldn.util.factory.DAOFactory;
import cn.mldn.zhang.service.back.IEmpServiceBack;
import cn.zhang.em.dao.IDeptDAO;
import cn.zhang.em.dao.IEmpDAO;
import cn.zhang.em.dao.ILevelDAO;
import cn.zhang.em.dao.impl.DeptDAOImpl;
import cn.zhang.em.dao.impl.EmpDAOImpl;
import cn.zhang.em.dao.impl.LevelDAOImpl;
import cn.zhang.em.service.abs.AbstractService;

public class EmpServiceBackImpl extends AbstractService implements IEmpServiceBack {

	@Override
	public Map<String, Object> addPre(String mid) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(super.auth(mid, "emp:add")){
			IDeptDAO deptDAO = DAOFactory.getInstance(DeptDAOImpl.class);
			ILevelDAO levelDAO = DAOFactory.getInstance(LevelDAOImpl.class);
			map.put("allDepts", deptDAO.findAll());
			map.put("allLevels", levelDAO.findAll());
		}
		return map;
	}

	@Override
	public boolean add(Emp vo) throws Exception {
		if(super.auth(vo.getMid(), "emp:add")){
			IDeptDAO deptDAO = DAOFactory.getInstance(DeptDAOImpl.class);
			Dept dept = deptDAO.findById(vo.getDeptno());// 根据雇员所在的部门查询部门数据
			if(dept.getCurrnum()<dept.getMaxnum()){// 现在部门有容量
				ILevelDAO levelDAO = DAOFactory.getInstance(LevelDAOImpl.class);
				Level level = levelDAO.findById(vo.getLid());// 取得指定的级别信息
				// 判断增加的雇员工资是否在指定的级别范围之内
				if(vo.getSal()>level.getLosal() && vo.getSal()<level.getHisal()){
					IEmpDAO empDAO = DAOFactory.getInstance(EmpDAOImpl.class);
					vo.setFlag(1);// 表示当前员工在职
					vo.setHiredate(new Date());// 雇佣日期为今天的日期
					if(empDAO.doCreate(vo)){// 雇员保存成功，那么随后还需要进行部门人数的增加
						deptDAO.doUpdateCurrnum(vo.getDeptno(), 1);
					}
					
				}
				
			}
			
		}
		
		return false;
	}




}
