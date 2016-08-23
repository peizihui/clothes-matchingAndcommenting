package cn.clothes.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.clothes.entity.Comment;
/**
 * 评论数据库操作类
 * @author clq
 *
 */
@Repository
public interface CommentDao {
	/**
	 * 插入评论
	 * @param comment
	 * @return
	 */
	int insertComment(Comment comment);
	
	/**
	 * 分页查询评论信息
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Comment> queryCommentForPage(@Param("topicId")Long topicId, @Param("type")Integer type, @Param("offset") int offset, @Param("limit") int limit);
	
	/**
	 * 根据主题查询评论信息
	 * @param topicId
	 * @return
	 */
	List<Comment> queryComment(Long topicId);
	
	/**
	 * 删除评论信息
	 * @param id
	 * @return
	 */
	int deleteComment(Long id);
	
	/**
	 * 通过用户id进行删除
	 * @param id
	 * @return
	 */
	int deleteCommentByUserId(Long userId);
	
	/**
	 * 根据主题查询出评论总量
	 * @param topicId
	 * @return
	 */
	int queryCountByClothId(@Param("topicId")Long topicId, @Param("type")int type);
}
