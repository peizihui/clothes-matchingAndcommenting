package cn.clothes.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.clothes.entity.Clothes;

public interface ClothService {
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
	int updateCloth(Long id);
	
	/**
	 * 根据id查询服装详细信息
	 * @param id
	 * @return
	 */
	Clothes queryCloth(Long id);
	
	/**
	 * 分页查询服装信息
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Clothes> queryForPage(@Param("offset") int offset, @Param("limit") int limit);
}
