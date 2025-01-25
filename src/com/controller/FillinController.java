package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Fillin;
import com.service.FillinService;
import com.entity.Course;
import com.entity.Sectionx;
import com.service.CourseService;
import com.service.SectionxService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/fillin", produces = "text/plain;charset=utf-8")
public class FillinController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private FillinService fillinService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private SectionxService sectionxService;

	// 准备添加数据
	@RequestMapping("createFillin.action")
	public String createFillin() {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Course course = new Course();
		course.setTeacherid(adminid);
		List<Course> courseList = this.courseService.getCourseByCond(course);
		this.getRequest().setAttribute("courseList", courseList);
		List<Sectionx> sectionxList = this.sectionxService.getAllSectionx();
		this.getRequest().setAttribute("sectionxList", sectionxList);
		return "admin/addfillin";
	}

	// 添加数据
	@RequestMapping("addFillin.action")
	public String addFillin(Fillin fillin) {
		fillin.setAddtime(VeDate.getStringDateShort());
		this.fillinService.insertFillin(fillin);
		return "redirect:/fillin/createFillin.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteFillin.action")
	public String deleteFillin(String id) {
		this.fillinService.deleteFillin(id);
		return "redirect:/fillin/getAllFillin.action";
	}

	// 批量删除数据
	@RequestMapping("deleteFillinByIds.action")
	public String deleteFillinByIds() {
		String[] ids = this.getRequest().getParameterValues("fillinid");
		if (ids != null) {
			for (String fillinid : ids) {
				this.fillinService.deleteFillin(fillinid);
			}
		}
		return "redirect:/fillin/getAllFillin.action";
	}

	// 更新数据
	@RequestMapping("updateFillin.action")
	public String updateFillin(Fillin fillin) {
		this.fillinService.updateFillin(fillin);
		return "redirect:/fillin/getMyFillin.action";
	}

	// 显示全部数据
	@RequestMapping("getAllFillin.action")
	public String getAllFillin(String number) {
		List<Fillin> fillinList = this.fillinService.getAllFillin();
		PageHelper.getUserPage(fillinList, "fillin", "getAllFillin", 10, number, this.getRequest());
		return "admin/listfillin";
	}

	@RequestMapping("getMyFillin.action")
	public String getMyFillin(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Fillin fillin = new Fillin();
		fillin.setTeacherid(adminid);
		List<Fillin> fillinList = this.fillinService.getFillinByCond(fillin);
		PageHelper.getUserPage(fillinList, "fillin", "getMyFillin", 10, number, this.getRequest());
		return "admin/xlistfillin";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryFillinByCond.action")
	public String queryFillinByCond(String cond, String name, String number) {
		Fillin fillin = new Fillin();
		if (cond != null) {
			if ("question".equals(cond)) {
				fillin.setQuestion(name);
			}
			if ("correct".equals(cond)) {
				fillin.setCorrect(name);
			}
			if ("courseid".equals(cond)) {
				fillin.setCourseid(name);
			}
			if ("sectionxid".equals(cond)) {
				fillin.setSectionxid(name);
			}
			if ("parsing".equals(cond)) {
				fillin.setParsing(name);
			}
			if ("addtime".equals(cond)) {
				fillin.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.fillinService.getFillinByLike(fillin), "fillin", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryfillin";
	}

	// 按主键查询数据
	@RequestMapping("getFillinById.action")
	public String getFillinById(String id) {
		Fillin fillin = this.fillinService.getFillinById(id);
		this.getRequest().setAttribute("fillin", fillin);
		List<Course> courseList = this.courseService.getAllCourse();
		this.getRequest().setAttribute("courseList", courseList);
		List<Sectionx> sectionxList = this.sectionxService.getAllSectionx();
		this.getRequest().setAttribute("sectionxList", sectionxList);
		return "admin/editfillin";
	}

}
