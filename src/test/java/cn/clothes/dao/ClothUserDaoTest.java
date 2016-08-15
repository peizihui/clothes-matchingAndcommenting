package cn.clothes.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.clothes.entity.ClothUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ClothUserDaoTest {
	@Resource
	private ClothUserDao dao;
	
	@Test
	public void insertClothUser() {
		ClothUser clothUser = new ClothUser();
		clothUser.setClothId(1l);
		clothUser.setUserId(2L);
		this.dao.insertClothUser(clothUser);
	}
	
	@Test
	public void deleteClothUser() {
		this.dao.deleteClothUserByClothId(1L);
	}
	
	@Test
	public void deleteClothUserByUserId() {
		this.dao.deleteClothUserByUserId(2l);
	}
}
