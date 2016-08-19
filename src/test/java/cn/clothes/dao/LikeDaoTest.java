package cn.clothes.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.clothes.entity.Like;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class LikeDaoTest {
	@Resource
	private LikeDao dao;
	
	@Test
	public void insertLike() {
		Like like = new Like();
		like.setClothingId(1l);
		like.setLikeTime(System.currentTimeMillis());
		like.setStatus(Like.LikeStatus.add.value);
		like.setUserId(1L);
		this.dao.insertLike(like);
	}
	
	@Test
	public void queryCountByClothId() {
		int queryAllLikeByCloth = this.dao.queryAllLikeByCloth(1L,1);
		System.out.println(queryAllLikeByCloth);
	}
	
	@Test
	public void upadateLikeStatus() {
		this.dao.updateLikeStatus(2l, Like.LikeStatus.cancel.value);
	}
}
