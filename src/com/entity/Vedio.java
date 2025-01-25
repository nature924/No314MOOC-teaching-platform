package com.entity;

import com.util.VeDate;

public class Vedio {
	private String vedioid = "V" + VeDate.getStringId();// 生成主键编号
	private String vedioname;// 标题
	private String courseid;// 课程
	private String sectionxid;// 章节
	private String image;// 文件
	private String addtime;// 发布日期
	private String hits;// 点击数
	private String coursename;// 映射数据
	private String sectionxname;// 映射数据
	private String teacherid;
	private String clazzid;
	public String getClazzid(){
		return clazzid;
	}
	public void setClazzid(String clazzid){
		this.clazzid = clazzid;
	}

	public String getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}

	public String getVedioid() {
		return vedioid;
	}

	public void setVedioid(String vedioid) {
		this.vedioid = vedioid;
	}

	public String getVedioname() {
		return this.vedioname;
	}

	public void setVedioname(String vedioname) {
		this.vedioname = vedioname;
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

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getHits() {
		return this.hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
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
		return "Vedio [vedioid=" + this.vedioid + ", vedioname=" + this.vedioname + ", courseid=" + this.courseid
				+ ", sectionxid=" + this.sectionxid + ", image=" + this.image + ", addtime=" + this.addtime + ", hits="
				+ this.hits + ", coursename=" + this.coursename + ", sectionxname=" + this.sectionxname + "]";
	}

}
