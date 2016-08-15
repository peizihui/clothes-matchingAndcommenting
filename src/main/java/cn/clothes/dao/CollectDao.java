package cn.clothes.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.clothes.entity.Collect;

/**
 * 收藏数据库操作类
 * @author clq
 *
 */
@Repository
public interface CollectDao {
	/**
	 * 添加收藏
	 * @param collect
	 * @return
	 */
	int insertCollect(Collect collect);
	
	/**
	 * 取消收藏
	 * @param clothingId
	 * @return
	 */
	int deleteCollect(Long clothingId);
	
	/**
	 * 根据用户id查询出收藏作品
	 * @param userId
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Collect> queryCollectForPage(@Param("userId")Long userId, @Param("offset") int offset, @Param("limit") int limit);
}
