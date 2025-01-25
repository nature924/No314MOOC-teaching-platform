package com.entity;

import com.util.VeDate;

public class Fillin {
	private String fillinid = "F" + VeDate.getStringId();// 生成主键编号
	private String question;// 题目
	private String correct;// 正确答案
	private String courseid;// 课程
	private String sectionxid;// 章节
	private String parsing;// 解析
	private String addtime;// 创建日期
	private String coursename;// 映射数据
	private String sectionxname;// 映射数据
	private String teacherid;

	public String getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}

	public String getFillinid() {
		return fillinid;
	}

	public void setFillinid(String fillinid) {
		this.fillinid = fillinid;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrect() {
		return this.correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
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
		return "Fillin [fillinid=" + this.fillinid + ", question=" + this.question + ", correct=" + this.correct
				+ ", courseid=" + this.courseid + ", sectionxid=" + this.sectionxid + ", parsing=" + this.parsing
				+ ", addtime=" + this.addtime + ", coursename=" + this.coursename + ", sectionxname="
				+ this.sectionxname + "]";
	}

}
