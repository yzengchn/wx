package com.yzeng.moduls.menu.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yzeng.constans.WxConstans;
import com.yzeng.entity.Button;
import com.yzeng.entity.Menu;
import com.yzeng.entity.MenuVo;
import com.yzeng.entity.Sub_button;
import com.yzeng.mapper.menu.MenuMapper;
import com.yzeng.moduls.menu.service.MenuService;
import com.yzeng.moduls.wxapi.WxApiService;
import com.yzeng.utils.http.HttpConnect;
import com.yzeng.utils.wx.AuthPageUtils;

@Service
public class MenuServiceImpl implements MenuService{
	
	private static final Logger log = LoggerFactory.getLogger(MenuServiceImpl.class);
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Resource
	private WxApiService wxApiService;
	
	@Override
	public List<MenuVo> getAllMenu() {
		return menuMapper.getAllMenu();
	}

	@Override
	public boolean createWxMenu() {
		String url = WxConstans.MENU_CREATE.replace(WxConstans.ACCESS_TOKEN, wxApiService.getAccessToken());
		String result = HttpConnect.getInstance().doPostStr(url, menuData2Json());
		if(StringUtils.isEmpty(result)) {
			log.error("创建菜单请求返回为空");
			return false;
		}
		JSONObject json = JSON.parseObject(result);
		if(json.getInteger(WxConstans.RESP_ERRCODE) == 0) {
			log.info("微信菜单创建成功");
			return true;
		}
		
		log.error("创建菜单失败：{}",json.get(WxConstans.RESP_ERRMSG));
		return false;
	}
	
	/**
	 * 将菜单组装并转为Json字符串
	 * @author yzblog.xyz
	 * @date 2018年11月19日 下午2:24:44
	 * @title	menuData2Json
	 * @return JsonString
	 * @see [类、类#方法、类#成员]
	 */
	private String menuData2Json() {
		List<MenuVo> allMenu = menuMapper.getAllMenu();
		Menu menu = new Menu();
        List<Button> btns = new ArrayList<Button>();
        for(int i=0; i<allMenu.size(); i++) {
        	MenuVo menuVo = allMenu.get(i);
        	//组装一级菜单
        	if(menuVo.getIsParent() == 1) {
        		Button button = new Button(menuVo.getId(), menuVo.getName(), menuVo.getType(), menuVo.getKey());
        		btns.add(button);
        		allMenu.remove(i);
        		i--;
        	}
        }
        //遍历一级菜单
        for (Button btn : btns) {
        	List<Sub_button> subButtons = new ArrayList<Sub_button>();
        	//遍历二级菜单
        	for (MenuVo menuVo : allMenu) {
        		//二级菜单的父菜单ID等于当前一级菜单ID，就组装到当前一级菜单下
    			if(menuVo.getpId().equals(btn.getId())) {
    				Sub_button sub_button = new Sub_button(menuVo.getName(), menuVo.getType(), menuVo.getKey());
    				//如果为view类型菜单，则组装URL(即URL不为空的情况)
    				if(!StringUtils.isEmpty(menuVo.getUrl())) {
    					//是否需要微信网页授权
    					sub_button.setUrl(menuVo.getNeedAuth() == 1 ? AuthPageUtils.getAuthPageUrl(menuVo.getUrl()) : menuVo.getUrl());
    				}
    				
    				subButtons.add(sub_button);
    			}
    		}
        	
        	btn.setSub_button(subButtons);
		}
        
        menu.setButton(btns);
        	
        return JSON.toJSONString(menu);
	}

}
