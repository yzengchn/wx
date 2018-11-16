package com.yzeng.constans;

import com.yzeng.utils.comm.PropertiesLoader;

/**
 * 微信常量
 * @author  yzblog.xyz
 * @version  [1.0, 2018年11月16日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
public class WxConstans {
	/**
	 * 获取access_token接口调用
	 */
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	/**
	 * 新增临时素材URL 媒体文件在微信后台保存时间为3天，即3天后media_id失效。
	 */
	public static final String TEMP_UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	
	/**
	 *  ACCESS_TOKEN 
	 */
	public static final String ACCESS_TOKEN = "ACCESS_TOKEN";
	
	
	/**
	 * 关注事件code
	 */
	public static final String SUBSCRIBE_EVENT_CODE = "subscribe";
	/**
	 * 取消关注事件code
	 */
	public static final String UNSUBSCRIBE_EVENT_CODE = "unsubscribe";
	/**
	 * 扫描事件code
	 */
	public static final String SCAN_EVENT_CODE = "SCAN";
	
	
	
	
	
	
	
	public static final String APP_ID = PropertiesLoader.getKey(SysConstans.WX_CONFIG_FILE, "AppID");
    
    public static final String APP_SECRET = PropertiesLoader.getKey(SysConstans.WX_CONFIG_FILE, "AppSecret");
    
    public static final String TOKEN = PropertiesLoader.getKey(SysConstans.WX_CONFIG_FILE, "Token");
    
    public static final String ENCODING_AES_KEY = PropertiesLoader.getKey(SysConstans.WX_CONFIG_FILE, "EncodingAESKey");
    
    public static final String WX_CHECK_URL = PropertiesLoader.getKey(SysConstans.WX_CONFIG_FILE, "WxCheckUrl");
}
