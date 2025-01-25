package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Vedio;
import com.service.VedioService;
import com.entity.Course;
import com.entity.Sectionx;
import com.service.CourseService;
import com.service.SectionxService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/vedio", produces = "text/plain;charset=utf-8")
public class VedioController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private VedioService vedioService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private SectionxService sectionxService;

	// 准备添加数据
	@RequestMapping("createVedio.action")
	public String createVedio() {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Course course = new Course();
		course.setTeacherid(adminid);
		List<Course> courseList = this.courseService.getCourseByCond(course);
		this.getRequest().setAttribute("courseList", courseList);
		List<Sectionx> sectionxList = this.sectionxService.getAllSectionx();
		this.getRequest().setAttribute("sectionxList", sectionxList);
		return "admin/addvedio";
	}

	// 添加数据
	@RequestMapping("addVedio.action")
	public String addVedio(Vedio vedio) {
		vedio.setAddtime(VeDate.getStringDateShort());
		vedio.setHits("0");
		this.vedioService.insertVedio(vedio);
		return "redirect:/vedio/createVedio.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteVedio.action")
	public String deleteVedio(String id) {
		this.vedioService.deleteVedio(id);
		return "redirect:/vedio/getAllVedio.action";
	}

	// 批量删除数据
	@RequestMapping("deleteVedioByIds.action")
	public String deleteVedioByIds() {
		String[] ids = this.getRequest().getParameterValues("vedioid");
		if (ids != null) {
			for (String vedioid : ids) {
				this.vedioService.deleteVedio(vedioid);
			}
		}
		return "redirect:/vedio/getAllVedio.action";
	}

	// 更新数据
	@RequestMapping("updateVedio.action")
	public String updateVedio(Vedio vedio) {
		this.vedioService.updateVedio(vedio);
		return "redirect:/vedio/getMyVedio.action";
	}

	// 显示全部数据
	@RequestMapping("getAllVedio.action")
	public String getAllVedio(String number) {
		List<Vedio> vedioList = this.vedioService.getAllVedio();
		PageHelper.getUserPage(vedioList, "vedio", "getAllVedio", 10, number, this.getRequest());
		return "admin/listvedio";
	}

	@RequestMapping("getMyVedio.action")
	public String getMyVedio(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Vedio vedio = new Vedio();
		vedio.setTeacherid(adminid);
		List<Vedio> vedioList = this.vedioService.getVedioByCond(vedio);
		PageHelper.getUserPage(vedioList, "vedio", "getMyVedio", 10, number, this.getRequest());
		return "admin/xlistvedio";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryVedioByCond.action")
	public String queryVedioByCond(String cond, String name, String number) {
		Vedio vedio = new Vedio();
		if (cond != null) {
			if ("vedioname".equals(cond)) {
				vedio.setVedioname(name);
			}
			if ("courseid".equals(cond)) {
				vedio.setCourseid(name);
			}
			if ("sectionxid".equals(cond)) {
				vedio.setSectionxid(name);
			}
			if ("image".equals(cond)) {
				vedio.setImage(name);
			}
			if ("addtime".equals(cond)) {
				vedio.setAddtime(name);
			}
			if ("hits".equals(cond)) {
				vedio.setHits(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.vedioService.getVedioByLike(vedio), "vedio", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryvedio";
	}

	// 按主键查询数据
	@RequestMapping("getVedioById.action")
	public String getVedioById(String id) {
		Vedio vedio = this.vedioService.getVedioById(id);
		this.getRequest().setAttribute("vedio", vedio);
		List<Course> courseList = this.courseService.getAllCourse();
		this.getRequest().setAttribute("courseList", courseList);
		List<Sectionx> sectionxList = this.sectionxService.getAllSectionx();
		this.getRequest().setAttribute("sectionxList", sectionxList);
		return "admin/editvedio";
	}

	@RequestMapping("play.action")
	public String play(String id) {
		Vedio vedio = this.vedioService.getVedioById(id);
		this.getRequest().setAttribute("vedio", vedio);
		return "admin/play";
	}

}
