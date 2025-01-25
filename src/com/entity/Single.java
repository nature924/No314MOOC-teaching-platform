package com.entity;

import com.util.VeDate;

public class Single {
	private String singleid = "S" + VeDate.getStringId();// 生成主键编号
	private String question;// 问题
	private String answera;// 答案A
	private String answerb;// 答案B
	private String answerc;// 答案C
	private String answerd;// 答案D
	private String correct;// 正确答案
	private String courseid;// 课程
	private String sectionxid;// 章节
	private String parsing;// 题目解析
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

	public String getSingleid() {
		return singleid;
	}

	public void setSingleid(String singleid) {
		this.singleid = singleid;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswera() {
		return this.answera;
	}

	public void setAnswera(String answera) {
		this.answera = answera;
	}

	public String getAnswerb() {
		return this.answerb;
	}

	public void setAnswerb(String answerb) {
		this.answerb = answerb;
	}

	public String getAnswerc() {
		return this.answerc;
	}

	public void setAnswerc(String answerc) {
		this.answerc = answerc;
	}

	public String getAnswerd() {
		return this.answerd;
	}

	public void setAnswerd(String answerd) {
		this.answerd = answerd;
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
		return "Single [singleid=" + this.singleid + ", question=" + this.question + ", answera=" + this.answera
				+ ", answerb=" + this.answerb + ", answerc=" + this.answerc + ", answerd=" + this.answerd + ", correct="
				+ this.correct + ", courseid=" + this.courseid + ", sectionxid=" + this.sectionxid + ", parsing="
				+ this.parsing + ", addtime=" + this.addtime + ", coursename=" + this.coursename + ", sectionxname="
				+ this.sectionxname + "]";
	}

}
