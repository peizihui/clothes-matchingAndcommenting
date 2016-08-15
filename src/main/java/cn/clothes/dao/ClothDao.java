package cn.clothes.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.clothes.entity.Clothes;

/**
 * 服装数据库操作类
 * @author clq
 *
 */
@Repository
public interface ClothDao {
	/**
	 * 插入一条数据
	 * @param cloth
	 */
	void insertCloth(Clothes cloth);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int deleteCloth(Long id);
	
	/**
	 * 修改数据
	 * @param id
	 * @return
	 */
	int updateCloth(Clothes cloth);
	
	/**
	 * 根据id查询服装详细信息
	 * @param id
	 * @return
	 */
	Clothes queryCloth(@Param("id") Long id);
	
	/**
	 * 分页查询服装信息
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Clothes> queryForPage(@Param("offset") int offset, @Param("limit") int limit);
}
