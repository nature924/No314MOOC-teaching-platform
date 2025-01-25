package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Score;
import com.service.ScoreService;
import com.entity.Course;
import com.entity.Clazz;
import com.entity.Users;
import com.service.CourseService;
import com.service.ClazzService;
import com.service.UsersService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/score", produces = "text/plain;charset=utf-8")
public class ScoreController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private ScoreService scoreService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private ClazzService clazzService;
	@Autowired
	private UsersService usersService;

	// 准备添加数据
	@RequestMapping("createScore.action")
	public String createScore() {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Course course = new Course();
		course.setTeacherid(adminid);
		List<Course> courseList = this.courseService.getCourseByCond(course);
		this.getRequest().setAttribute("courseList", courseList);
		List<Clazz> clazzList = this.clazzService.getAllClazz();
		this.getRequest().setAttribute("clazzList", clazzList);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/addscore";
	}

	// 添加数据
	@RequestMapping("addScore.action")
	public String addScore(Score score) {
		Course course = this.courseService.getCourseById(score.getCourseid());
		score.setClazzid(course.getClazzid());
		double total = VeDate
				.getDouble(Double.parseDouble(score.getExam()) * 0.75 + Double.parseDouble(score.getNormalx()) * 0.25);
		if (total > 60) {
			score.setFinalx("" + total);
		} else {
			score.setFinalx("不及格");
		}
		score.setAddtime(VeDate.getStringDateShort());
		this.scoreService.insertScore(score);
		return "redirect:/score/createScore.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteScore.action")
	public String deleteScore(String id) {
		this.scoreService.deleteScore(id);
		return "redirect:/score/getAllScore.action";
	}

	// 批量删除数据
	@RequestMapping("deleteScoreByIds.action")
	public String deleteScoreByIds() {
		String[] ids = this.getRequest().getParameterValues("scoreid");
		if (ids != null) {
			for (String scoreid : ids) {
				this.scoreService.deleteScore(scoreid);
			}
		}
		return "redirect:/score/getAllScore.action";
	}

	// 更新数据
	@RequestMapping("updateScore.action")
	public String updateScore(Score score) {
		this.scoreService.updateScore(score);
		return "redirect:/score/getAllScore.action";
	}

	// 显示全部数据
	@RequestMapping("getAllScore.action")
	public String getAllScore(String number) {
		List<Score> scoreList = this.scoreService.getAllScore();
		PageHelper.getUserPage(scoreList, "score", "getAllScore", 10, number, this.getRequest());
		return "admin/listscore";
	}

	@RequestMapping("getMyScore.action")
	public String getMyScore(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Score score = new Score();
		score.setTeacherid(adminid);
		List<Score> scoreList = this.scoreService.getScoreByCond(score);
		PageHelper.getUserPage(scoreList, "score", "getMyScore", 10, number, this.getRequest());
		return "admin/xlistscore";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryScoreByCond.action")
	public String queryScoreByCond(String cond, String name, String number) {
		Score score = new Score();
		if (cond != null) {
			if ("courseid".equals(cond)) {
				score.setCourseid(name);
			}
			if ("clazzid".equals(cond)) {
				score.setClazzid(name);
			}
			if ("usersid".equals(cond)) {
				score.setUsersid(name);
			}
			if ("normalx".equals(cond)) {
				score.setNormalx(name);
			}
			if ("exam".equals(cond)) {
				score.setExam(name);
			}
			if ("finalx".equals(cond)) {
				score.setFinalx(name);
			}
			if ("addtime".equals(cond)) {
				score.setAddtime(name);
			}
			if ("memo".equals(cond)) {
				score.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.scoreService.getScoreByLike(score), "score", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryscore";
	}

	// 按主键查询数据
	@RequestMapping("getScoreById.action")
	public String getScoreById(String id) {
		Score score = this.scoreService.getScoreById(id);
		this.getRequest().setAttribute("score", score);
		List<Course> courseList = this.courseService.getAllCourse();
		this.getRequest().setAttribute("courseList", courseList);
		List<Clazz> clazzList = this.clazzService.getAllClazz();
		this.getRequest().setAttribute("clazzList", clazzList);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/editscore";
	}

}
