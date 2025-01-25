package com.entity;

import com.util.VeDate;

public class Dept {
	private String deptid = "D" + VeDate.getStringId();// 生成主键编号
	private String deptname;// 院系名称
	private String memo;// 备注

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return this.deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Dept [deptid=" + this.deptid + ", deptname=" + this.deptname + ", memo=" + this.memo + "]";
	}

}
