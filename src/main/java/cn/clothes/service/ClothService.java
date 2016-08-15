package cn.clothes.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import cn.clothes.dto.UploadResultBean;
import cn.clothes.entity.Clothes;

public interface ClothService {
	public void addCloth(MultipartFile file, String content, UploadResultBean bean);
	
}
