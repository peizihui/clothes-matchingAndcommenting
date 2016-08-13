package cn.clothes.dto;

import java.io.Serializable;

public class ClothResultBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 服装主键id
	 */
	private Long clothId;

	/**
	 * 服装图片
	 */
	private String clothIcon;

	/**
	 * 服装描述
	 */
	private String clothDesc;

	/**
	 * 点赞数量
	 */
	private Integer likeCount;

	/**
	 * 评论数量
	 */
	private Integer commentCount;

	public String getClothDesc() {
		return clothDesc;
	}

	public String getClothIcon() {
		return clothIcon;
	}

	public Long getClothId() {
		return clothId;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setClothDesc(String clothDesc) {
		this.clothDesc = clothDesc;
	}
	
	public void setClothIcon(String clothIcon) {
		this.clothIcon = clothIcon;
	}
	
	public void setClothId(Long clothId) {
		this.clothId = clothId;
	}
	
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	
	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}
}
