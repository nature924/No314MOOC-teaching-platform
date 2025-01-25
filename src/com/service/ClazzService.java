package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Clazz;
@Service("clazzService")
public interface ClazzService {
	// 插入数据 调用clazzDAO里的insertClazz配置
	public int insertClazz(Clazz clazz);

	// 更新数据 调用clazzDAO里的updateClazz配置
	public int updateClazz(Clazz clazz);

	// 删除数据 调用clazzDAO里的deleteClazz配置
	public int deleteClazz(String clazzid);

	// 查询全部数据 调用clazzDAO里的getAllClazz配置
	public List<Clazz> getAllClazz();

	// 按照Clazz类里面的字段名称精确查询 调用clazzDAO里的getClazzByCond配置
	public List<Clazz> getClazzByCond(Clazz clazz);

	// 按照Clazz类里面的字段名称模糊查询 调用clazzDAO里的getClazzByLike配置
	public List<Clazz> getClazzByLike(Clazz clazz);

	// 按主键查询表返回单一的Clazz实例 调用clazzDAO里的getClazzById配置
	public Clazz getClazzById(String clazzid);

}

