package com.yzeng.moduls.message.handler;

import java.util.Map;

import com.yzeng.constans.WxConstans;
import com.yzeng.utils.wx.TextMessageUtil;

public class EventMsgHandler implements MsgHandler{

	@Override
	public String genMsg(Map<String, String> map) {
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

}
