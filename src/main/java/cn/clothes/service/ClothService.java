package cn.clothes.service;


import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import cn.clothes.dto.UploadResultBean;
import cn.clothes.entity.User;

public interface ClothService {
	
	/**
	 * 保存上传内容
	 * @param file
	 * @param content
	 * @param bean
	 */
	public void addCloth(MultipartFile file, String content, UploadResultBean bean, User user, String path) throws IOException ;
	
}
