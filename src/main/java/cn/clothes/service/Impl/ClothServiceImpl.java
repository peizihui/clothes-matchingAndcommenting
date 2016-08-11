package cn.clothes.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.clothes.dao.ClothDao;
import cn.clothes.entity.Clothes;
import cn.clothes.service.ClothService;

public class ClothServiceImpl implements ClothService{
	
	@Autowired
	private ClothDao dao;
	
	public void insertCloth(Clothes cloth) {
		dao.insertCloth(cloth);
	}

	public int updateCloth(Long id) {
		return dao.updateCloth(id);
	}

	public Clothes queryCloth(Long id) {
		return dao.queryCloth(id);
	}

	public List<Clothes> queryForPage(int offset, int limit) {
		return dao.queryForPage(offset, limit);
	}

	public int deleteCloth(Long id) {
		return dao.deleteCloth(id);
	}

}
