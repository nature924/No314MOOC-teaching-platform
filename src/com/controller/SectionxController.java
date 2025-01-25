package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Sectionx;
import com.service.SectionxService;
import com.entity.Course;
import com.service.CourseService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/sectionx", produces = "text/plain;charset=utf-8")
public class SectionxController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private SectionxService sectionxService;
	@Autowired
	private CourseService courseService;

	// 准备添加数据
	@RequestMapping("createSectionx.action")
	public String createSectionx() {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Course course = new Course();
		course.setTeacherid(adminid);
		List<Course> courseList = this.courseService.getCourseByCond(course);
		this.getRequest().setAttribute("courseList", courseList);
		return "admin/addsectionx";
	}

	// 添加数据
	@RequestMapping("addSectionx.action")
	public String addSectionx(Sectionx sectionx) {
		this.sectionxService.insertSectionx(sectionx);
		return "redirect:/sectionx/createSectionx.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteSectionx.action")
	public String deleteSectionx(String id) {
		this.sectionxService.deleteSectionx(id);
		return "redirect:/sectionx/getAllSectionx.action";
	}

	// 批量删除数据
	@RequestMapping("deleteSectionxByIds.action")
	public String deleteSectionxByIds() {
		String[] ids = this.getRequest().getParameterValues("sectionxid");
		if (ids != null) {
			for (String sectionxid : ids) {
				this.sectionxService.deleteSectionx(sectionxid);
			}
		}
		return "redirect:/sectionx/getAllSectionx.action";
	}

	// 更新数据
	@RequestMapping("updateSectionx.action")
	public String updateSectionx(Sectionx sectionx) {
		this.sectionxService.updateSectionx(sectionx);
		return "redirect:/sectionx/getMySectionx.action";
	}

	// 显示全部数据
	@RequestMapping("getAllSectionx.action")
	public String getAllSectionx(String number) {
		List<Sectionx> sectionxList = this.sectionxService.getAllSectionx();
		PageHelper.getUserPage(sectionxList, "sectionx", "getAllSectionx", 10, number, this.getRequest());
		return "admin/listsectionx";
	}

	@RequestMapping("getMySectionx.action")
	public String getMySectionx(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Sectionx sectionx = new Sectionx();
		sectionx.setTeacherid(adminid);
		List<Sectionx> sectionxList = this.sectionxService.getSectionxByCond(sectionx);
		PageHelper.getUserPage(sectionxList, "sectionx", "getMySectionx", 10, number, this.getRequest());
		return "admin/xlistsectionx";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("querySectionxByCond.action")
	public String querySectionxByCond(String cond, String name, String number) {
		Sectionx sectionx = new Sectionx();
		if (cond != null) {
			if ("sectionxname".equals(cond)) {
				sectionx.setSectionxname(name);
			}
			if ("courseid".equals(cond)) {
				sectionx.setCourseid(name);
			}
			if ("memo".equals(cond)) {
				sectionx.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.sectionxService.getSectionxByLike(sectionx), "sectionx", nameList, valueList, 10,
				number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querysectionx";
	}

	// 按主键查询数据
	@RequestMapping("getSectionxById.action")
	public String getSectionxById(String id) {
		Sectionx sectionx = this.sectionxService.getSectionxById(id);
		this.getRequest().setAttribute("sectionx", sectionx);
		List<Course> courseList = this.courseService.getAllCourse();
		this.getRequest().setAttribute("courseList", courseList);
		return "admin/editsectionx";
	}

}
