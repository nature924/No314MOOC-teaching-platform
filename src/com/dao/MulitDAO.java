package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Mulit;

@Repository("mulitDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface MulitDAO {

	/**
* MulitDAO 接口 可以按名称直接调用mulit.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包mulit.xml里的insertMulit配置 返回值0(失败),1(成功)
	public int insertMulit(Mulit mulit);

	// 更新数据 调用entity包mulit.xml里的updateMulit配置 返回值0(失败),1(成功)
	public int updateMulit(Mulit mulit);

	// 删除数据 调用entity包mulit.xml里的deleteMulit配置 返回值0(失败),1(成功)
	public int deleteMulit(String mulitid);

	// 查询全部数据 调用entity包mulit.xml里的getAllMulit配置 返回List类型的数据
	public List<Mulit> getAllMulit();
	
	public List<Mulit> getTestMulit(Mulit mulit);

	// 按照Mulit类里面的值精确查询 调用entity包mulit.xml里的getMulitByCond配置 返回List类型的数据
	public List<Mulit> getMulitByCond(Mulit mulit);

	// 按照Mulit类里面的值模糊查询 调用entity包mulit.xml里的getMulitByLike配置 返回List类型的数据
	public List<Mulit> getMulitByLike(Mulit mulit);

	// 按主键查询表返回单一的Mulit实例 调用entity包mulit.xml里的getMulitById配置
	public Mulit getMulitById(String mulitid);

}


