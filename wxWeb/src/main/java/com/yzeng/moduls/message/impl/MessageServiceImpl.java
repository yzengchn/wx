package com.yzeng.moduls.message.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yzeng.constans.WxConstans;
import com.yzeng.moduls.message.MessageService;
import com.yzeng.utils.wx.TextMessageUtil;

@Service
public class MessageServiceImpl implements MessageService {

	@Override
	public String msgHandler(Map<String, String> map) {
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String message = "";
		String msgType = map.get("MsgType");
		switch (msgType) {
		case "text":
			message = textMsgHandler(map);
			break;
		case "event":
			message = EventMsgHandler(map);
			break;
		default:
			break;
		}
		return message;
	}
	
	/**
	 * 事件消息处理
	 * @author yzblog.xyz
	 * @date 2018年11月16日 下午12:11:50
	 * @title	EventMsgHandler
	 * @param map
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	private String EventMsgHandler(Map<String, String> map) {
		String ToUserName = map.get("ToUserName");
		String FromUserName = map.get("FromUserName");
		// 获取事件类型
        String event = String.valueOf(map.get("Event"));
        
        // 判断是关注事件或者扫描事件
        if(WxConstans.SUBSCRIBE_EVENT_CODE.equals(event) || WxConstans.SCAN_EVENT_CODE.equals(event)) {
        	return TextMessageUtil.initMessage(FromUserName, ToUserName);
        }
		return "";
	}
	
	/**
	 * 文本消息处理
	 * @author yzblog.xyz
	 * @date 2018年11月16日 下午12:12:09
	 * @title	textMsgHandler
	 * @param map
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	private String textMsgHandler(Map<String, String> map) {
		String ToUserName = map.get("ToUserName");
		String FromUserName = map.get("FromUserName");
		String Content = map.get("Content");
		if("图片".equals(Content)) {
			return TextMessageUtil.initMessage(FromUserName, ToUserName);
		}else {
			return TextMessageUtil.diyMessage(FromUserName, ToUserName, Content);
		}
	}
}
