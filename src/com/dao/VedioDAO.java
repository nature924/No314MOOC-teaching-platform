package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Vedio;

@Repository("vedioDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface VedioDAO {

	/**
* VedioDAO 接口 可以按名称直接调用vedio.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包vedio.xml里的insertVedio配置 返回值0(失败),1(成功)
	public int insertVedio(Vedio vedio);

	// 更新数据 调用entity包vedio.xml里的updateVedio配置 返回值0(失败),1(成功)
	public int updateVedio(Vedio vedio);

	// 删除数据 调用entity包vedio.xml里的deleteVedio配置 返回值0(失败),1(成功)
	public int deleteVedio(String vedioid);

	// 查询全部数据 调用entity包vedio.xml里的getAllVedio配置 返回List类型的数据
	public List<Vedio> getAllVedio();

	// 按照Vedio类里面的值精确查询 调用entity包vedio.xml里的getVedioByCond配置 返回List类型的数据
	public List<Vedio> getVedioByCond(Vedio vedio);

	// 按照Vedio类里面的值模糊查询 调用entity包vedio.xml里的getVedioByLike配置 返回List类型的数据
	public List<Vedio> getVedioByLike(Vedio vedio);

	// 按主键查询表返回单一的Vedio实例 调用entity包vedio.xml里的getVedioById配置
	public Vedio getVedioById(String vedioid);

}


