package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Vedio;
@Service("vedioService")
public interface VedioService {
	// 插入数据 调用vedioDAO里的insertVedio配置
	public int insertVedio(Vedio vedio);

	// 更新数据 调用vedioDAO里的updateVedio配置
	public int updateVedio(Vedio vedio);

	// 删除数据 调用vedioDAO里的deleteVedio配置
	public int deleteVedio(String vedioid);

	// 查询全部数据 调用vedioDAO里的getAllVedio配置
	public List<Vedio> getAllVedio();

	// 按照Vedio类里面的字段名称精确查询 调用vedioDAO里的getVedioByCond配置
	public List<Vedio> getVedioByCond(Vedio vedio);

	// 按照Vedio类里面的字段名称模糊查询 调用vedioDAO里的getVedioByLike配置
	public List<Vedio> getVedioByLike(Vedio vedio);

	// 按主键查询表返回单一的Vedio实例 调用vedioDAO里的getVedioById配置
	public Vedio getVedioById(String vedioid);

}

