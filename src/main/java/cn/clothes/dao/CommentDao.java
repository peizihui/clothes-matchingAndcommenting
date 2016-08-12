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
	List<Comment> queryCommentForPage(@Param("offset") int offset, @Param("limit") int limit);
}
