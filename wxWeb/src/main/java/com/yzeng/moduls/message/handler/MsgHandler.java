package com.yzeng.moduls.message.handler;

import java.util.Map;

/**
 * 组装不同种类的消息
 * 用来判断消息类型，使之生成对应的消息xml 如文本类型则生成text类型XML返回 
 * @author  <a href="http://www.yzblog.xyz">yzblog</a>
 * @version  [1.0, 2019年2月15日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
public interface MsgHandler {
	String genMsg(Map<String,String> map);
}
