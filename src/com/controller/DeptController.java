package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Dept;
import com.service.DeptService;
import com.util.PageHelper;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/dept" , produces = "text/plain;charset=utf-8")
public class DeptController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private DeptService deptService;

	// 准备添加数据
	@RequestMapping("createDept.action")
	public String createDept() {
		return "admin/adddept";
	}
	// 添加数据
	@RequestMapping("addDept.action")
	public String addDept(Dept dept) {
		this.deptService.insertDept(dept);
		return "redirect:/dept/createDept.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteDept.action")
	public String deleteDept(String id) {
		this.deptService.deleteDept(id);
		return "redirect:/dept/getAllDept.action";
	}

	// 批量删除数据
	@RequestMapping("deleteDeptByIds.action")
	public String deleteDeptByIds() {
		String[] ids = this.getRequest().getParameterValues("deptid");
		if (ids != null) {
			for (String deptid : ids) {
				this.deptService.deleteDept(deptid);
			}
		}
		return "redirect:/dept/getAllDept.action";
	}

	// 更新数据
	@RequestMapping("updateDept.action")
	public String updateDept(Dept dept) {
		this.deptService.updateDept(dept);
		return "redirect:/dept/getAllDept.action";
	}

	// 显示全部数据
	@RequestMapping("getAllDept.action")
	public String getAllDept(String number) {
		List<Dept> deptList = this.deptService.getAllDept();
		PageHelper.getUserPage(deptList, "dept", "getAllDept", 10, number, this.getRequest());
		return "admin/listdept";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryDeptByCond.action")
	public String queryDeptByCond(String cond, String name, String number) {
		Dept dept = new Dept();
		if(cond != null){
			if ("deptname".equals(cond)) {
				dept.setDeptname(name);
			}
			if ("memo".equals(cond)) {
				dept.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.deptService.getDeptByLike(dept), "dept", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querydept";
	}

	// 按主键查询数据
	@RequestMapping("getDeptById.action")
	public String getDeptById(String id) {
		Dept dept = this.deptService.getDeptById(id);
		this.getRequest().setAttribute("dept", dept);
		return "admin/editdept";
	}


}
