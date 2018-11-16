package com.yzeng.moduls.wxapi.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yzeng.constans.WxConstans;
import com.yzeng.moduls.wxapi.WxApiService;
import com.yzeng.utils.http.HttpConnect;
import com.yzeng.utils.redis.RedisUtil;

@Service
public class WxApiServiceImpl implements WxApiService{
	private static final Logger log = LoggerFactory.getLogger(WxApiServiceImpl.class);

	@Autowired
	private RedisUtil redisUtil;
	
	@Override
	public String getAccessToken() {
		String accessToken = "";
		accessToken = (String) redisUtil.get(WxConstans.ACCESS_TOKEN);
		
		//为空就调API生成
		if(StringUtils.isEmpty(accessToken)) {
			// 公众平台的API调用所需的access_token
			String url = WxConstans.ACCESS_TOKEN_URL.replace("APPID",WxConstans.APP_ID).replace("APPSECRET", WxConstans.APP_SECRET);
			String result = HttpConnect.getInstance().doGetStr(url);
			
			if(StringUtils.isEmpty(result)) {
				log.error("调用access_token失败！");
			}
			
			JSONObject json = JSON.parseObject(result);
			
			if(!StringUtils.isEmpty(json.get("errcode"))) {
				log.error("获取access_token失败！");
			}
			
			accessToken = (String) json.get("access_token");
			
			redisUtil.set(WxConstans.ACCESS_TOKEN, accessToken, 60*60*2);
		}
		
		return accessToken;
	}

}
