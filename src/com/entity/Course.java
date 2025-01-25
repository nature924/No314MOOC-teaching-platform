package com.entity;

import com.util.VeDate;

public class Course {
	private String courseid = "C" + VeDate.getStringId();// 生成主键编号
	private String coursename;// 课程名称
	private String teacherid;// 教师
	private String clazzid;// 班级
	private String credits;// 学分
	private String timelong;// 学时
	private String addtime;// 创建日期
	private String memo;// 备注
	private String teachername;// 映射数据
	private String clazzname;// 映射数据

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return this.coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getTeacherid() {
		return this.teacherid;
	}

	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}

	public String getClazzid() {
		return this.clazzid;
	}

	public void setClazzid(String clazzid) {
		this.clazzid = clazzid;
	}

	public String getCredits() {
		return this.credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}

	public String getTimelong() {
		return this.timelong;
	}

	public void setTimelong(String timelong) {
		this.timelong = timelong;
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

	public String getTeachername() {
		return this.teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getClazzname() {
		return this.clazzname;
	}

	public void setClazzname(String clazzname) {
		this.clazzname = clazzname;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Course [courseid=" + this.courseid + ", coursename=" + this.coursename + ", teacherid=" + this.teacherid
				+ ", clazzid=" + this.clazzid + ", credits=" + this.credits + ", timelong=" + this.timelong
				+ ", addtime=" + this.addtime + ", memo=" + this.memo + ", teachername=" + this.teachername
				+ ", clazzname=" + this.clazzname + "]";
	}

}
