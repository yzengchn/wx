package com.yzeng.utils.wx;

import java.util.Date;

import com.thoughtworks.xstream.XStream;
import com.yzeng.constans.LinkConstans;
import com.yzeng.constans.WxConstans;
import com.yzeng.entity.TextMessage;

/**
 * 文本消息工具类
 * 
 * @author yzblog.xyz
 * @version [1.0, 2018年11月16日]
 * @Email yzengchn@163.com
 * @since [产品/模块版本]
 */
public class TextMessageUtil {
	/**
	 * 将发送消息封装成对应的xml格式
	 */
	public static String messageToxml(TextMessage message) {
		XStream xstream = new XStream();
		xstream.alias("xml", message.getClass());
		return xstream.toXML(message);
	}

	/**
	 * 封装发送消息对象,封装时，需要将调换发送者和接收者的关系
	 * 
	 * @param FromUserName
	 * @param ToUserName
	 */
	public static String initMessage(String FromUserName, String ToUserName) {
		TextMessage text = new TextMessage();
		text.setToUserName(FromUserName);
		text.setFromUserName(ToUserName);
		text.setContent(LinkConstans.WELCOME_LANGUAGE);
		text.setCreateTime(new Date().getTime());
		text.setMsgType("text");
		
		return messageToxml(text);
	}
	
	/**
	 * 封装发送消息对象(自定义回复)
	 * @param FromUserName
	 * @param ToUserName
	 */
	public static String diyMessage(String FromUserName, String ToUserName,String content) {
		TextMessage text = new TextMessage();
		
		text.setToUserName(FromUserName);
		text.setFromUserName(ToUserName);
		text.setContent(LinkConstans.WELCOME_LANGUAGE+"\n你输入的内容是:\n"+content);
		text.setCreateTime(new Date().getTime());
		text.setMsgType("text");
		
		return messageToxml(text);
	}
}
