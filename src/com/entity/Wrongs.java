package com.entity;

import com.util.VeDate;

public class Wrongs {
	private String wrongsid = "W" + VeDate.getStringId();// 生成主键编号
	private String usersid;// 学生
	private String courseid;// 课程
	private String sectionxid;// 章节
	private String quections;// 问题
	private String parsing;// 解析
	private String addtime;// 日期
	private String realname;// 映射数据
	private String coursename;// 映射数据
	private String sectionxname;// 映射数据

	public String getWrongsid() {
		return wrongsid;
	}

	public void setWrongsid(String wrongsid) {
		this.wrongsid = wrongsid;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getCourseid() {
		return this.courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getSectionxid() {
		return this.sectionxid;
	}

	public void setSectionxid(String sectionxid) {
		this.sectionxid = sectionxid;
	}

	public String getQuections() {
		return this.quections;
	}

	public void setQuections(String quections) {
		this.quections = quections;
	}

	public String getParsing() {
		return this.parsing;
	}

	public void setParsing(String parsing) {
		this.parsing = parsing;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getCoursename() {
		return this.coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getSectionxname() {
		return this.sectionxname;
	}

	public void setSectionxname(String sectionxname) {
		this.sectionxname = sectionxname;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Wrongs [wrongsid=" + this.wrongsid + ", usersid=" + this.usersid + ", courseid=" + this.courseid
				+ ", sectionxid=" + this.sectionxid + ", quections=" + this.quections + ", parsing=" + this.parsing
				+ ", addtime=" + this.addtime + ", realname=" + this.realname + ", coursename=" + this.coursename
				+ ", sectionxname=" + this.sectionxname + "]";
	}

}
