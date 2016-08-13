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
	public void insertUser() {
		Clothes c = new Clothes();
		c.setClothIcon("c:/desc/1.png");
		c.setDescription("服装图片");
		c.setCreateTime(System.currentTimeMillis());
		dao.insertCloth(c);
	}
	
	@Test
	public void selectUser() {
		Clothes queryCloth = dao.queryCloth(1l);
		System.out.println(queryCloth.getClothIcon());
	}
	
	@Test
	public void selectClothForPage() {
		List<Clothes> queryForPage = dao.queryForPage(1, 2);
		System.out.println(JSON.toJSONString(queryForPage));
	}
}
