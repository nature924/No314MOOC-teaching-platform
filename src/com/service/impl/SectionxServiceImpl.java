package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.SectionxDAO;
import com.entity.Sectionx;
import com.service.SectionxService;

@Service("sectionxService")
public class SectionxServiceImpl implements SectionxService {
	@Autowired
	private SectionxDAO sectionxDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertSectionx(Sectionx sectionx) {
		return this.sectionxDAO.insertSectionx(sectionx);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateSectionx(Sectionx sectionx) {
		return this.sectionxDAO.updateSectionx(sectionx);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteSectionx(String sectionxid) {
		return this.sectionxDAO.deleteSectionx(sectionxid);
	}

	@Override // 继承接口的查询全部
	public List<Sectionx> getAllSectionx() {
		return this.sectionxDAO.getAllSectionx();
	}

	@Override // 继承接口的按条件精确查询
	public List<Sectionx> getSectionxByCond(Sectionx sectionx) {
		return this.sectionxDAO.getSectionxByCond(sectionx);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Sectionx> getSectionxByLike(Sectionx sectionx) {
		return this.sectionxDAO.getSectionxByLike(sectionx);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Sectionx getSectionxById(String sectionxid) {
		return this.sectionxDAO.getSectionxById(sectionxid);
	}

}

