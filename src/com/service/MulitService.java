package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Mulit;

@Service("mulitService")
public interface MulitService {
	// 插入数据 调用mulitDAO里的insertMulit配置
	public int insertMulit(Mulit mulit);

	// 更新数据 调用mulitDAO里的updateMulit配置
	public int updateMulit(Mulit mulit);

	// 删除数据 调用mulitDAO里的deleteMulit配置
	public int deleteMulit(String mulitid);

	// 查询全部数据 调用mulitDAO里的getAllMulit配置
	public List<Mulit> getAllMulit();

	public List<Mulit> getTestMulit(Mulit mulit);

	// 按照Mulit类里面的字段名称精确查询 调用mulitDAO里的getMulitByCond配置
	public List<Mulit> getMulitByCond(Mulit mulit);

	// 按照Mulit类里面的字段名称模糊查询 调用mulitDAO里的getMulitByLike配置
	public List<Mulit> getMulitByLike(Mulit mulit);

	// 按主键查询表返回单一的Mulit实例 调用mulitDAO里的getMulitById配置
	public Mulit getMulitById(String mulitid);

}
