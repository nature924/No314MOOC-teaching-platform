package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Clazz;

@Repository("clazzDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface ClazzDAO {

	/**
* ClazzDAO 接口 可以按名称直接调用clazz.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包clazz.xml里的insertClazz配置 返回值0(失败),1(成功)
	public int insertClazz(Clazz clazz);

	// 更新数据 调用entity包clazz.xml里的updateClazz配置 返回值0(失败),1(成功)
	public int updateClazz(Clazz clazz);

	// 删除数据 调用entity包clazz.xml里的deleteClazz配置 返回值0(失败),1(成功)
	public int deleteClazz(String clazzid);

	// 查询全部数据 调用entity包clazz.xml里的getAllClazz配置 返回List类型的数据
	public List<Clazz> getAllClazz();

	// 按照Clazz类里面的值精确查询 调用entity包clazz.xml里的getClazzByCond配置 返回List类型的数据
	public List<Clazz> getClazzByCond(Clazz clazz);

	// 按照Clazz类里面的值模糊查询 调用entity包clazz.xml里的getClazzByLike配置 返回List类型的数据
	public List<Clazz> getClazzByLike(Clazz clazz);

	// 按主键查询表返回单一的Clazz实例 调用entity包clazz.xml里的getClazzById配置
	public Clazz getClazzById(String clazzid);

}


