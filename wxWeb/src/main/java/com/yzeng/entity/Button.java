package com.yzeng.entity;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信菜单按钮(一级按钮)
 * 
 * @author yzblog.xyz
 * @version [1.0, 2018年11月19日]
 * @Email yzengchn@163.com
 * @since [产品/模块版本]
 */
public class Button {
	@JSONField(serialize = false)
	private String id;
	/**
	 * 按钮名称
	 */
	private String name;
	/**
	 * 类型：click点击推事件  view跳转URL,view表示网页类型，click表示点击类型	
	 */
	private String type;
	/**
	 * 菜单KEY值，用于消息接口推送
	 */
	private String key;
	/**
	 * 二级菜单数组，个数应为1~5个
	 */
	private List<Sub_button> sub_button;
	
	public Button() {
		super();
	}

	public Button(String id, String name, String type, String key) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.key = key;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<Sub_button> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<Sub_button> sub_button) {
		this.sub_button = sub_button;
	}

}
