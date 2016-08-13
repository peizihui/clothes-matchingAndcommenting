package cn.clothes.dao;

import org.springframework.stereotype.Repository;

import cn.clothes.entity.ClothUser;

/**
 * 服装用户关系数据库操作类
 * @author clq
 *
 */
@Repository
public interface ClothUserDao {
	/**
	 * 插入用户服装关系数据
	 * @param clothUser
	 * @return
	 */
	public int insertClothUser(ClothUser clothUser);
	
	/**
	 * 根据用户id进行删除关系表
	 * @param userId
	 * @return
	 */
	public int deleteClothUserByUserId(Long userId);
	
	/**
	 * 根据服装id进行删除关系表
	 * @param userId
	 * @return
	 */
	public int deleteClothUserByClothId(Long userId);
}
