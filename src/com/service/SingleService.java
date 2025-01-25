package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Single;

@Service("singleService")
public interface SingleService {
	// 插入数据 调用singleDAO里的insertSingle配置
	public int insertSingle(Single single);

	// 更新数据 调用singleDAO里的updateSingle配置
	public int updateSingle(Single single);

	// 删除数据 调用singleDAO里的deleteSingle配置
	public int deleteSingle(String singleid);

	// 查询全部数据 调用singleDAO里的getAllSingle配置
	public List<Single> getAllSingle();

	public List<Single> getTestSingle(Single single);

	// 按照Single类里面的字段名称精确查询 调用singleDAO里的getSingleByCond配置
	public List<Single> getSingleByCond(Single single);

	// 按照Single类里面的字段名称模糊查询 调用singleDAO里的getSingleByLike配置
	public List<Single> getSingleByLike(Single single);

	// 按主键查询表返回单一的Single实例 调用singleDAO里的getSingleById配置
	public Single getSingleById(String singleid);

}
