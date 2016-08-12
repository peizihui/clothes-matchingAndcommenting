package cn.clothes.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.clothes.entity.Reply;

/**
 * 回复数据库操作类
 * @author clq
 *
 */
public interface ReplyDao {
	/**
	 * 插入回复评论信息
	 * @param reply
	 * @return
	 */
	public int insertReply(Reply reply);
	
	/**
	 * 批量删除回复信息
	 * @param id
	 * @return
	 */
	public int deleteReply(List<Long> id);
	
	/**
	 * 分页查询回复信息
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<Reply> queryReplyForPage(@Param("offset") int offset, @Param("limit") int limit);
}
