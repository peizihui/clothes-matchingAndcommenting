package cn.clothes.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.clothes.dao.ClothUserDao;
import cn.clothes.dao.CommentDao;
import cn.clothes.dao.ReplyDao;
import cn.clothes.dto.CommentResultBean;
import cn.clothes.entity.ClothUser;
import cn.clothes.entity.Comment;
import cn.clothes.entity.Reply;
import cn.clothes.entity.User;
import cn.clothes.page.Pagination;
import cn.clothes.service.CommentService;
import cn.clothes.util.BdbHtmlPoolServer;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private ReplyDao replyDao;
	@Autowired
	private ClothUserDao clothUserDao;
	
	@Override
	public Pagination queryComment(Long clothId, Integer type,Integer pageNumber, Integer pageSize) {
		List<CommentResultBean> list = new ArrayList<>();
		List<Comment> commentList = this.commentDao.queryCommentForPage
				(clothId, type, pageNumber, pageSize);
		int totalCount = this.commentDao.queryCountByClothId(clothId,type);
		BdbHtmlPoolServer instance = BdbHtmlPoolServer.getInstance();
		
		for(Comment c : commentList) {
			String user_icon = instance.getClientResultBen(c.getUserIcon().getBytes());
			c.setUserIcon(user_icon);
			CommentResultBean bean = new CommentResultBean();
			bean.setComment(c);
			
			List<Reply> replyByCommentId = replyDao.queryReplyByCommentId(c.getTopicId(), 0, 5);
			if(!replyByCommentId.isEmpty()) {
				bean.setReplyList(replyByCommentId);
			}
			
			int countByCommentId = this.replyDao.queryCountByCommentId(c.getTopicId());
			if(countByCommentId > 5) {
				bean.setHasMoreReply(true);
			}else {
				bean.setHasMoreReply(false);
			}
			list.add(bean);
		}
		return new Pagination(pageNumber, pageSize, totalCount, commentList);
	}

	@Override
	public void Comment(Long clothId,String content, User user) {
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setCreateTime(System.currentTimeMillis());
		comment.setFromId(user.getId());
		comment.setTopicId(clothId);
		comment.setTopicType(1);
		this.commentDao.insertComment(comment);
		ClothUser clothUser = new ClothUser();
		clothUser.setClothId(clothId);
		clothUser.setUserId(user.getId());
		this.clothUserDao.insertClothUser(clothUser);
	}

	@Override
	public void reply(Long commentId, Long toUserId, String content, User user) {
		Reply reply = new Reply();
		reply.setCommentId(commentId);
		reply.setReplyId(commentId);
		reply.setContent(content);
		reply.setCreateTime(System.currentTimeMillis());
		reply.setFromUid(user.getId());
		reply.setToUid(toUserId);
		this.replyDao.insertReply(reply);
	}

}
