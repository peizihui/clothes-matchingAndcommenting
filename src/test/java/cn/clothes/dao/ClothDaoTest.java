package cn.clothes.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.clothes.entity.Clothes;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ClothDaoTest {
	@Resource
	private ClothDao dao;
	
	@Test
	public void insertCloth(){
		Clothes c = new Clothes();
		c.setClothIcon("c:/desc/1.png");
		c.setDescription("服装图片");
		c.setCreateTime(System.currentTimeMillis());
		dao.insertCloth(c);
		System.out.println(c.getId());
	}
	
	@Test
	public void selectClothes() {
		Clothes queryCloth = dao.queryCloth(1L);
		System.out.println(queryCloth);
	}
	
	@Test
	public void queryForPage() {
		List<Clothes> queryForPage = dao.queryForPage(0, 2);
		System.out.println(JSON.toJSONString(queryForPage));
	}
	
	@Test
	public void deleteCloth() {
		int deleteCloth = this.dao.deleteCloth(1l);
		System.out.println(deleteCloth);
	}
	
	@Test
	public void updateCloth() {
		Clothes c = new Clothes();
		c.setId(2l);
		c.setClothIcon("test");
		c.setCreateTime(System.currentTimeMillis());
		c.setDescription("test");
		this.dao.updateCloth(c);
	}
}
