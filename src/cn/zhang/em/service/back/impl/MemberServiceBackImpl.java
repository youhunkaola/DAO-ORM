package cn.zhang.em.service.back.impl;

import java.util.HashMap;
import java.util.Map;

import cn.mldn.em.vo.Member;
import cn.mldn.util.factory.DAOFactory;
import cn.mldn.zhang.service.back.IMemberServiceBack;
import cn.zhang.em.dao.IActionDAO;
import cn.zhang.em.dao.IMemberDAO;
import cn.zhang.em.dao.IRoleDAO;
import cn.zhang.em.dao.impl.ActionDAOImpl;
import cn.zhang.em.dao.impl.MemberDAOImpl;
import cn.zhang.em.dao.impl.RoleDAOImpl;
import cn.zhang.em.service.abs.AbstractService;

public class MemberServiceBackImpl extends AbstractService implements IMemberServiceBack {

	@Override
	public Map<String, Object> login(Member vo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		IMemberDAO memberDAO = DAOFactory.getInstance(MemberDAOImpl.class);
		Member ckVo = memberDAO.findById(vo.getMid()); // 根据用户的ID取得用户完整数据
		if (ckVo != null) {
			if (ckVo.getPassword().equals(vo.getPassword())) { // 现在密码验证通过
				IRoleDAO roleDAO = DAOFactory.getInstance(RoleDAOImpl.class) ;
				IActionDAO actionDAO = DAOFactory.getInstance(ActionDAOImpl.class) ;
				map.put("flag", true); // 存储登录成功的标志位
				map.put("name", ckVo.getName()); // 将真实姓名取出
				map.put("sflag", ckVo.getSflag()); // 保存管理员标志
				map.put("allRoles", roleDAO.findAllByMember(vo.getMid())) ;
				map.put("allActions", actionDAO.findAllByMember(vo.getMid())) ;
			} else {
				map.put("flag", false); // 存储登录成功的标志位
			}
		} else {
			map.put("flag", false); // 存储登录成功的标志位 
		}
		return map;
	}
}
