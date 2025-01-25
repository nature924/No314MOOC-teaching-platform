package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.FillinDAO;
import com.entity.Fillin;
import com.service.FillinService;

@Service("fillinService")
public class FillinServiceImpl implements FillinService {
	@Autowired
	private FillinDAO fillinDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertFillin(Fillin fillin) {
		return this.fillinDAO.insertFillin(fillin);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateFillin(Fillin fillin) {
		return this.fillinDAO.updateFillin(fillin);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteFillin(String fillinid) {
		return this.fillinDAO.deleteFillin(fillinid);
	}

	@Override // 继承接口的查询全部
	public List<Fillin> getAllFillin() {
		return this.fillinDAO.getAllFillin();
	}

	@Override // 继承接口的查询全部
	public List<Fillin> getTestFillin(Fillin fillin) {
		return this.fillinDAO.getTestFillin(fillin);
	}

	@Override // 继承接口的按条件精确查询
	public List<Fillin> getFillinByCond(Fillin fillin) {
		return this.fillinDAO.getFillinByCond(fillin);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Fillin> getFillinByLike(Fillin fillin) {
		return this.fillinDAO.getFillinByLike(fillin);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Fillin getFillinById(String fillinid) {
		return this.fillinDAO.getFillinById(fillinid);
	}

}
