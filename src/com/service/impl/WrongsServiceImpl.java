package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.WrongsDAO;
import com.entity.Wrongs;
import com.service.WrongsService;

@Service("wrongsService")
public class WrongsServiceImpl implements WrongsService {
	@Autowired
	private WrongsDAO wrongsDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertWrongs(Wrongs wrongs) {
		return this.wrongsDAO.insertWrongs(wrongs);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateWrongs(Wrongs wrongs) {
		return this.wrongsDAO.updateWrongs(wrongs);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteWrongs(String wrongsid) {
		return this.wrongsDAO.deleteWrongs(wrongsid);
	}

	@Override // 继承接口的查询全部
	public List<Wrongs> getAllWrongs() {
		return this.wrongsDAO.getAllWrongs();
	}

	@Override // 继承接口的按条件精确查询
	public List<Wrongs> getWrongsByCond(Wrongs wrongs) {
		return this.wrongsDAO.getWrongsByCond(wrongs);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Wrongs> getWrongsByLike(Wrongs wrongs) {
		return this.wrongsDAO.getWrongsByLike(wrongs);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Wrongs getWrongsById(String wrongsid) {
		return this.wrongsDAO.getWrongsById(wrongsid);
	}

}

