package cn.clothes.service;

import cn.clothes.entity.Reply;
import cn.clothes.entity.User;
import cn.clothes.page.Pagination;

public interface CommentService {
	/**
	 * 获取评论信息
	 * @param type
	 * @param clothId
	 * @return
	 */
	public Pagination queryComment(Long clothId, Integer type, Integer pageNumber, Integer pageSize);
	
	/**
	 * 评论服装
	 * @param clothId
	 */
	public void Comment(Long clothId, String content, User user);
	
	/**
	 * 回复评论
	 * @param commentId
	 * @param content
	 * @param user
	 */
	public Reply reply(Long commentId, Long toUserId, String content, User user);
	
	/**
	 * 查询评论
	 * @param clothId
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Pagination queryReply(Long clothId, Integer pageNumber, Integer pageSize);
}
