package com.yzeng.moduls.menu.service;

import java.util.List;

import com.yzeng.entity.MenuVo;

/**
 * 微信菜单
 * @author  yzblog.xyz
 * @version  [1.0, 2018年11月19日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
public interface MenuService {
	
	List<MenuVo> getAllMenu();
	/**
	 * 创建微信菜单
	 * @author yzblog.xyz
	 * @date 2018年11月19日 下午2:12:47
	 * @title 	createWxMenu
	 * @return 是否创建成功
	 * @see [类、类#方法、类#成员]
	 */
	boolean createWxMenu();
}
