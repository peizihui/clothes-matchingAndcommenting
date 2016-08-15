package cn.clothes.entity;

import java.io.Serializable;

/**
 * 用户服装关系实体类
 * @author clq
 *
 */
public class ClothUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 唯一递增主键
	 */
	private Long id;
	/**
	 * 关联服装id
	 */
	private Long clothId;
	/**
	 * 用户id
	 */
	private Long userId;
	public Long getClothId() {
		return clothId;
	}
	public Long getId() {
		return id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setClothId(Long clothId) {
		this.clothId = clothId;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
