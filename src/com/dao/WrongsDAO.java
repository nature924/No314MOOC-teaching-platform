package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Wrongs;

@Repository("wrongsDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface WrongsDAO {

	/**
* WrongsDAO 接口 可以按名称直接调用wrongs.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包wrongs.xml里的insertWrongs配置 返回值0(失败),1(成功)
	public int insertWrongs(Wrongs wrongs);

	// 更新数据 调用entity包wrongs.xml里的updateWrongs配置 返回值0(失败),1(成功)
	public int updateWrongs(Wrongs wrongs);

	// 删除数据 调用entity包wrongs.xml里的deleteWrongs配置 返回值0(失败),1(成功)
	public int deleteWrongs(String wrongsid);

	// 查询全部数据 调用entity包wrongs.xml里的getAllWrongs配置 返回List类型的数据
	public List<Wrongs> getAllWrongs();

	// 按照Wrongs类里面的值精确查询 调用entity包wrongs.xml里的getWrongsByCond配置 返回List类型的数据
	public List<Wrongs> getWrongsByCond(Wrongs wrongs);

	// 按照Wrongs类里面的值模糊查询 调用entity包wrongs.xml里的getWrongsByLike配置 返回List类型的数据
	public List<Wrongs> getWrongsByLike(Wrongs wrongs);

	// 按主键查询表返回单一的Wrongs实例 调用entity包wrongs.xml里的getWrongsById配置
	public Wrongs getWrongsById(String wrongsid);

}


