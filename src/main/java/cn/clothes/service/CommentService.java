package cn.clothes.service;

import cn.clothes.dto.CommentResultBean;
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
	public void reply(Long commentId, Long toUserId, String content, User user);
}
