package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Wrongs;
@Service("wrongsService")
public interface WrongsService {
	// 插入数据 调用wrongsDAO里的insertWrongs配置
	public int insertWrongs(Wrongs wrongs);

	// 更新数据 调用wrongsDAO里的updateWrongs配置
	public int updateWrongs(Wrongs wrongs);

	// 删除数据 调用wrongsDAO里的deleteWrongs配置
	public int deleteWrongs(String wrongsid);

	// 查询全部数据 调用wrongsDAO里的getAllWrongs配置
	public List<Wrongs> getAllWrongs();

	// 按照Wrongs类里面的字段名称精确查询 调用wrongsDAO里的getWrongsByCond配置
	public List<Wrongs> getWrongsByCond(Wrongs wrongs);

	// 按照Wrongs类里面的字段名称模糊查询 调用wrongsDAO里的getWrongsByLike配置
	public List<Wrongs> getWrongsByLike(Wrongs wrongs);

	// 按主键查询表返回单一的Wrongs实例 调用wrongsDAO里的getWrongsById配置
	public Wrongs getWrongsById(String wrongsid);

}

