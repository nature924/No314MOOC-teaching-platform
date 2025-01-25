package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.SingleDAO;
import com.entity.Single;
import com.service.SingleService;

@Service("singleService")
public class SingleServiceImpl implements SingleService {
	@Autowired
	private SingleDAO singleDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertSingle(Single single) {
		return this.singleDAO.insertSingle(single);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateSingle(Single single) {
		return this.singleDAO.updateSingle(single);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteSingle(String singleid) {
		return this.singleDAO.deleteSingle(singleid);
	}

	@Override // 继承接口的查询全部
	public List<Single> getAllSingle() {
		return this.singleDAO.getAllSingle();
	}

	@Override // 继承接口的查询全部
	public List<Single> getTestSingle(Single single) {
		return this.singleDAO.getTestSingle(single);
	}

	@Override // 继承接口的按条件精确查询
	public List<Single> getSingleByCond(Single single) {
		return this.singleDAO.getSingleByCond(single);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Single> getSingleByLike(Single single) {
		return this.singleDAO.getSingleByLike(single);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Single getSingleById(String singleid) {
		return this.singleDAO.getSingleById(singleid);
	}

}
