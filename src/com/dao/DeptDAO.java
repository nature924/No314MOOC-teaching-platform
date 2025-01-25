package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Dept;

@Repository("deptDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface DeptDAO {

	/**
* DeptDAO 接口 可以按名称直接调用dept.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包dept.xml里的insertDept配置 返回值0(失败),1(成功)
	public int insertDept(Dept dept);

	// 更新数据 调用entity包dept.xml里的updateDept配置 返回值0(失败),1(成功)
	public int updateDept(Dept dept);

	// 删除数据 调用entity包dept.xml里的deleteDept配置 返回值0(失败),1(成功)
	public int deleteDept(String deptid);

	// 查询全部数据 调用entity包dept.xml里的getAllDept配置 返回List类型的数据
	public List<Dept> getAllDept();

	// 按照Dept类里面的值精确查询 调用entity包dept.xml里的getDeptByCond配置 返回List类型的数据
	public List<Dept> getDeptByCond(Dept dept);

	// 按照Dept类里面的值模糊查询 调用entity包dept.xml里的getDeptByLike配置 返回List类型的数据
	public List<Dept> getDeptByLike(Dept dept);

	// 按主键查询表返回单一的Dept实例 调用entity包dept.xml里的getDeptById配置
	public Dept getDeptById(String deptid);

}


