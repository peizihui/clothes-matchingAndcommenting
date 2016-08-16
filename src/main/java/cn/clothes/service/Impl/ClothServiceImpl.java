package cn.clothes.service.Impl;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.clothes.dao.ClothDao;
import cn.clothes.dao.ClothUserDao;
import cn.clothes.dto.UploadResultBean;
import cn.clothes.entity.ClothUser;
import cn.clothes.entity.Clothes;
import cn.clothes.entity.User;
import cn.clothes.service.ClothService;
import cn.clothes.util.FileUtil;
import cn.clothes.util.ImageUtil;

@Service
public class ClothServiceImpl implements ClothService{
	
	@Autowired
	private ClothDao dao;
	@Autowired
	private ClothUserDao userDao;

	@Override
	public void addCloth(MultipartFile file, String content, UploadResultBean bean, User user, String path) throws IOException {
		//保存图片信息
		ImageUtil.read(file.getBytes()).transferTo(file.getContentType(), new File(path));
		
		//保存服装信息
		Clothes cloth = new Clothes();
		cloth.setClothIcon(path);
		cloth.setCreateTime(System.currentTimeMillis());
		cloth.setDescription(content);
		dao.insertCloth(cloth);
		
		//保存用户和服装关系
		ClothUser clothUser = new ClothUser();
		clothUser.setClothId(cloth.getId());
		clothUser.setUserId(user.getId());
		this.userDao.insertClothUser(clothUser);
		
		bean.setContent(content);
		bean.setIconPath(path);
	}
}
