package com.yzeng.moduls.message.handler;

import java.util.HashMap;
import java.util.Map;

public class MsgHandlerFactory {
	private static MsgHandlerFactory factory = new MsgHandlerFactory();
	
	private MsgHandlerFactory() {}
	
	private static Map<String,Object> msgHandlerMap = new HashMap<>();
	
	static {
		msgHandlerMap.put("text", new TextMsgHandler());
		msgHandlerMap.put("event", new EventMsgHandler());
	}
	
	public MsgHandler creator(String type) {
		return (MsgHandler) msgHandlerMap.get(type);
	}
	
	public static MsgHandlerFactory getInstance() {
		return factory;
	}
}
