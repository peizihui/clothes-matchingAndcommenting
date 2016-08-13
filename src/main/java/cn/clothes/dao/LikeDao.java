package cn.clothes.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.clothes.entity.Like;
/**
 * 点赞数据库操作接口
 * @author clq
 *
 */
@Repository
public interface LikeDao {
	/**
	 * 插入点赞信息
	 * @param like
	 * @return
	 */
	int insertLike(Like like);
	
	/**
	 * 查询点赞信息
	 * @param clothingId
	 * @param userId
	 * @return
	 */
	Like queryLike(Long clothingId, Long userId);
	
	/**
	 * 根绝用户删除点赞信息
	 * @param userId
	 * @return
	 */
	Integer deleteLike(Long userId);
	
	/**
	 * 根据服装信息删除用户点赞
	 * @param clothingId
	 * @return
	 */
	Integer deleteLikeByCloth(Long clothingId);
	
	/**
	 * 查询某个服装的所有点赞信息
	 * @param clothingId
	 * @return
	 */
	Integer queryAllLikeByCloth(@Param("clothingId")Long clothingId, @Param("status")Integer status);
	
	/**
	 * 修改点赞状态
	 * @param clothingId
	 * @param status
	 */
	void updateLikeStatus(@Param("clothingId")Long clothingId, @Param("status")Integer status);
}
