package com.yzeng.moduls.message;

import java.util.Map;

/**
 * 微信消息处理，主要为用户输入及用户点击菜单事件消息
 * @author  yzblog.xyz
 * @version  [1.0, 2018年11月16日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
public interface MessageService {
	/**
	 * 微信消息事件处理中心
	 * @author yzblog.xyz
	 * @date 2018年11月16日 上午10:12:25
	 * @title	
	 * @param map
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	String msgHandler(Map<String,String> map);

}
