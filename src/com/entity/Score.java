package com.entity;

import com.util.VeDate;

public class Score {
	private String scoreid = "S" + VeDate.getStringId();// 生成主键编号
	private String courseid;// 课程
	private String clazzid;// 班级
	private String usersid;// 学生
	private String normalx;// 平时成绩
	private String exam;// 期末成绩
	private String finalx;// 最终成绩
	private String addtime;// 发布日期
	private String memo;// 备注
	private String coursename;// 映射数据
	private String clazzname;// 映射数据
	private String realname;// 映射数据
	private String teacherid;

	public String getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}

	public String getScoreid() {
		return scoreid;
	}

	public void setScoreid(String scoreid) {
		this.scoreid = scoreid;
	}

	public String getCourseid() {
		return this.courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getClazzid() {
		return this.clazzid;
	}

	public void setClazzid(String clazzid) {
		this.clazzid = clazzid;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getNormalx() {
		return this.normalx;
	}

	public void setNormalx(String normalx) {
		this.normalx = normalx;
	}

	public String getExam() {
		return this.exam;
	}

	public void setExam(String exam) {
		this.exam = exam;
	}

	public String getFinalx() {
		return this.finalx;
	}

	public void setFinalx(String finalx) {
		this.finalx = finalx;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
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

	public String getClazzname() {
		return this.clazzname;
	}

	public void setClazzname(String clazzname) {
		this.clazzname = clazzname;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Score [scoreid=" + this.scoreid + ", courseid=" + this.courseid + ", clazzid=" + this.clazzid
				+ ", usersid=" + this.usersid + ", normalx=" + this.normalx + ", exam=" + this.exam + ", finalx="
				+ this.finalx + ", addtime=" + this.addtime + ", memo=" + this.memo + ", coursename=" + this.coursename
				+ ", clazzname=" + this.clazzname + ", realname=" + this.realname + "]";
	}

}
