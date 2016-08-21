package cn.clothes.service.Impl;


import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.clothes.dao.ClothDao;
import cn.clothes.dao.ClothUserDao;
import cn.clothes.dao.CollectDao;
import cn.clothes.dao.CommentDao;
import cn.clothes.dao.LikeDao;
import cn.clothes.dto.ClothResultBean;
import cn.clothes.dto.UploadResultBean;
import cn.clothes.entity.ClothUser;
import cn.clothes.entity.Clothes;
import cn.clothes.entity.Collect;
import cn.clothes.entity.Like;
import cn.clothes.entity.User;
import cn.clothes.page.Pagination;
import cn.clothes.service.ClothService;
import cn.clothes.util.BdbHtmlPoolServer;
import cn.clothes.util.ImageUtil;

@Service
public class ClothServiceImpl implements ClothService{
	
	@Autowired
	private ClothDao dao;
	@Autowired
	private ClothUserDao userDao;
	@Autowired
	private LikeDao likeDao;
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private CollectDao collectDao;
	
	
	@Override
	public void addCloth(MultipartFile file, String content, UploadResultBean bean, User user, String path) throws IOException {
		//保存图片信息
		BdbHtmlPoolServer instance = BdbHtmlPoolServer.getInstance();
		String cloth_icon = UUID.randomUUID().toString();
		
		byte[] encodeBase64 = org.apache.commons.codec.binary.Base64.encodeBase64(file.getBytes());
		String media = ImageUtil.getMediaType(encodeBase64).getMedia();
		String pathIcon = "data:" + media + ";base64," + new String(encodeBase64);
		instance.saveData(cloth_icon.getBytes(), pathIcon.getBytes());

		bean.setIconPath(pathIcon);
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
	}

	@Override
	public Pagination queryCloth(User user, Integer pageNumber, Integer pageSize, String serach) {
		//pageNumber = 1;
		if(pageSize == null) {
			pageSize = 10;
		}
		
		BdbHtmlPoolServer instance = BdbHtmlPoolServer.getInstance();
		List<ClothResultBean> resultBean = this.dao.queryResultBean(user.getId(), pageNumber, pageSize, serach);
		for(ClothResultBean bean : resultBean) {
			Integer allLikeCount = likeDao.queryAllLikeByCloth(bean.getClothId(), Like.LikeStatus.add.value);
			bean.setLikeCount(allLikeCount);
			
			int allCountComment = commentDao.queryCountByClothId(bean.getClothId());
			bean.setCommentCount(allCountComment);
			
			//获取服装图片信息
			if(bean.getClothIcon() != null) {
				String iconBean = instance.getClientResultBen(bean.getClothIcon().getBytes());
				bean.setClothIcon(iconBean);
			}
			//用户图片信息
			if(bean.getUserIcon() != null) {
				String userIcon = instance.getClientResultBen(bean.getUserIcon().getBytes());
				bean.setUserIcon(userIcon);
			}
		}
		instance.close();
		Integer totalCount = this.dao.queryCount();
		return new Pagination(pageNumber, pageSize, totalCount, resultBean);
	}

	@Override
	public void like(User user, Long clothId) {
		Like queryLike = this.likeDao.queryLike(clothId, user.getId());
		if(queryLike == null) {
			Like like = new Like();
			like.setClothingId(clothId);
			like.setLikeTime(System.currentTimeMillis());
			like.setUserId(user.getId());
			like.setStatus(Like.LikeStatus.add.value);
		}else {
			if(queryLike.getStatus() == Like.LikeStatus.add.value) {
				this.likeDao.updateLikeStatus(clothId, Like.LikeStatus.cancel.value);
			}else {
				this.likeDao.updateLikeStatus(clothId, Like.LikeStatus.add.value);
			}
		}
	}

	@Override
	public int collect(User user, Long clothId) {
		int existCollect = collectDao.isExistCollect(clothId, user.getId());
		if(existCollect>0) {
			return 0;
		}else {
			Collect collect = new Collect();
			collect.setCollectId(clothId);
			collect.setCollectTime(System.currentTimeMillis());
			collect.setUserId(user.getId());
			collectDao.insertCollect(collect);
			return 1;
		}
	}

	@Override
	public ClothResultBean detail(User user, Long clothId) {
		BdbHtmlPoolServer instance = BdbHtmlPoolServer.getInstance();
		ClothResultBean querydetail = this.dao.querydetail(clothId, user.getId());
		
		if(querydetail.getClothIcon()!= null) {
			querydetail.setClothDesc(instance.getClientResultBen(querydetail.getClothIcon().getBytes()));
		}
		
		if(querydetail.getUserIcon() != null) {
			querydetail.setUserIcon(instance.getClientResultBen(querydetail.getUserIcon().getBytes()));
		}
		return querydetail;
	}	

}
