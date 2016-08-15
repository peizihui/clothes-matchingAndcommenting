package cn.clothes.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.clothes.dao.ClothDao;
import cn.clothes.dto.UploadResultBean;
import cn.clothes.entity.Clothes;
import cn.clothes.service.ClothService;

@Service
public class ClothServiceImpl implements ClothService{
	
	@Autowired
	private ClothDao dao;

	@Override
	public void addCloth(MultipartFile file, String content, UploadResultBean bean) {
		
	}
	
}
