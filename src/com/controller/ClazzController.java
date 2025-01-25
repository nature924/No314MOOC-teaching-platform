package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Clazz;
import com.service.ClazzService;
import com.entity.Dept;
import com.service.DeptService;
import com.util.PageHelper;
import com.util.VeDate;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/clazz" , produces = "text/plain;charset=utf-8")
public class ClazzController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private ClazzService clazzService;
	@Autowired
	private DeptService deptService;

	// 准备添加数据
	@RequestMapping("createClazz.action")
	public String createClazz() {
		List<Dept> deptList = this.deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		return "admin/addclazz";
	}
	// 添加数据
	@RequestMapping("addClazz.action")
	public String addClazz(Clazz clazz) {
		clazz.setAddtime(VeDate.getStringDateShort());
		this.clazzService.insertClazz(clazz);
		return "redirect:/clazz/createClazz.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteClazz.action")
	public String deleteClazz(String id) {
		this.clazzService.deleteClazz(id);
		return "redirect:/clazz/getAllClazz.action";
	}

	// 批量删除数据
	@RequestMapping("deleteClazzByIds.action")
	public String deleteClazzByIds() {
		String[] ids = this.getRequest().getParameterValues("clazzid");
		if (ids != null) {
			for (String clazzid : ids) {
				this.clazzService.deleteClazz(clazzid);
			}
		}
		return "redirect:/clazz/getAllClazz.action";
	}

	// 更新数据
	@RequestMapping("updateClazz.action")
	public String updateClazz(Clazz clazz) {
		this.clazzService.updateClazz(clazz);
		return "redirect:/clazz/getAllClazz.action";
	}

	// 显示全部数据
	@RequestMapping("getAllClazz.action")
	public String getAllClazz(String number) {
		List<Clazz> clazzList = this.clazzService.getAllClazz();
		PageHelper.getUserPage(clazzList, "clazz", "getAllClazz", 10, number, this.getRequest());
		return "admin/listclazz";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryClazzByCond.action")
	public String queryClazzByCond(String cond, String name, String number) {
		Clazz clazz = new Clazz();
		if(cond != null){
			if ("clazzname".equals(cond)) {
				clazz.setClazzname(name);
			}
			if ("manager".equals(cond)) {
				clazz.setManager(name);
			}
			if ("addtime".equals(cond)) {
				clazz.setAddtime(name);
			}
			if ("deptid".equals(cond)) {
				clazz.setDeptid(name);
			}
			if ("memo".equals(cond)) {
				clazz.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.clazzService.getClazzByLike(clazz), "clazz", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryclazz";
	}

	// 按主键查询数据
	@RequestMapping("getClazzById.action")
	public String getClazzById(String id) {
		Clazz clazz = this.clazzService.getClazzById(id);
		this.getRequest().setAttribute("clazz", clazz);
		List<Dept> deptList = this.deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		return "admin/editclazz";
	}


}
