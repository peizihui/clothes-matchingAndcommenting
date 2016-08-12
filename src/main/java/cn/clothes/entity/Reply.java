package cn.clothes.entity;

import java.io.Serializable;

public class Reply implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	/**
	 * 关联评论表主键id
	 */
	private Long commentId;
	/**
	 * 回复目标id
	 */
	private Long replyId;
	/**
	 * 回复类型1:comment 2:reply
	 */
	private Integer replyType;
	/**
	 * 回复内容
	 */
	private String content;
	/**
	 * 回复用户id
	 */
	private Long fromUid;
	/**
	 * 目标用户id
	 */
	private Long toUid;
	/**
	 * 创建时间
	 */
	private Long createTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public Long getReplyId() {
		return replyId;
	}
	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}
	public Integer getReplyType() {
		return replyType;
	}
	public void setReplyType(Integer replyType) {
		this.replyType = replyType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getFromUid() {
		return fromUid;
	}
	public void setFromUid(Long fromUid) {
		this.fromUid = fromUid;
	}
	public Long getToUid() {
		return toUid;
	}
	public void setToUid(Long toUid) {
		this.toUid = toUid;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
}
