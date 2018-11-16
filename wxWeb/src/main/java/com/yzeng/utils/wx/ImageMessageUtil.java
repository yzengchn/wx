package com.yzeng.utils.wx;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.XStream;
import com.yzeng.entity.Image;
import com.yzeng.entity.ImageMessage;
import com.yzeng.moduls.wxapi.WxApiService;
/**
 * 图片消息工具类
 * @author  yzblog.xyz
 * @version  [1.0, 2018年11月16日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */ 
@Component
public class ImageMessageUtil{
	@Autowired
	private WxApiService wxApiService;
	
	/**
	 * 将信息转为xml格式
	 */
	public String messageToxml(ImageMessage imageMessage) {
		XStream xtream = new XStream();
		xtream.alias("xml", imageMessage.getClass());
		xtream.alias("Image", new Image().getClass());
		return xtream.toString();
	}
	/**
	 * 封装信息
	 */
	public String initMessage(String FromUserName, String ToUserName) {
		Image image = new Image();
		image.setMediaId(getmediaId());
		ImageMessage message = new ImageMessage();
		message.setFromUserName(ToUserName);
		message.setToUserName(FromUserName);
		message.setCreateTime(new Date().getTime());
		message.setImage(image);
		return messageToxml(message);
	}
	/**
	 * 获取Media
	 * @return
	 */
	public String getmediaId(){
		String path = "f:/1.png";
		String accessToken = wxApiService.getAccessToken();
		String mediaId = null;
		try {
			mediaId = UploadUtil.upload(path, accessToken, "image");
			
		} catch (KeyManagementException | NoSuchAlgorithmException
				| NoSuchProviderException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mediaId;
	}
}
