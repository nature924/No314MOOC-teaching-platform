package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Course;
import com.service.CourseService;
import com.entity.Teacher;
import com.entity.Clazz;
import com.service.TeacherService;
import com.service.ClazzService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/course", produces = "text/plain;charset=utf-8")
public class CourseController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private CourseService courseService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private ClazzService clazzService;

	// 准备添加数据
	@RequestMapping("createCourse.action")
	public String createCourse() {
		List<Teacher> teacherList = this.teacherService.getAllTeacher();
		this.getRequest().setAttribute("teacherList", teacherList);
		List<Clazz> clazzList = this.clazzService.getAllClazz();
		this.getRequest().setAttribute("clazzList", clazzList);
		return "admin/addcourse";
	}

	// 添加数据
	@RequestMapping("addCourse.action")
	public String addCourse(Course course) {
		course.setAddtime(VeDate.getStringDateShort());
		this.courseService.insertCourse(course);
		return "redirect:/course/createCourse.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteCourse.action")
	public String deleteCourse(String id) {
		this.courseService.deleteCourse(id);
		return "redirect:/course/getAllCourse.action";
	}

	// 批量删除数据
	@RequestMapping("deleteCourseByIds.action")
	public String deleteCourseByIds() {
		String[] ids = this.getRequest().getParameterValues("courseid");
		if (ids != null) {
			for (String courseid : ids) {
				this.courseService.deleteCourse(courseid);
			}
		}
		return "redirect:/course/getAllCourse.action";
	}

	// 更新数据
	@RequestMapping("updateCourse.action")
	public String updateCourse(Course course) {
		this.courseService.updateCourse(course);
		return "redirect:/course/getAllCourse.action";
	}

	// 显示全部数据
	@RequestMapping("getAllCourse.action")
	public String getAllCourse(String number) {
		List<Course> courseList = this.courseService.getAllCourse();
		PageHelper.getUserPage(courseList, "course", "getAllCourse", 10, number, this.getRequest());
		return "admin/listcourse";
	}

	@RequestMapping("getMyCourse.action")
	public String getMyCourse(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Course course = new Course();
		course.setTeacherid(adminid);
		List<Course> courseList = this.courseService.getCourseByCond(course);
		PageHelper.getUserPage(courseList, "course", "getMyCourse", 10, number, this.getRequest());
		return "admin/xlistcourse";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryCourseByCond.action")
	public String queryCourseByCond(String cond, String name, String number) {
		Course course = new Course();
		if (cond != null) {
			if ("coursename".equals(cond)) {
				course.setCoursename(name);
			}
			if ("teacherid".equals(cond)) {
				course.setTeacherid(name);
			}
			if ("clazzid".equals(cond)) {
				course.setClazzid(name);
			}
			if ("credits".equals(cond)) {
				course.setCredits(name);
			}
			if ("timelong".equals(cond)) {
				course.setTimelong(name);
			}
			if ("addtime".equals(cond)) {
				course.setAddtime(name);
			}
			if ("memo".equals(cond)) {
				course.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.courseService.getCourseByLike(course), "course", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querycourse";
	}

	// 按主键查询数据
	@RequestMapping("getCourseById.action")
	public String getCourseById(String id) {
		Course course = this.courseService.getCourseById(id);
		this.getRequest().setAttribute("course", course);
		List<Teacher> teacherList = this.teacherService.getAllTeacher();
		this.getRequest().setAttribute("teacherList", teacherList);
		List<Clazz> clazzList = this.clazzService.getAllClazz();
		this.getRequest().setAttribute("clazzList", clazzList);
		return "admin/editcourse";
	}

}
