package cn.clothes.entity;

import java.io.Serializable;

public class Comment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	/**
	 * 评论主题id
	 */
	private Long topicId;
	
	/**
	 * 评论类型
	 */
	private Integer topicType;
	
	/**
	 * 评论内容
	 */
	private String content;
	
	/**
	 * 评论用户id
	 */
	private Long fromId;
	
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

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public Integer getTopicType() {
		return topicType;
	}

	public void setTopicType(Integer topicType) {
		this.topicType = topicType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getFromId() {
		return fromId;
	}

	public void setFromId(Long fromId) {
		this.fromId = fromId;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
}
