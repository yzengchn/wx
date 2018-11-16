package com.yzeng.entity;

/**
 * 消息基础类
 * @author  yzblog.xyz
 * @version  [1.0, 2018年11月16日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
public class BaseMessage {
	/**
	 * 开发者微信号
	 */
	protected String ToUserName;
	/**
	 * 发送方帐号（一个OpenID）
	 */
	protected String FromUserName;
	/**
	 * 消息创建时间 （整型）
	 */
	protected long CreateTime;
	/**
	 * 消息类型
	 */
	protected String MsgType;
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

}
