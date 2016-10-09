package cn.mldn.em.vo;

import java.io.Serializable;
import java.util.Date;
@SuppressWarnings("serial")
public class Emp implements Serializable {
	private Integer empno;	//
	private String ename;	//雇员姓名
	private String job;		//雇员职位
	private Double sal;		//基本工资
	private Double comm;	//销售佣金
	private Date hiredate;	//
	private String photo;	//员工照片
	private Integer flag;	//
	private String mid;		//通过session取得
	private Integer lid;	//员工等级
	private Integer deptno;	//所在部门
//	private String note;	//员工简介，存在日志表
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public Double getComm() {
		return comm;
	}
	public void setComm(Double comm) {
		this.comm = comm;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", sal=" + sal + ", comm=" + comm
				+ ", hiredate=" + hiredate + ", photo=" + photo + ", flag=" + flag + ", mid=" + mid + ", lid=" + lid
				+ ", deptno=" + deptno  + "]";
	}
	
	
}
