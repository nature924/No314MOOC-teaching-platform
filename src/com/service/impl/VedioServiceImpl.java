package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.VedioDAO;
import com.entity.Vedio;
import com.service.VedioService;

@Service("vedioService")
public class VedioServiceImpl implements VedioService {
	@Autowired
	private VedioDAO vedioDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertVedio(Vedio vedio) {
		return this.vedioDAO.insertVedio(vedio);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateVedio(Vedio vedio) {
		return this.vedioDAO.updateVedio(vedio);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteVedio(String vedioid) {
		return this.vedioDAO.deleteVedio(vedioid);
	}

	@Override // 继承接口的查询全部
	public List<Vedio> getAllVedio() {
		return this.vedioDAO.getAllVedio();
	}

	@Override // 继承接口的按条件精确查询
	public List<Vedio> getVedioByCond(Vedio vedio) {
		return this.vedioDAO.getVedioByCond(vedio);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Vedio> getVedioByLike(Vedio vedio) {
		return this.vedioDAO.getVedioByLike(vedio);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Vedio getVedioById(String vedioid) {
		return this.vedioDAO.getVedioById(vedioid);
	}

}

