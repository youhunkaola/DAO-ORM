package cn.mldn.em.servlet.back;

import java.util.Map;

import javax.servlet.annotation.WebServlet;

import cn.mldn.em.vo.Emp;
import cn.mldn.util.factory.ServiceFactory;
import cn.mldn.zhang.service.back.IEmpServiceBack;
import cn.zhang.em.service.back.impl.EmpServiceBackImpl;
import cn.zhang.em.servlet.abs.EMServlet;

@SuppressWarnings("serial")
@WebServlet("/pages/back/emp/EmpServletBack/*")
public class EmpServletBack extends EMServlet {
	private Emp emp = new Emp();
	public Emp getEmp(){
		return emp;
	}
	
	public String addPre(){
		if(super.auth("emp:add")){// 判断当前用户是否具备有指定的权限
			IEmpServiceBack empService = ServiceFactory.getInstance(EmpServiceBackImpl.class);
			try {
				Map<String,Object> map = empService.addPre(super.getMid());
				super.request.setAttribute("allDepts", map.get("allDepts"));
				super.request.setAttribute("allLevels", map.get("allLevels"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "emp.add.page";
		}else{
			super.addError("auth","auth.failure.page");
			return "error.page"; // 回到错误页上
		}
	}
	
	
	public String add(){
		if(super.auth("emp:add")){ // 判断当前用户是否具备有指定的权限
			if(super.isUploadFile()){// 现在有文件上传
				this.emp.setPhoto(super.createSingleFileName()); // 创建文件名称
			}else{
				this.emp.setPhoto("nophoto.png");
			}
			this.emp.setMid(super.getMid()); 	// 保存当前操作的用户编号
			IEmpServiceBack empService = ServiceFactory.getInstance(EmpServiceBackImpl.class);
			try {
				if (empService.add(this.emp)) { // 实现雇员数据的追加操作
					super.setUrlAndMsg("emp.add.servlet", "vo.add.success.msg");
					if (super.isUploadFile()) {
						super.saveUploadFile(this.emp.getPhoto()) ;	// 保存图片
						super.saveScale(this.emp.getPhoto());	// 保存缩略图
					}
				}else {
					super.setUrlAndMsg("emp.add.servlet", "vo.add.success.msg");
				}
			} catch (Exception e) {
				super.setUrlAndMsg("emp.add.servlet", "vo.add.failure.msg");
				e.printStackTrace();
			}
			return "forward.page";
		}else{
			super.addError("auth", "auth.failure.msg");
			return "error.page"; // 回到错误页上
		}
	}
	
	@Override
	public String getUploadDir() {
		return "/upload/emp/";
	}
	@Override
	public String getType() {
		return "雇员";
	}
	
}
