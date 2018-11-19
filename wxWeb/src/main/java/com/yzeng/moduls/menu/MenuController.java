package com.yzeng.moduls.menu;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzeng.entity.MenuVo;
import com.yzeng.moduls.menu.service.MenuService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Controller
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@ApiOperation(value = "获得所有可用菜单", notes = "查询所有的在激活状态的菜单")
	@ApiImplicitParam(name = "无", value = "")
	@RequestMapping(value="menu",method=RequestMethod.GET)
	@ResponseBody
	public String getMenu(){
		String flag = "fail";
		if(menuService.createWxMenu()) {
			flag = "success";
		}
		return flag;
	}
}
