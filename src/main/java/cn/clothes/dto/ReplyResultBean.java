package cn.clothes.dto;

import java.io.Serializable;

import cn.clothes.entity.Reply;

public class ReplyResultBean extends BaseBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Reply reply;

	public Reply getReply() {
		return reply;
	}
	
	public void setReply(Reply reply) {
		this.reply = reply;
	}
}
