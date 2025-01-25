package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.MulitDAO;
import com.entity.Mulit;
import com.service.MulitService;

@Service("mulitService")
public class MulitServiceImpl implements MulitService {
	@Autowired
	private MulitDAO mulitDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertMulit(Mulit mulit) {
		return this.mulitDAO.insertMulit(mulit);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateMulit(Mulit mulit) {
		return this.mulitDAO.updateMulit(mulit);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteMulit(String mulitid) {
		return this.mulitDAO.deleteMulit(mulitid);
	}

	@Override // 继承接口的查询全部
	public List<Mulit> getAllMulit() {
		return this.mulitDAO.getAllMulit();
	}

	@Override // 继承接口的查询全部
	public List<Mulit> getTestMulit(Mulit mulit) {
		return this.mulitDAO.getTestMulit(mulit);
	}

	@Override // 继承接口的按条件精确查询
	public List<Mulit> getMulitByCond(Mulit mulit) {
		return this.mulitDAO.getMulitByCond(mulit);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Mulit> getMulitByLike(Mulit mulit) {
		return this.mulitDAO.getMulitByLike(mulit);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Mulit getMulitById(String mulitid) {
		return this.mulitDAO.getMulitById(mulitid);
	}

}
