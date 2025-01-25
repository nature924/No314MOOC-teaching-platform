package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Wrongs;
import com.service.WrongsService;
import com.entity.Users;
import com.entity.Course;
import com.entity.Sectionx;
import com.service.UsersService;
import com.service.CourseService;
import com.service.SectionxService;
import com.util.PageHelper;
import com.util.VeDate;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/wrongs" , produces = "text/plain;charset=utf-8")
public class WrongsController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private WrongsService wrongsService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private SectionxService sectionxService;

	// 准备添加数据
	@RequestMapping("createWrongs.action")
	public String createWrongs() {
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Course> courseList = this.courseService.getAllCourse();
		this.getRequest().setAttribute("courseList", courseList);
		List<Sectionx> sectionxList = this.sectionxService.getAllSectionx();
		this.getRequest().setAttribute("sectionxList", sectionxList);
		return "admin/addwrongs";
	}
	// 添加数据
	@RequestMapping("addWrongs.action")
	public String addWrongs(Wrongs wrongs) {
		wrongs.setAddtime(VeDate.getStringDateShort());
		this.wrongsService.insertWrongs(wrongs);
		return "redirect:/wrongs/createWrongs.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteWrongs.action")
	public String deleteWrongs(String id) {
		this.wrongsService.deleteWrongs(id);
		return "redirect:/wrongs/getAllWrongs.action";
	}

	// 批量删除数据
	@RequestMapping("deleteWrongsByIds.action")
	public String deleteWrongsByIds() {
		String[] ids = this.getRequest().getParameterValues("wrongsid");
		if (ids != null) {
			for (String wrongsid : ids) {
				this.wrongsService.deleteWrongs(wrongsid);
			}
		}
		return "redirect:/wrongs/getAllWrongs.action";
	}

	// 更新数据
	@RequestMapping("updateWrongs.action")
	public String updateWrongs(Wrongs wrongs) {
		this.wrongsService.updateWrongs(wrongs);
		return "redirect:/wrongs/getAllWrongs.action";
	}

	// 显示全部数据
	@RequestMapping("getAllWrongs.action")
	public String getAllWrongs(String number) {
		List<Wrongs> wrongsList = this.wrongsService.getAllWrongs();
		PageHelper.getUserPage(wrongsList, "wrongs", "getAllWrongs", 10, number, this.getRequest());
		return "admin/listwrongs";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryWrongsByCond.action")
	public String queryWrongsByCond(String cond, String name, String number) {
		Wrongs wrongs = new Wrongs();
		if(cond != null){
			if ("usersid".equals(cond)) {
				wrongs.setUsersid(name);
			}
			if ("courseid".equals(cond)) {
				wrongs.setCourseid(name);
			}
			if ("sectionxid".equals(cond)) {
				wrongs.setSectionxid(name);
			}
			if ("quections".equals(cond)) {
				wrongs.setQuections(name);
			}
			if ("parsing".equals(cond)) {
				wrongs.setParsing(name);
			}
			if ("addtime".equals(cond)) {
				wrongs.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.wrongsService.getWrongsByLike(wrongs), "wrongs", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querywrongs";
	}

	// 按主键查询数据
	@RequestMapping("getWrongsById.action")
	public String getWrongsById(String id) {
		Wrongs wrongs = this.wrongsService.getWrongsById(id);
		this.getRequest().setAttribute("wrongs", wrongs);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Course> courseList = this.courseService.getAllCourse();
		this.getRequest().setAttribute("courseList", courseList);
		List<Sectionx> sectionxList = this.sectionxService.getAllSectionx();
		this.getRequest().setAttribute("sectionxList", sectionxList);
		return "admin/editwrongs";
	}


}
