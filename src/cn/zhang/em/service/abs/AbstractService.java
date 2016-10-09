package cn.zhang.em.service.abs;

import cn.mldn.util.factory.DAOFactory;
import cn.zhang.em.dao.IActionDAO;
import cn.zhang.em.dao.impl.ActionDAOImpl;

public abstract class AbstractService {
	/**
	 * 进行相关用户的权限认证查询
	 * @param mid 用户的编号
	 * @param actionFlag 权限的标记信息
	 * @return 如果具备有指定的权限，返回true，否则返回false
	 * @throws Exception
	 */
	public boolean auth(String mid,String actionFlag) throws Exception{
		IActionDAO actionDAO = DAOFactory.getInstance(ActionDAOImpl.class);
		return actionDAO.findExists(mid, actionFlag);
	}
}
