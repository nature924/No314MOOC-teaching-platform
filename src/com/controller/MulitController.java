package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Mulit;
import com.service.MulitService;
import com.entity.Course;
import com.entity.Sectionx;
import com.service.CourseService;
import com.service.SectionxService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/mulit", produces = "text/plain;charset=utf-8")
public class MulitController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private MulitService mulitService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private SectionxService sectionxService;

	// 准备添加数据
	@RequestMapping("createMulit.action")
	public String createMulit() {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Course course = new Course();
		course.setTeacherid(adminid);
		List<Course> courseList = this.courseService.getCourseByCond(course);
		this.getRequest().setAttribute("courseList", courseList);
		List<Sectionx> sectionxList = this.sectionxService.getAllSectionx();
		this.getRequest().setAttribute("sectionxList", sectionxList);
		return "admin/addmulit";
	}

	// 添加数据
	@RequestMapping("addMulit.action")
	public String addMulit(Mulit mulit) {
		mulit.setAddtime(VeDate.getStringDateShort());
		this.mulitService.insertMulit(mulit);
		return "redirect:/mulit/createMulit.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteMulit.action")
	public String deleteMulit(String id) {
		this.mulitService.deleteMulit(id);
		return "redirect:/mulit/getAllMulit.action";
	}

	// 批量删除数据
	@RequestMapping("deleteMulitByIds.action")
	public String deleteMulitByIds() {
		String[] ids = this.getRequest().getParameterValues("mulitid");
		if (ids != null) {
			for (String mulitid : ids) {
				this.mulitService.deleteMulit(mulitid);
			}
		}
		return "redirect:/mulit/getAllMulit.action";
	}

	// 更新数据
	@RequestMapping("updateMulit.action")
	public String updateMulit(Mulit mulit) {
		this.mulitService.updateMulit(mulit);
		return "redirect:/mulit/getMyMulit.action";
	}

	// 显示全部数据
	@RequestMapping("getAllMulit.action")
	public String getAllMulit(String number) {
		List<Mulit> mulitList = this.mulitService.getAllMulit();
		PageHelper.getUserPage(mulitList, "mulit", "getAllMulit", 10, number, this.getRequest());
		return "admin/listmulit";
	}

	@RequestMapping("getMyMulit.action")
	public String getMyMulit(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Mulit mulit = new Mulit();
		mulit.setTeacherid(adminid);
		List<Mulit> mulitList = this.mulitService.getMulitByCond(mulit);
		PageHelper.getUserPage(mulitList, "mulit", "getMyMulit", 10, number, this.getRequest());
		return "admin/xlistmulit";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryMulitByCond.action")
	public String queryMulitByCond(String cond, String name, String number) {
		Mulit mulit = new Mulit();
		if (cond != null) {
			if ("question".equals(cond)) {
				mulit.setQuestion(name);
			}
			if ("answera".equals(cond)) {
				mulit.setAnswera(name);
			}
			if ("answerb".equals(cond)) {
				mulit.setAnswerb(name);
			}
			if ("answerc".equals(cond)) {
				mulit.setAnswerc(name);
			}
			if ("answerd".equals(cond)) {
				mulit.setAnswerd(name);
			}
			if ("answere".equals(cond)) {
				mulit.setAnswere(name);
			}
			if ("correct".equals(cond)) {
				mulit.setCorrect(name);
			}
			if ("courseid".equals(cond)) {
				mulit.setCourseid(name);
			}
			if ("sectionx".equals(cond)) {
				mulit.setSectionxid(name);
			}
			if ("parsing".equals(cond)) {
				mulit.setParsing(name);
			}
			if ("addtime".equals(cond)) {
				mulit.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.mulitService.getMulitByLike(mulit), "mulit", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querymulit";
	}

	// 按主键查询数据
	@RequestMapping("getMulitById.action")
	public String getMulitById(String id) {
		Mulit mulit = this.mulitService.getMulitById(id);
		this.getRequest().setAttribute("mulit", mulit);
		List<Course> courseList = this.courseService.getAllCourse();
		this.getRequest().setAttribute("courseList", courseList);
		List<Sectionx> sectionxList = this.sectionxService.getAllSectionx();
		this.getRequest().setAttribute("sectionxList", sectionxList);
		return "admin/editmulit";
	}

}
