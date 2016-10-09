package cn.mldn.zhang.service.back;

import java.util.Map;

import cn.mldn.em.vo.Member;

public interface IMemberServiceBack {
	/**
	 * 实现用户的登录处理，在登录处理之中需要进行如下的功能操作：<br>
	 * 1、实现基本的用户名和密码检测，检测成功之后需要取出mid（登录检测）和name信息进行前台显示；<br>
	 * 2、要根据用户查询出所有的角色信息；<br>
	 * 3、要根据用户查询出所有对应的权限信息。<br>
	 * @param vo 包含有用户输入的用户名和密码
	 * @return 要返回有如下数据内容：<br>
	 * key = flag 、value = true | false，表示登录成功或失败的标记；<br>
	 * key = sflag、value = 1 | 0，表示当前登录的账户是否是超级管理员；<br>
	 * key = name、value = 真实姓名，表示当前管理员的真实姓名，此信息要在界面上显示；<br>
	 * key = allRoles、value = Set，保存所有的角色数据；<br>
	 * key = allActions、value = Set，保存所有的权限数据；<br>
	 * @throws Exception 
	 */
	public Map<String,Object> login(Member vo) throws Exception ;
}
