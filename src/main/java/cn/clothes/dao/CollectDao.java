package cn.clothes.dao;

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
}
