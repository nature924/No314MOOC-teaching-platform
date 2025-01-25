package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Score;
@Service("scoreService")
public interface ScoreService {
	// 插入数据 调用scoreDAO里的insertScore配置
	public int insertScore(Score score);

	// 更新数据 调用scoreDAO里的updateScore配置
	public int updateScore(Score score);

	// 删除数据 调用scoreDAO里的deleteScore配置
	public int deleteScore(String scoreid);

	// 查询全部数据 调用scoreDAO里的getAllScore配置
	public List<Score> getAllScore();

	// 按照Score类里面的字段名称精确查询 调用scoreDAO里的getScoreByCond配置
	public List<Score> getScoreByCond(Score score);

	// 按照Score类里面的字段名称模糊查询 调用scoreDAO里的getScoreByLike配置
	public List<Score> getScoreByLike(Score score);

	// 按主键查询表返回单一的Score实例 调用scoreDAO里的getScoreById配置
	public Score getScoreById(String scoreid);

}

