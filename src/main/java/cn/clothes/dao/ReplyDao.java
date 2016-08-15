package cn.clothes.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.clothes.entity.Reply;

@Repository
public interface ReplyDao {
	/**
	 * 插入一条评论
	 * @param reply
	 */
	public void insertReply(Reply reply);
	
	/**
	 * 根据评论id查询出回复信息
	 * @param id
	 * @return
	 */
	public List<Reply> queryReplyByCommentId(@Param("commentId")Long id, @Param("offset") int offset, @Param("limit") int limit);
	
	/**
	 * 根据回复信息id查询出回复信息
	 * @param replyId
	 * @return
	 */
	public List<Reply> queryReplyByReplyId(@Param("replyId")Long replyId, @Param("offset") int offset, @Param("limit") int limit);
	
	/**
	 * 根据回复id删除回复信息
	 * @param id
	 * @return
	 */
	public int deleteReplyById(@Param("id")List<Long> id);
	
	/**
	 * 根据回复id删除回复信息
	 * @param id
	 * @return
	 */
	public int deleteReplyByUserId(Long userId);
}
