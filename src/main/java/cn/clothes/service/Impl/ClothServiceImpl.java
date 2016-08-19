package cn.clothes.service.Impl;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.util.Base64;

import cn.clothes.dao.ClothDao;
import cn.clothes.dao.ClothUserDao;
import cn.clothes.dto.UploadResultBean;
import cn.clothes.entity.ClothUser;
import cn.clothes.entity.Clothes;
import cn.clothes.entity.User;
import cn.clothes.page.Pagination;
import cn.clothes.service.ClothService;
import cn.clothes.util.BdbHtmlPoolServer;
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
		BdbHtmlPoolServer instance = BdbHtmlPoolServer.getInstance();
		String cloth_icon = UUID.randomUUID().toString();
		
		byte[] encodeBase64 = org.apache.commons.codec.binary.Base64.encodeBase64(file.getBytes());
		instance.saveData(cloth_icon.getBytes(), encodeBase64);
		
		//保存服装信息
		Clothes cloth = new Clothes();
		cloth.setClothIcon(cloth_icon);
		cloth.setCreateTime(System.currentTimeMillis());
		cloth.setDescription(content);
		dao.insertCloth(cloth);
		
		//保存用户和服装关系
		ClothUser clothUser = new ClothUser();
		clothUser.setClothId(cloth.getId());
		clothUser.setUserId(user.getId());
		this.userDao.insertClothUser(clothUser);
		
		bean.setContent(content);
		String media = ImageUtil.getMediaType(encodeBase64).getMedia();
		//System.out.println("data:" + media + ";base64," + new String(encodeBase64));
		bean.setIconPath("data:" + media + ";base64," + new String(encodeBase64));
	}

	@Override
	public Pagination queryCloth(User user, Integer pageNumber, Integer pageSize, Integer totalCout, List<?> list) {
		//select * from t_clothing tc join t_cloth_user tcu on tc.n_id = tcu.n_cloth_id where tcu.n_user_id = 1
		return null;
	}
}
