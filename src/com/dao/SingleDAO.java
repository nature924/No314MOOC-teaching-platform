package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Single;

@Repository("singleDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface SingleDAO {

	/**
	 * SingleDAO 接口 可以按名称直接调用single.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包single.xml里的insertSingle配置 返回值0(失败),1(成功)
	public int insertSingle(Single single);

	// 更新数据 调用entity包single.xml里的updateSingle配置 返回值0(失败),1(成功)
	public int updateSingle(Single single);

	// 删除数据 调用entity包single.xml里的deleteSingle配置 返回值0(失败),1(成功)
	public int deleteSingle(String singleid);

	// 查询全部数据 调用entity包single.xml里的getAllSingle配置 返回List类型的数据
	public List<Single> getAllSingle();

	public List<Single> getTestSingle(Single single);

	// 按照Single类里面的值精确查询 调用entity包single.xml里的getSingleByCond配置 返回List类型的数据
	public List<Single> getSingleByCond(Single single);

	// 按照Single类里面的值模糊查询 调用entity包single.xml里的getSingleByLike配置 返回List类型的数据
	public List<Single> getSingleByLike(Single single);

	// 按主键查询表返回单一的Single实例 调用entity包single.xml里的getSingleById配置
	public Single getSingleById(String singleid);

}
