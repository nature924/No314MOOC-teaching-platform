package com.entity;

import com.util.VeDate;

public class Clazz {
	private String clazzid = "C" + VeDate.getStringId();// 生成主键编号
	private String clazzname;// 班级名称
	private String manager;// 负责人
	private String addtime;// 创建日期
	private String deptid;// 院系
	private String memo;// 备注
	private String deptname;// 映射数据

	public String getClazzid() {
		return clazzid;
	}

	public void setClazzid(String clazzid) {
		this.clazzid = clazzid;
	}

	public String getClazzname() {
		return this.clazzname;
	}

	public void setClazzname(String clazzname) {
		this.clazzname = clazzname;
	}

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getDeptid() {
		return this.deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDeptname() {
		return this.deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Clazz [clazzid=" + this.clazzid + ", clazzname=" + this.clazzname + ", manager=" + this.manager
				+ ", addtime=" + this.addtime + ", deptid=" + this.deptid + ", memo=" + this.memo + ", deptname="
				+ this.deptname + "]";
	}

}
