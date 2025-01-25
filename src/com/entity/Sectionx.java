package com.entity;

import com.util.VeDate;

public class Sectionx {
	private String sectionxid = "S" + VeDate.getStringId();// 生成主键编号
	private String sectionxname;// 章节名
	private String courseid;// 课程
	private String memo;// 备注
	private String coursename;// 映射数据
	private String teacherid;

	public String getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}

	public String getSectionxid() {
		return sectionxid;
	}

	public void setSectionxid(String sectionxid) {
		this.sectionxid = sectionxid;
	}

	public String getSectionxname() {
		return this.sectionxname;
	}

	public void setSectionxname(String sectionxname) {
		this.sectionxname = sectionxname;
	}

	public String getCourseid() {
		return this.courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getCoursename() {
		return this.coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Sectionx [sectionxid=" + this.sectionxid + ", sectionxname=" + this.sectionxname + ", courseid="
				+ this.courseid + ", memo=" + this.memo + ", coursename=" + this.coursename + "]";
	}

}
