package cn.clothes.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.clothes.entity.Reply;
import edu.emory.mathcs.backport.java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ReplyDaoTest {
	@Resource
	private ReplyDao dao;
	
	@Test
	public void insertReply(){
		Reply reply = new Reply();
		reply.setCommentId(1l);
		reply.setContent("asdfa啊打发法啊");
		reply.setCreateTime(System.currentTimeMillis());
		reply.setFromUid(2L);
		reply.setReplyId(1L);
		reply.setReplyType(2);
		reply.setToUid(1l);
		this.dao.insertReply(reply);
	}
	
	@Test
	public void queryReplyByCommentId() {
		List<Reply> queryReplyByCommentId = this.dao.queryReplyByCommentId(1l, 0, 1);
		System.out.println(JSON.toJSONString(queryReplyByCommentId));
	}
	
	@Test
	public void queryReplyByReplyId() {
		List<Reply> queryReplyByReplyId = this.dao.queryReplyByReplyId(1l, 0, 1);
		System.out.println(JSON.toJSONString(queryReplyByReplyId));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void deleteReply(){
		List<Long> list = new ArrayList<>();
		list.add(1l);
		list.add(2l);
		this.dao.deleteReplyById(list);
	}
	
	@Test
	public void deleteByUserId() {
		this.dao.deleteReplyByUserId(1l);
	}
}
