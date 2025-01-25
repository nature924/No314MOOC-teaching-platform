package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Fillin;

@Repository("fillinDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface FillinDAO {

	/**
	 * FillinDAO 接口 可以按名称直接调用fillin.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包fillin.xml里的insertFillin配置 返回值0(失败),1(成功)
	public int insertFillin(Fillin fillin);

	// 更新数据 调用entity包fillin.xml里的updateFillin配置 返回值0(失败),1(成功)
	public int updateFillin(Fillin fillin);

	// 删除数据 调用entity包fillin.xml里的deleteFillin配置 返回值0(失败),1(成功)
	public int deleteFillin(String fillinid);

	// 查询全部数据 调用entity包fillin.xml里的getAllFillin配置 返回List类型的数据
	public List<Fillin> getAllFillin();

	public List<Fillin> getTestFillin(Fillin fillin);

	// 按照Fillin类里面的值精确查询 调用entity包fillin.xml里的getFillinByCond配置 返回List类型的数据
	public List<Fillin> getFillinByCond(Fillin fillin);

	// 按照Fillin类里面的值模糊查询 调用entity包fillin.xml里的getFillinByLike配置 返回List类型的数据
	public List<Fillin> getFillinByLike(Fillin fillin);

	// 按主键查询表返回单一的Fillin实例 调用entity包fillin.xml里的getFillinById配置
	public Fillin getFillinById(String fillinid);

}
