package com.yzeng.entity;

public class Sub_button {
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
	 * 网页 链接，用户点击菜单可打开链接，不超过1024字节(只有type为view时才有值)
	 */
	private String url;

	
	
	public Sub_button() {
		super();
	}

	public Sub_button(String name, String type, String key) {
		super();
		this.name = name;
		this.type = type;
		this.key = key;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
