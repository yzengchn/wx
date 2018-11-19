package com.yzeng.utils.wx;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.yzeng.constans.WxConstans;

/**
 * 微信网页授权工具类
 * @author  yzblog.xyz
 * @version  [1.0, 2018年11月19日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
public class AuthPageUtils {
	/**
	 * 网页授权回调域名,以snsapi_base为scope发起的网页授权，是用来获取进入页面的用户的openid的，并且是静默授权并自动跳转到回调页的。用户感知的就是直接进入了回调页
	 * @author yzblog.xyz
	 * @date 2018年11月19日 下午3:22:12
	 * @title	
	 * @param httpsUrl
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static String getAuthPageUrl(String httpsUrl)
    {
        StringBuilder authUrl = new StringBuilder();
        authUrl.append("https://open.weixin.qq.com/connect/oauth2/authorize?appid=");
        authUrl.append(WxConstans.APP_ID);
        authUrl.append("&redirect_uri=");
        try
        {
            authUrl.append(URLEncoder.encode(httpsUrl, "UTF-8"));
        }
        catch (UnsupportedEncodingException e)
        {
        }
        authUrl.append("&response_type=code&scope=snsapi_base&state=yzblog#wechat_redirect");
        return authUrl.toString();
    }
}
