package cn.clothes.entity;

import java.io.Serializable;

/**
 * 
 * @author clq
 * 点赞实体类
 */
public class Like implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 关联服装主键id
	 */
	private Long clothingId;
	/**
	 * 点赞时间
	 */
	private Long likeTime;
	/**
	 * 点赞用户id
	 */
	private Long userId;
	/**
	 * 点赞状态，1：点赞，2：取消
	 */
	private Integer status;
	
	public enum LikeStatus{
		add(1),//点赞
		cacel(2);//取消
		
		public int value;
		private LikeStatus(Integer value) {
			this.value = value;
		}
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getClothingId() {
		return clothingId;
	}
	public void setClothingId(Long clothingId) {
		this.clothingId = clothingId;
	}
	public Long getLikeTime() {
		return likeTime;
	}
	public void setLikeTime(Long likeTime) {
		this.likeTime = likeTime;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
