package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Score;

@Repository("scoreDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface ScoreDAO {

	/**
* ScoreDAO 接口 可以按名称直接调用score.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包score.xml里的insertScore配置 返回值0(失败),1(成功)
	public int insertScore(Score score);

	// 更新数据 调用entity包score.xml里的updateScore配置 返回值0(失败),1(成功)
	public int updateScore(Score score);

	// 删除数据 调用entity包score.xml里的deleteScore配置 返回值0(失败),1(成功)
	public int deleteScore(String scoreid);

	// 查询全部数据 调用entity包score.xml里的getAllScore配置 返回List类型的数据
	public List<Score> getAllScore();

	// 按照Score类里面的值精确查询 调用entity包score.xml里的getScoreByCond配置 返回List类型的数据
	public List<Score> getScoreByCond(Score score);

	// 按照Score类里面的值模糊查询 调用entity包score.xml里的getScoreByLike配置 返回List类型的数据
	public List<Score> getScoreByLike(Score score);

	// 按主键查询表返回单一的Score实例 调用entity包score.xml里的getScoreById配置
	public Score getScoreById(String scoreid);

}


