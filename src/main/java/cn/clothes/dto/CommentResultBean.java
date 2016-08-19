package cn.clothes.dto;

import java.io.Serializable;
import java.util.List;

import cn.clothes.entity.Comment;
import cn.clothes.entity.Reply;

public class CommentResultBean extends BaseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 评论内容
	 */
	private Comment comment;
	
	/**
	 * 回复消息内容
	 */
	private List<Reply> replyList;

	/**
	 * 是否有更多的回复消息
	 */
	private boolean hasMoreReply;

	public Comment getComment() {
		return comment;
	}
	
	public List<Reply> getReplyList() {
		return replyList;
	}

	public boolean isHasMoreReply() {
		return hasMoreReply;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public void setHasMoreReply(boolean hasMoreReply) {
		this.hasMoreReply = hasMoreReply;
	}

	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}
	
}
