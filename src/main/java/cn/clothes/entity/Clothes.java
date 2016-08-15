package cn.clothes.entity;

import java.io.Serializable;
/**
 * 服装实体类
 * @author clq
 * 
 */

public class Clothes implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 唯一递增主键id
	 */
	private Long id;
	/**
	 * 服装图标
	 */
	private String clothIcon;
	/**
	 * 图片描述
	 */
	private String description;
	/**
	 * 创建时间
	 */
	private long createTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClothIcon() {
		return clothIcon;
	}
	public void setClothIcon(String clothIcon) {
		this.clothIcon = clothIcon;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
}
