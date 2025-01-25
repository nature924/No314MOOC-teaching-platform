package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Sectionx;

@Repository("sectionxDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface SectionxDAO {

	/**
* SectionxDAO 接口 可以按名称直接调用sectionx.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包sectionx.xml里的insertSectionx配置 返回值0(失败),1(成功)
	public int insertSectionx(Sectionx sectionx);

	// 更新数据 调用entity包sectionx.xml里的updateSectionx配置 返回值0(失败),1(成功)
	public int updateSectionx(Sectionx sectionx);

	// 删除数据 调用entity包sectionx.xml里的deleteSectionx配置 返回值0(失败),1(成功)
	public int deleteSectionx(String sectionxid);

	// 查询全部数据 调用entity包sectionx.xml里的getAllSectionx配置 返回List类型的数据
	public List<Sectionx> getAllSectionx();

	// 按照Sectionx类里面的值精确查询 调用entity包sectionx.xml里的getSectionxByCond配置 返回List类型的数据
	public List<Sectionx> getSectionxByCond(Sectionx sectionx);

	// 按照Sectionx类里面的值模糊查询 调用entity包sectionx.xml里的getSectionxByLike配置 返回List类型的数据
	public List<Sectionx> getSectionxByLike(Sectionx sectionx);

	// 按主键查询表返回单一的Sectionx实例 调用entity包sectionx.xml里的getSectionxById配置
	public Sectionx getSectionxById(String sectionxid);

}


