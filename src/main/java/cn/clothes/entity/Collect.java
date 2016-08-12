package cn.clothes.entity;

import java.io.Serializable;
/**
 * 收藏实体类
 * @author clq
 *
 */
public class Collect implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	/**
	 * 收藏作品id
	 */
	private Long collectId;
	/**
	 * 收藏用户id
	 */
	private Long userId;
	/**
	 * 收藏时间
	 */
	private Long collectTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCollectId() {
		return collectId;
	}
	public void setCollectId(Long collectId) {
		this.collectId = collectId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCollectTime() {
		return collectTime;
	}
	public void setCollectTime(Long collectTime) {
		this.collectTime = collectTime;
	}
	

}
