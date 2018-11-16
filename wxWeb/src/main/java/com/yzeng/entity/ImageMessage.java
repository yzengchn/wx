package com.yzeng.entity;

/**
 * 回复图片消息
 * @author  yzblog.xyz
 * @version  [1.0, 2018年11月16日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
public class ImageMessage extends BaseMessage{
	/**
	 * 微信图片
	 */
	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
}
