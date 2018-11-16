package com.yzeng.moduls.wxapi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.yzeng.constans.WxConstans;
import com.yzeng.moduls.wxapi.WxApiService;
import com.yzeng.utils.redis.RedisUtil;

public class WxApiServiceImpl implements WxApiService{

	@Autowired
	private RedisUtil redisUtil;
	
	@Override
	public String getAccessToken() {
		String accessToken = "";
		accessToken = (String) redisUtil.get(WxConstans.ACCESS_TOKEN);
		
		//为空就调API生成
		if(StringUtils.isEmpty(accessToken)) {
			// 公众平台的API调用所需的access_token
			String url = WxConstans.GET_ACCESS_TOKEN.replaceAll("", "");
		}
		
		return accessToken;
	}

}
