package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ScoreDAO;
import com.entity.Score;
import com.service.ScoreService;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	private ScoreDAO scoreDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertScore(Score score) {
		return this.scoreDAO.insertScore(score);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateScore(Score score) {
		return this.scoreDAO.updateScore(score);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteScore(String scoreid) {
		return this.scoreDAO.deleteScore(scoreid);
	}

	@Override // 继承接口的查询全部
	public List<Score> getAllScore() {
		return this.scoreDAO.getAllScore();
	}

	@Override // 继承接口的按条件精确查询
	public List<Score> getScoreByCond(Score score) {
		return this.scoreDAO.getScoreByCond(score);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Score> getScoreByLike(Score score) {
		return this.scoreDAO.getScoreByLike(score);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Score getScoreById(String scoreid) {
		return this.scoreDAO.getScoreById(scoreid);
	}

}

