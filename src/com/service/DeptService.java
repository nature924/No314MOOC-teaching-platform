package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Dept;
@Service("deptService")
public interface DeptService {
	// 插入数据 调用deptDAO里的insertDept配置
	public int insertDept(Dept dept);

	// 更新数据 调用deptDAO里的updateDept配置
	public int updateDept(Dept dept);

	// 删除数据 调用deptDAO里的deleteDept配置
	public int deleteDept(String deptid);

	// 查询全部数据 调用deptDAO里的getAllDept配置
	public List<Dept> getAllDept();

	// 按照Dept类里面的字段名称精确查询 调用deptDAO里的getDeptByCond配置
	public List<Dept> getDeptByCond(Dept dept);

	// 按照Dept类里面的字段名称模糊查询 调用deptDAO里的getDeptByLike配置
	public List<Dept> getDeptByLike(Dept dept);

	// 按主键查询表返回单一的Dept实例 调用deptDAO里的getDeptById配置
	public Dept getDeptById(String deptid);

}

