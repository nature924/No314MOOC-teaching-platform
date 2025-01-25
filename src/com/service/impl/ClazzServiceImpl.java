package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ClazzDAO;
import com.entity.Clazz;
import com.service.ClazzService;

@Service("clazzService")
public class ClazzServiceImpl implements ClazzService {
	@Autowired
	private ClazzDAO clazzDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertClazz(Clazz clazz) {
		return this.clazzDAO.insertClazz(clazz);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateClazz(Clazz clazz) {
		return this.clazzDAO.updateClazz(clazz);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteClazz(String clazzid) {
		return this.clazzDAO.deleteClazz(clazzid);
	}

	@Override // 继承接口的查询全部
	public List<Clazz> getAllClazz() {
		return this.clazzDAO.getAllClazz();
	}

	@Override // 继承接口的按条件精确查询
	public List<Clazz> getClazzByCond(Clazz clazz) {
		return this.clazzDAO.getClazzByCond(clazz);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Clazz> getClazzByLike(Clazz clazz) {
		return this.clazzDAO.getClazzByLike(clazz);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Clazz getClazzById(String clazzid) {
		return this.clazzDAO.getClazzById(clazzid);
	}

}

