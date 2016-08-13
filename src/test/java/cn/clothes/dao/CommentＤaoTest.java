package cn.clothes.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.clothes.entity.Comment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CommentＤaoTest {
	@Resource
	private CommentDao dao;
	
	@Test
	public void insertComment(){
		Comment comment = new Comment();
		comment.setContent("asdfa萨嘎懂法守法");
		comment.setCreateTime(System.currentTimeMillis());
		comment.setFromId(12l);
		comment.setTopicId(2l);
		comment.setTopicType(1);
		this.dao.insertComment(comment);
	}
	
	@Test
	public void queryForPage() {
		List<Comment> queryCommentForPage = this.dao.queryCommentForPage(2l, 0, 2);
		System.out.println(JSON.toJSONString(queryCommentForPage));
	}
	
	@Test
	public void queryCommnet() {
		List<Comment> queryComment = this.dao.queryComment(2l);
		System.out.println(JSON.toJSONString(queryComment));
	}
	
	@Test
	public void queryCountByuserId() {
		int queryCountByClothId = this.dao.queryCountByClothId(2l);
		System.out.println(queryCountByClothId);
	}
	
	@Test
	public void deleteByUserId() {
		int deleteCommentByUserId = this.dao.deleteCommentByUserId(1l);
		System.out.println(deleteCommentByUserId);
	}
	
	@Test
	public void deleteById() {
		int deleteComment = this.dao.deleteComment(5l);
		System.out.println(deleteComment);
	}
}
