package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.Clazz;
import com.entity.Course;
import com.entity.Sectionx;
import com.entity.Users;
import com.service.ClazzService;
import com.service.CourseService;
import com.service.SectionxService;
import com.service.UsersService;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/ajax", produces = "text/plain;charset=utf-8")
public class AjaxController extends BaseController {
	@Autowired
	private ClazzService clazzService;
	@Autowired
	private SectionxService sectionxService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private UsersService usersService;

	@RequestMapping("getSectionx.action")
	@ResponseBody
	public String getSectionx(String id) {
		Sectionx x = new Sectionx();
		x.setCourseid(id);
		List<Sectionx> sectionxList = this.sectionxService.getSectionxByCond(x);
		JSONArray sectionxid = new JSONArray();
		JSONArray sectionxname = new JSONArray();
		for (Sectionx sectionx : sectionxList) {
			sectionxid.add(sectionx.getSectionxid());
			sectionxname.add(sectionx.getSectionxname());
		}
		JSONObject json = new JSONObject();
		json.put("sectionxid", sectionxid.toString().replaceAll("\"", ""));
		json.put("sectionxname", sectionxname.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();
	}

	@RequestMapping("getClazz.action")
	@ResponseBody
	public String getClazz(String id) {
		Clazz x = new Clazz();
		x.setDeptid(id);
		List<Clazz> clazzList = this.clazzService.getClazzByCond(x);
		JSONArray clazzid = new JSONArray();
		JSONArray clazzname = new JSONArray();
		for (Clazz clazz : clazzList) {
			clazzid.add(clazz.getClazzid());
			clazzname.add(clazz.getClazzname());
		}
		JSONObject json = new JSONObject();
		json.put("clazzid", clazzid.toString().replaceAll("\"", ""));
		json.put("clazzname", clazzname.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();
	}

	@RequestMapping("getUsers.action")
	@ResponseBody
	public String getUsers(String id) {
		Course course = this.courseService.getCourseById(id);
		Users x = new Users();
		x.setClazzid(course.getClazzid());
		List<Users> usersList = this.usersService.getUsersByCond(x);
		JSONArray usersid = new JSONArray();
		JSONArray username = new JSONArray();
		for (Users users : usersList) {
			usersid.add(users.getUsersid());
			username.add(users.getRealname());
		}
		JSONObject json = new JSONObject();
		json.put("usersid", usersid.toString().replaceAll("\"", ""));
		json.put("username", username.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();
	}
}
