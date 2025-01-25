package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Article;
import com.entity.Banner;
import com.entity.Bbs;
import com.entity.Course;
import com.entity.Dept;
import com.entity.Fillin;
import com.entity.Mulit;
import com.entity.Rebbs;
import com.entity.Score;
import com.entity.Single;
import com.entity.Teacher;
import com.entity.Topic;
import com.entity.Users;
import com.entity.Vedio;
import com.entity.Wrongs;
import com.service.ArticleService;
import com.service.BannerService;
import com.service.BbsService;
import com.service.CourseService;
import com.service.DeptService;
import com.service.FillinService;
import com.service.MulitService;
import com.service.RebbsService;
import com.service.ScoreService;
import com.service.SingleService;
import com.service.TeacherService;
import com.service.TopicService;
import com.service.UsersService;
import com.service.VedioService;
import com.service.WrongsService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/index")
public class IndexController extends BaseController {

	@Autowired
	private TeacherService teacherService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private BannerService bannerService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private SingleService singleService;
	@Autowired
	private MulitService mulitService;
	@Autowired
	private FillinService fillinService;
	@Autowired
	private WrongsService wrongsService;
	@Autowired
	private ScoreService scoreService;
	@Autowired
	private VedioService vedioService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private BbsService bbsService;
	@Autowired
	private RebbsService rebbsService;

	// TODO Auto-generated method stub
	// 公共方法 提供公共查询数据
	private void front() {
		this.getRequest().setAttribute("title", "MOOC教学平台");
		List<Banner> bannerList = this.bannerService.getAllBanner();
		this.getRequest().setAttribute("bannerList", bannerList);
	}

	// 首页显示
	@RequestMapping("index.action")
	public String index() {
		this.front();
		List<Banner> bannerList = this.bannerService.getAllBanner();
		List<Banner> frontList = new ArrayList<Banner>();
		for (Banner banner : bannerList) {
			List<Article> articleList = this.articleService.getArticleByBanner(banner.getBannerid());
			banner.setArticleList(articleList);
			frontList.add(banner);
		}
		this.getRequest().setAttribute("frontList", frontList);
		List<Article> topList = this.articleService.getTopArticle();
		List<Article> favList = this.articleService.getFlvArticle();
		this.getRequest().setAttribute("topList", topList);
		this.getRequest().setAttribute("favList", favList);
		return "users/index";
	}

	// 新闻公告
	@RequestMapping("article.action")
	public String article(String id, String number) {
		this.front();
		Article article = new Article();
		article.setBannerid(id);
		List<Article> articleList = this.articleService.getArticleByCond(article);
		PageHelper.getIndexPage(articleList, "article", "article", id, 10, number, this.getRequest());
		Banner banner = this.bannerService.getBannerById(id);
		this.getRequest().setAttribute("banner", banner);
		return "users/article";
	}

	// 阅读公告
	@RequestMapping("read.action")
	public String read(String id) {
		this.front();
		Article article = this.articleService.getArticleById(id);
		article.setHits("" + (Integer.parseInt(article.getHits()) + 1));
		this.articleService.updateArticle(article);
		this.getRequest().setAttribute("article", article);
		return "users/read";
	}

	// 准备登录
	@RequestMapping("preLogin.action")
	public String prelogin() {
		this.front();
		return "users/login";
	}

	// 用户登录
	@RequestMapping("login.action")
	public String login() {
		this.front();
		String username = this.getRequest().getParameter("username");
		String password = this.getRequest().getParameter("password");
		Users u = new Users();
		u.setUsername(username);
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			this.getSession().setAttribute("message", "用户名不存在");
			return "redirect:/index/preLogin.action";
		} else {
			Users users = usersList.get(0);
			if ("锁定".equals(users.getStatus())) {
				this.getSession().setAttribute("message", "账户被锁定");
				return "redirect:/index/preLogin.action";
			}
			if (password.equals(users.getPassword())) {
				this.getSession().setAttribute("userid", users.getUsersid());
				this.getSession().setAttribute("username", users.getUsername());
				this.getSession().setAttribute("users", users);
				this.getSession().setAttribute("clazzid", users.getClazzid());
				return "redirect:/index/index.action";
			} else {
				this.getSession().setAttribute("message", "密码错误");
				return "redirect:/index/preLogin.action";
			}
		}
	}

	// 准备注册
	@RequestMapping("preReg.action")
	public String preReg() {
		this.front();
		List<Dept> deptList = this.deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		return "users/register";
	}

	// 用户注册
	@RequestMapping("register.action")
	public String register(Users users) {
		this.front();
		Users u = new Users();
		u.setUsername(users.getUsername());
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			users.setStatus("锁定");
			users.setRegdate(VeDate.getStringDateShort());
			this.usersService.insertUsers(users);
		} else {
			this.getSession().setAttribute("message", "用户名已存在");
			return "redirect:/index/preReg.action";
		}

		return "redirect:/index/preLogin.action";
	}

	// 退出登录
	@RequestMapping("exit.action")
	public String exit() {
		this.front();
		this.getSession().removeAttribute("userid");
		this.getSession().removeAttribute("username");
		this.getSession().removeAttribute("users");
		return "redirect:/index/index.action";
	}

	// 准备修改密码
	@RequestMapping("prePwd.action")
	public String prePwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/editpwd";
	}

	// 修改密码
	@RequestMapping("editpwd.action")
	public String editpwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		String password = this.getRequest().getParameter("password");
		String repassword = this.getRequest().getParameter("repassword");
		Users users = this.usersService.getUsersById(userid);
		if (password.equals(users.getPassword())) {
			users.setPassword(repassword);
			this.usersService.updateUsers(users);
		} else {
			this.getSession().setAttribute("message", "旧密码错误");
			return "redirect:/index/prePwd.action";
		}
		this.getSession().setAttribute("message", "修改成功");
		return "redirect:/index/prePwd.action";
	}

	@RequestMapping("usercenter.action")
	public String usercenter() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/usercenter";
	}

	@RequestMapping("userinfo.action")
	public String userinfo() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		this.getSession().setAttribute("users", this.usersService.getUsersById(userid));
		return "users/userinfo";
	}

	@RequestMapping("personal.action")
	public String personal(Users users) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.usersService.updateUsers(users);
		this.getSession().setAttribute("message", "修改成功");
		return "redirect:/index/userinfo.action";
	}

	// 留言板
	@RequestMapping("bbs.action")
	public String bbs() {
		this.front();
		List<Bbs> bbsList = this.bbsService.getAllBbs();
		this.getRequest().setAttribute("bbsList", bbsList);
		return "users/bbs";
	}

	// 发布留言
	@RequestMapping("addbbs.action")
	public String addbbs() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Bbs bbs = new Bbs();
		bbs.setAddtime(VeDate.getStringDate());
		bbs.setContents(getRequest().getParameter("contents"));
		bbs.setHits("0");
		bbs.setRepnum("0");
		bbs.setTitle(getRequest().getParameter("title"));
		bbs.setUsersid(userid);
		this.bbsService.insertBbs(bbs);
		return "redirect:/index/bbs.action";
	}

	// 查看留言
	@RequestMapping("readbbs.action")
	public String readbbs() {
		this.front();
		Bbs bbs = this.bbsService.getBbsById(getRequest().getParameter("id"));
		bbs.setHits("" + (Integer.parseInt(bbs.getHits()) + 1));
		this.bbsService.updateBbs(bbs);
		this.getRequest().setAttribute("bbs", bbs);
		Rebbs rebbs = new Rebbs();
		rebbs.setBbsid(bbs.getBbsid());
		List<Rebbs> rebbsList = this.rebbsService.getRebbsByCond(rebbs);
		this.getRequest().setAttribute("rebbsList", rebbsList);
		return "users/readbbs";
	}

	// 回复留言
	@RequestMapping("rebbs.action")
	public String rebbs() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Rebbs rebbs = new Rebbs();
		rebbs.setAddtime(VeDate.getStringDate());
		rebbs.setContents(getRequest().getParameter("contents"));
		rebbs.setBbsid(getRequest().getParameter("bbsid"));
		rebbs.setUsersid(userid);
		this.rebbsService.insertRebbs(rebbs);
		Bbs bbs = this.bbsService.getBbsById(rebbs.getBbsid());
		bbs.setRepnum("" + (Integer.parseInt(bbs.getRepnum()) + 1));
		this.bbsService.updateBbs(bbs);
		String path = "redirect:/index/readbbs.action?id=" + bbs.getBbsid();
		return path;
	}

	@RequestMapping("teacher.action")
	public String teacher(String number) {
		this.front();
		List<Teacher> teacherList = this.teacherService.getAllTeacher();
		PageHelper.getIndexPage(teacherList, "teacher", "teacher", null, 12, number, this.getRequest());
		return "users/teacher";
	}

	@RequestMapping("teacherDetail.action")
	public String teacherDetail(String id) {
		this.front();
		Teacher teacher = this.teacherService.getTeacherById(id);
		this.getRequest().setAttribute("teacher", teacher);
		return "users/teacherDetail";
	}

	@RequestMapping("myCourse.action")
	public String myCourse(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String clazzid = (String) this.getSession().getAttribute("clazzid");
		Course course = new Course();
		course.setClazzid(clazzid);
		List<Course> courseList = this.courseService.getCourseByCond(course);
		PageHelper.getIndexPage(courseList, "course", "myCourse", null, 10, number, this.getRequest());
		return "users/myCourse";
	}

	@RequestMapping("myScore.action")
	public String myScore(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Score score = new Score();
		score.setUsersid(userid);
		List<Score> scoreList = this.scoreService.getScoreByCond(score);
		PageHelper.getIndexPage(scoreList, "score", "myScore", null, 10, number, this.getRequest());
		return "users/myScore";
	}

	@RequestMapping("myWrongs.action")
	public String myWrongs(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Wrongs wrongs = new Wrongs();
		wrongs.setUsersid(userid);
		List<Wrongs> wrongsList = this.wrongsService.getWrongsByCond(wrongs);
		PageHelper.getIndexPage(wrongsList, "wrongs", "myWrongs", null, 10, number, this.getRequest());
		return "users/myWrongs";
	}

	@RequestMapping("deleteWrongs.action")
	public String deleteWrongs(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.wrongsService.deleteWrongs(id);
		return "redirect:/index/myWrongs.action";
	}

	@RequestMapping("vedio.action")
	public String vedio(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String clazzid = (String)this.getSession().getAttribute("clazzid");
		Vedio vedio = new Vedio();
		vedio.setClazzid(clazzid);
		List<Vedio> vedioList = this.vedioService.getVedioByCond(vedio);
		PageHelper.getIndexPage(vedioList, "vedio", "vedio", null, 12, number, this.getRequest());
		return "users/vedio";
	}

	@RequestMapping("vedioDetail.action")
	public String vedioDetail(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Vedio vedio = this.vedioService.getVedioById(id);
		vedio.setHits("" + (Integer.parseInt(vedio.getHits()) + 1));
		this.vedioService.updateVedio(vedio);
		this.getRequest().setAttribute("vedio", vedio);
		Topic topic = new Topic();
		topic.setVedioid(id);
		List<Topic> topicList = this.topicService.getTopicByCond(topic);
		this.getRequest().setAttribute("topicList", topicList);
		this.getRequest().setAttribute("tnum", topicList.size());
		return "users/vedioDetail";
	}

	@RequestMapping("addTopic.action")
	public String addTopic(Topic topic) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		topic.setAddtime(VeDate.getStringDateShort());
		topic.setUsersid(userid);
		topic.setStatus("未回复");
		this.topicService.insertTopic(topic);
		return "redirect:/index/vedioDetail.action?id=" + topic.getVedioid();
	}

	@RequestMapping("preTest.action")
	public String preTest() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String clazzid = (String) this.getSession().getAttribute("clazzid");
		Course course = new Course();
		course.setClazzid(clazzid);
		List<Course> courseList = this.courseService.getCourseByCond(course);
		this.getRequest().setAttribute("courseList", courseList);
		return "users/test";
	}

	@RequestMapping("preExam.action")
	public String preExam() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String courseid = this.getRequest().getParameter("courseid");
		String sectionxid = this.getRequest().getParameter("sectionxid");
		Single single = new Single();
		single.setCourseid(courseid);
		single.setSectionxid(sectionxid);
		List<Single> singleList = this.singleService.getTestSingle(single);
		Mulit mulit = new Mulit();
		mulit.setCourseid(courseid);
		mulit.setSectionxid(sectionxid);
		List<Mulit> mulitList = this.mulitService.getTestMulit(mulit);
		Fillin fillin = new Fillin();
		fillin.setCourseid(courseid);
		fillin.setSectionxid(sectionxid);
		List<Fillin> fillinList = this.fillinService.getTestFillin(fillin);
		this.getRequest().setAttribute("singleList", singleList);
		this.getRequest().setAttribute("mulitList", mulitList);
		this.getRequest().setAttribute("fillinList", fillinList);
		String singleid = "";
		String fillinid = "";
		String mulitid = "";
		for (Single x : singleList) {
			singleid += x.getSingleid() + ",";
		}
		for (Mulit x : mulitList) {
			mulitid += x.getMulitid() + ",";
		}
		for (Fillin x : fillinList) {
			fillinid = x.getFillinid() + ",";
		}
		this.getRequest().setAttribute("singleid", singleid.substring(0, singleid.length() - 1));
		this.getRequest().setAttribute("mulitid", mulitid.substring(0, mulitid.length() - 1));
		this.getRequest().setAttribute("fillinid", fillinid.substring(0, fillinid.length() - 1));
		return "users/exam";
	}

	@RequestMapping("test.action")
	public String test() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		List<Single> singleList = new ArrayList<Single>();
		List<Mulit> mulitList = new ArrayList<Mulit>();
		List<Fillin> fillinList = new ArrayList<Fillin>();
		String[] singleid = this.getRequest().getParameter("singleid").split(",");
		for (int i = 0; i < singleid.length; i++) {
			Single single = this.singleService.getSingleById(singleid[i]);
			singleList.add(single);
			String sresult = this.getRequest().getParameter("single" + singleid[i]);
			if (sresult.equals(single.getCorrect())) {

			} else {
				Wrongs w = new Wrongs();
				w.setUsersid(userid);
				w.setQuections(single.getQuestion());
				List<Wrongs> list = this.wrongsService.getWrongsByCond(w);
				if (list.size() == 0) {
					w.setCourseid(single.getCourseid());
					w.setSectionxid(single.getSectionxid());
					w.setAddtime(VeDate.getStringDateShort());
					w.setWrongsid("W" + VeDate.getOrderCode());
					w.setParsing(single.getParsing());
					this.wrongsService.insertWrongs(w);
				}
			}
		}
		String[] mulitid = this.getRequest().getParameter("mulitid").split(",");
		for (int i = 0; i < mulitid.length; i++) {
			Mulit m = this.mulitService.getMulitById(mulitid[i]);
			mulitList.add(m);
			Mulit s = mulitList.get(i);
			String sresult = "";
			String[] x = this.getRequest().getParameterValues("mulit" + mulitid[i]);
			for (String xx : x) {
				sresult += xx + ",";
			}
			sresult = sresult.substring(0, sresult.length() - 1);
			if (sresult.equals(s.getCorrect())) {

			} else {
				Wrongs w = new Wrongs();
				w.setUsersid(userid);
				w.setQuections(m.getQuestion());
				List<Wrongs> list = this.wrongsService.getWrongsByCond(w);
				if (list.size() == 0) {
					w.setCourseid(m.getCourseid());
					w.setSectionxid(m.getSectionxid());
					w.setAddtime(VeDate.getStringDateShort());
					w.setWrongsid("W" + VeDate.getOrderCode());
					w.setParsing(m.getParsing());
					this.wrongsService.insertWrongs(w);
				}
			}
		}
		String[] fillinid = this.getRequest().getParameter("fillinid").split(",");
		for (int i = 0; i < fillinid.length; i++) {
			Fillin f = this.fillinService.getFillinById(fillinid[i]);
			fillinList.add(f);
			String sresult = this.getRequest().getParameter("fillin" + fillinid[i]);
			if (sresult.equals(f.getCorrect())) {

			} else {
				Wrongs w = new Wrongs();
				w.setUsersid(userid);
				w.setQuections(f.getQuestion());
				List<Wrongs> list = this.wrongsService.getWrongsByCond(w);
				if (list.size() == 0) {
					w.setCourseid(f.getCourseid());
					w.setSectionxid(f.getSectionxid());
					w.setAddtime(VeDate.getStringDateShort());
					w.setWrongsid("W" + VeDate.getOrderCode());
					w.setParsing(f.getParsing());
					this.wrongsService.insertWrongs(w);
				}
			}
		}
		this.getRequest().setAttribute("singleList", singleList);
		this.getRequest().setAttribute("mulitList", mulitList);
		this.getRequest().setAttribute("fillinList", fillinList);
		return "users/answer";
	}
	// TODO Auto-generated method stub
}
