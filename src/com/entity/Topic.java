package com.entity;

import com.util.VeDate;

public class Topic {
	private String topicid = "T" + VeDate.getStringId();// 生成主键编号
	private String usersid;// 学生
	private String vedioid;// 视频
	private String contents;// 内容
	private String addtime;// 日期
	private String status;// 状态
	private String reps;// 回复
	private String username;// 映射数据
	private String vedioname;// 映射数据
	private String teacherid;

	public String getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}

	public String getTopicid() {
		return topicid;
	}

	public void setTopicid(String topicid) {
		this.topicid = topicid;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getVedioid() {
		return this.vedioid;
	}

	public void setVedioid(String vedioid) {
		this.vedioid = vedioid;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReps() {
		return this.reps;
	}

	public void setReps(String reps) {
		this.reps = reps;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVedioname() {
		return this.vedioname;
	}

	public void setVedioname(String vedioname) {
		this.vedioname = vedioname;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Topic [topicid=" + this.topicid + ", usersid=" + this.usersid + ", vedioid=" + this.vedioid
				+ ", contents=" + this.contents + ", addtime=" + this.addtime + ", status=" + this.status + ", reps="
				+ this.reps + ", username=" + this.username + ", vedioname=" + this.vedioname + "]";
	}

}
