package cn.mldn.zhang.service.back;

import java.util.Map;

import cn.mldn.em.vo.Emp;

public interface IEmpServiceBack {
	/**
	 * 在雇员追加时进行相关信息列出，包括如下内容：<br>
	 * 1、需要列出所有的部门信息，利用IDeptDAO.findAllEmpty()方法；<br>
	 * 2、需要列出所有的工资等级数据，利用ILevelDAO.findAll()方法；<br>
	 * @return 返回的内容包含有如下的结果：<br>
	 * 1、key = allLevels、value = 所有的级别数据；<br>
	 * 2、key = allDepts、value = 所有的部门数据；<br>
	 * @throws Exception
	 */
	public Map<String,Object> addPre(String mid) throws Exception ;
	/**
	 * 实现雇员数据的追加控制操作，本操作要进行如下的调用：<br>
	 * 1、判断当前用户是否具备有相应的权限信息；
	 * 2、要判断当前的部门是否有空余的名额；<br>
	 * 3、要判断当前的工资是否在指定的级别范围之内；<br>
	 * 4、要进行雇员信息的保存；<br>
	 * 5、保存成功之后要进行部门人数加1修改；<br>
	 * 6、要进行相关日志的保存处理；<br>
	 * @param vo 包含有雇员数据以及追加的用户的mid数据
	 * @return 增加成功返回true，否则返回false
	 * @throws Exception
	 */
	public boolean add(Emp vo) throws Exception ; 
	
}
