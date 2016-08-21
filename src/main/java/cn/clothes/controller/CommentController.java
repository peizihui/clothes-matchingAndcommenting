package cn.clothes.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.clothes.entity.User;
import cn.clothes.service.CommentService;
import cn.clothes.util.Constants;
import cn.clothes.util.Log;

/**
 *  评论接口
 * @author clq
 *
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
	
	Log log = Log.getLogger(CommentController.class);
	@Autowired
	private CommentService service;
	
	/**
	 * 查询服装评论
	 * @param pageNumber
	 * @param pageSize
	 * @param clothId
	 * @param type
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/list")
	@ResponseBody
	public Object queryComment(Integer pageNumber, Integer pageSize, Long clothId, Integer type, 
			HttpServletRequest req) {
		Map<String, Object> map = new HashMap<>();
		
		if(pageSize == null) {
			pageSize = 10;
		}
		if(pageNumber == null || clothId == null || type == null) {
			map.put("result", Constants.ABSENCE_NEED_PARAMETER);
			return map;
		}
		
		map.put("result", service.queryComment(clothId, type, pageNumber, pageSize));
		return map;
	}
	
	/**
	 * 插入一条评论
	 * @param clothId
	 * @param content
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/insert")
	@ResponseBody
	public Object comment(Long clothId,String content, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<>();
		if(clothId == null || content == null) {
			map.put("result", Constants.ABSENCE_NEED_PARAMETER);
			return map;
		}
		
		User user = (User) req.getSession().getAttribute("user");
		try{
			this.service.Comment(clothId, content, user);
			map.put("result", "success");
		}catch(Exception e) {
			map.put("result", Constants.SERVER_INTERNAL_ERROR);
			log.error(e);
		}
		return map;
	}
	
	/**
	 * 回复评论
	 * @param commentId
	 * @param toUserId
	 * @param content
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/reply")
	@ResponseBody
	public Object reply(Long commentId, Long toUserId, String content,  HttpServletRequest req) {
		Map<String, Object> map = new HashMap<>();
		
		if(commentId == null || content == null) {
			map.put("result", Constants.ABSENCE_NEED_PARAMETER);
			return map;
		}
		User user = (User) req.getSession().getAttribute("user");
		try{
			this.service.reply(commentId, toUserId, content, user);
			map.put("result", "success");
		}catch(Exception e){
			map.put("result", "fail");
			log.error(e);
		}
		return map;
	}
}
