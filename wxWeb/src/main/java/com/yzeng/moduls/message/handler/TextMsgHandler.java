package com.yzeng.moduls.message.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.yzeng.utils.wx.ImageMessageUtil;
import com.yzeng.utils.wx.TextMessageUtil;

public class TextMsgHandler implements MsgHandler{

	@Autowired
	private ImageMessageUtil imageMessageUtil; 

	
	@Override
	public String genMsg(Map<String, String> map) {
		String ToUserName = map.get("ToUserName");
		String FromUserName = map.get("FromUserName");
		String Content = map.get("Content");
		if("图片".equals(Content)) {
			return imageMessageUtil.initMessage(FromUserName, ToUserName);
		}else {
			return TextMessageUtil.diyMessage(FromUserName, ToUserName, Content);
		}
	}

}
