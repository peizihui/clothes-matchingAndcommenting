package cn.clothes.service;


import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.clothes.dto.UploadResultBean;
import cn.clothes.entity.User;
import cn.clothes.page.Pagination;

public interface ClothService {
	
	/**
	 * 保存上传内容
	 * @param file
	 * @param content
	 * @param bean
	 */
	public void addCloth(MultipartFile file, String content, UploadResultBean bean, User user, String path) throws IOException ;
	
	
	/**
	 * 分页查询数据//new Pagination(pageNumber, pageSize, pager.getRecordCount(), list);
	 * @param pageNumber
	 * @param pageSize
	 * @param totalCout
	 * @param list
	 * @return
	 */
	public Pagination queryCloth(User user, Integer pageNumber, Integer pageSize, Integer totalCout, List<?> list);
}
