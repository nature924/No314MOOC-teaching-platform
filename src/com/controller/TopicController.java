package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Topic;
import com.service.TopicService;
import com.entity.Users;
import com.entity.Vedio;
import com.service.UsersService;
import com.service.VedioService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/topic", produces = "text/plain;charset=utf-8")
public class TopicController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private TopicService topicService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private VedioService vedioService;

	// 准备添加数据
	@RequestMapping("createTopic.action")
	public String createTopic() {
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Vedio> vedioList = this.vedioService.getAllVedio();
		this.getRequest().setAttribute("vedioList", vedioList);
		return "admin/addtopic";
	}

	// 添加数据
	@RequestMapping("addTopic.action")
	public String addTopic(Topic topic) {
		topic.setUsersid("");
		topic.setVedioid("");
		topic.setAddtime(VeDate.getStringDateShort());
		topic.setStatus("");
		this.topicService.insertTopic(topic);
		return "redirect:/topic/createTopic.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteTopic.action")
	public String deleteTopic(String id) {
		this.topicService.deleteTopic(id);
		return "redirect:/topic/getAllTopic.action";
	}

	// 批量删除数据
	@RequestMapping("deleteTopicByIds.action")
	public String deleteTopicByIds() {
		String[] ids = this.getRequest().getParameterValues("topicid");
		if (ids != null) {
			for (String topicid : ids) {
				this.topicService.deleteTopic(topicid);
			}
		}
		return "redirect:/topic/getAllTopic.action";
	}

	// 更新数据
	@RequestMapping("updateTopic.action")
	public String updateTopic(Topic topic) {
		this.topicService.updateTopic(topic);
		return "redirect:/topic/getMyTopic.action";
	}

	// 更新状态
	@RequestMapping("status.action")
	public String status(String id) {
		String status = "";
		Topic topic = this.topicService.getTopicById(id);
		if (status.equals(topic.getStatus())) {
			status = "";
		}
		topic.setStatus(status);
		this.topicService.updateTopic(topic);
		return "redirect:/topic/getAllTopic.action";
	}

	// 显示全部数据
	@RequestMapping("getAllTopic.action")
	public String getAllTopic(String number) {
		List<Topic> topicList = this.topicService.getAllTopic();
		PageHelper.getUserPage(topicList, "topic", "getAllTopic", 10, number, this.getRequest());
		return "admin/listtopic";
	}

	@RequestMapping("getMyTopic.action")
	public String getMyTopic(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Topic topic = new Topic();
		topic.setTeacherid(adminid);
		List<Topic> topicList = this.topicService.getTopicByCond(topic);
		PageHelper.getUserPage(topicList, "topic", "getMyTopic", 10, number, this.getRequest());
		return "admin/xlisttopic";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryTopicByCond.action")
	public String queryTopicByCond(String cond, String name, String number) {
		Topic topic = new Topic();
		if (cond != null) {
			if ("usersid".equals(cond)) {
				topic.setUsersid(name);
			}
			if ("vedioid".equals(cond)) {
				topic.setVedioid(name);
			}
			if ("contents".equals(cond)) {
				topic.setContents(name);
			}
			if ("addtime".equals(cond)) {
				topic.setAddtime(name);
			}
			if ("status".equals(cond)) {
				topic.setStatus(name);
			}
			if ("reps".equals(cond)) {
				topic.setReps(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.topicService.getTopicByLike(topic), "topic", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querytopic";
	}

	// 按主键查询数据
	@RequestMapping("getTopicById.action")
	public String getTopicById(String id) {
		Topic topic = this.topicService.getTopicById(id);
		this.getRequest().setAttribute("topic", topic);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Vedio> vedioList = this.vedioService.getAllVedio();
		this.getRequest().setAttribute("vedioList", vedioList);
		return "admin/edittopic";
	}

}
