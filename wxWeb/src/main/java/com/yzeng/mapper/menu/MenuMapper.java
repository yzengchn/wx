package com.yzeng.mapper.menu;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.yzeng.entity.MenuVo;

@Mapper
public interface MenuMapper {
	
	/**
	 * 查询所有菜单(可用菜单)
	 * @author yzblog.xyz
	 * @date 2018年11月19日 上午11:05:32
	 * @title	getAllMenu
	 * @return MenuVoList
	 * @see [类、类#方法、类#成员]
	 */
	//@Select("select id,`name`,type,`key`,url,isParent,pId,needAuth from w_menu m where m.status=1")
	List<MenuVo> getAllMenu();
}
