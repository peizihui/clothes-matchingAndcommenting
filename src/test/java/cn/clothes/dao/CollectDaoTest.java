package cn.clothes.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.clothes.entity.Collect;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CollectDaoTest {
	@Resource
	private CollectDao dao;
	
	@Test
	public void insertCollect() {
		Collect collect = new Collect();
		collect.setCollectTime(System.currentTimeMillis());
		collect.setCollectId(1l);
		collect.setUserId(2L);
		this.dao.insertCollect(collect);
	}
	
	@Test
	public void queryCollect() {
		List<Collect> queryCollectForPage = this.dao.queryCollectForPage(2l, 0, 2);
		System.out.println(JSON.toJSONString(queryCollectForPage));
	}
	
	@Test
	public void cacelCollect() {
		this.dao.deleteCollect(1l);
	}
}
