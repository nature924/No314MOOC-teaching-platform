package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Fillin;

@Service("fillinService")
public interface FillinService {
	// 插入数据 调用fillinDAO里的insertFillin配置
	public int insertFillin(Fillin fillin);

	// 更新数据 调用fillinDAO里的updateFillin配置
	public int updateFillin(Fillin fillin);

	// 删除数据 调用fillinDAO里的deleteFillin配置
	public int deleteFillin(String fillinid);

	// 查询全部数据 调用fillinDAO里的getAllFillin配置
	public List<Fillin> getAllFillin();

	public List<Fillin> getTestFillin(Fillin fillin);

	// 按照Fillin类里面的字段名称精确查询 调用fillinDAO里的getFillinByCond配置
	public List<Fillin> getFillinByCond(Fillin fillin);

	// 按照Fillin类里面的字段名称模糊查询 调用fillinDAO里的getFillinByLike配置
	public List<Fillin> getFillinByLike(Fillin fillin);

	// 按主键查询表返回单一的Fillin实例 调用fillinDAO里的getFillinById配置
	public Fillin getFillinById(String fillinid);

}
