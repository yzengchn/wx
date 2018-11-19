package com.yzeng.entity;

import java.util.List;

/**
 *  微信菜单
 * @author  yzblog.xyz
 * @version  [1.0, 2018年11月19日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
public class Menu {
	/**
	 * 一级菜单数组，个数应为1~3个
	 */
	private List<Button> button;

	public List<Button> getButton() {
		return button;
	}

	public void setButton(List<Button> button) {
		this.button = button;
	}
}
