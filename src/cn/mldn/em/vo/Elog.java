package cn.mldn.em.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Elog implements Serializable {
	private Integer elid ;//日志ID
	private Integer empno ; //雇员ID
	private Integer deptno ; 
	private String mid ;//用户ID
	private Integer lid ;
	private Integer sflag ;
	private Integer flag ;
	private String note;
	public Integer getElid() {
		return elid;
	}
	public void setElid(Integer elid) {
		this.elid = elid;
	}
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
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
	public Integer getSflag() {
		return sflag;
	}
	public void setSflag(Integer sflag) {
		this.sflag = sflag;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	

}
