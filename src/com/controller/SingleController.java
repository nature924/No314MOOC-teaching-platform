package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Single;
import com.service.SingleService;
import com.entity.Course;
import com.entity.Sectionx;
import com.service.CourseService;
import com.service.SectionxService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/single", produces = "text/plain;charset=utf-8")
public class SingleController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private SingleService singleService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private SectionxService sectionxService;

	// 准备添加数据
	@RequestMapping("createSingle.action")
	public String createSingle() {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Course course = new Course();
		course.setTeacherid(adminid);
		List<Course> courseList = this.courseService.getCourseByCond(course);
		this.getRequest().setAttribute("courseList", courseList);
		List<Sectionx> sectionxList = this.sectionxService.getAllSectionx();
		this.getRequest().setAttribute("sectionxList", sectionxList);
		return "admin/addsingle";
	}

	// 添加数据
	@RequestMapping("addSingle.action")
	public String addSingle(Single single) {
		single.setAddtime(VeDate.getStringDateShort());
		this.singleService.insertSingle(single);
		return "redirect:/single/createSingle.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteSingle.action")
	public String deleteSingle(String id) {
		this.singleService.deleteSingle(id);
		return "redirect:/single/getAllSingle.action";
	}

	// 批量删除数据
	@RequestMapping("deleteSingleByIds.action")
	public String deleteSingleByIds() {
		String[] ids = this.getRequest().getParameterValues("singleid");
		if (ids != null) {
			for (String singleid : ids) {
				this.singleService.deleteSingle(singleid);
			}
		}
		return "redirect:/single/getAllSingle.action";
	}

	// 更新数据
	@RequestMapping("updateSingle.action")
	public String updateSingle(Single single) {
		this.singleService.updateSingle(single);
		return "redirect:/single/getMySingle.action";
	}

	// 显示全部数据
	@RequestMapping("getAllSingle.action")
	public String getAllSingle(String number) {
		List<Single> singleList = this.singleService.getAllSingle();
		PageHelper.getUserPage(singleList, "single", "getAllSingle", 10, number, this.getRequest());
		return "admin/listsingle";
	}

	@RequestMapping("getMySingle.action")
	public String getMySingle(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Single single = new Single();
		single.setTeacherid(adminid);
		List<Single> singleList = this.singleService.getSingleByCond(single);
		PageHelper.getUserPage(singleList, "single", "getMySingle", 10, number, this.getRequest());
		return "admin/xlistsingle";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("querySingleByCond.action")
	public String querySingleByCond(String cond, String name, String number) {
		Single single = new Single();
		if (cond != null) {
			if ("question".equals(cond)) {
				single.setQuestion(name);
			}
			if ("answera".equals(cond)) {
				single.setAnswera(name);
			}
			if ("answerb".equals(cond)) {
				single.setAnswerb(name);
			}
			if ("answerc".equals(cond)) {
				single.setAnswerc(name);
			}
			if ("answerd".equals(cond)) {
				single.setAnswerd(name);
			}
			if ("correct".equals(cond)) {
				single.setCorrect(name);
			}
			if ("courseid".equals(cond)) {
				single.setCourseid(name);
			}
			if ("sectionxid".equals(cond)) {
				single.setSectionxid(name);
			}
			if ("parsing".equals(cond)) {
				single.setParsing(name);
			}
			if ("addtime".equals(cond)) {
				single.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.singleService.getSingleByLike(single), "single", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querysingle";
	}

	// 按主键查询数据
	@RequestMapping("getSingleById.action")
	public String getSingleById(String id) {
		Single single = this.singleService.getSingleById(id);
		this.getRequest().setAttribute("single", single);
		List<Course> courseList = this.courseService.getAllCourse();
		this.getRequest().setAttribute("courseList", courseList);
		List<Sectionx> sectionxList = this.sectionxService.getAllSectionx();
		this.getRequest().setAttribute("sectionxList", sectionxList);
		return "admin/editsingle";
	}

}
