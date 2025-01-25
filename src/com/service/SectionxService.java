package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Sectionx;
@Service("sectionxService")
public interface SectionxService {
	// 插入数据 调用sectionxDAO里的insertSectionx配置
	public int insertSectionx(Sectionx sectionx);

	// 更新数据 调用sectionxDAO里的updateSectionx配置
	public int updateSectionx(Sectionx sectionx);

	// 删除数据 调用sectionxDAO里的deleteSectionx配置
	public int deleteSectionx(String sectionxid);

	// 查询全部数据 调用sectionxDAO里的getAllSectionx配置
	public List<Sectionx> getAllSectionx();

	// 按照Sectionx类里面的字段名称精确查询 调用sectionxDAO里的getSectionxByCond配置
	public List<Sectionx> getSectionxByCond(Sectionx sectionx);

	// 按照Sectionx类里面的字段名称模糊查询 调用sectionxDAO里的getSectionxByLike配置
	public List<Sectionx> getSectionxByLike(Sectionx sectionx);

	// 按主键查询表返回单一的Sectionx实例 调用sectionxDAO里的getSectionxById配置
	public Sectionx getSectionxById(String sectionxid);

}

