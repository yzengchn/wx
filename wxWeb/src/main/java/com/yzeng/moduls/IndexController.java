package com.yzeng.moduls;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzeng.constans.WxConstans;
import com.yzeng.moduls.message.MessageService;
import com.yzeng.moduls.wxapi.WxApiService;
import com.yzeng.utils.http.ServletResponseUtil;
import com.yzeng.utils.redis.RedisUtil;
import com.yzeng.utils.wx.MessageUtil;
import com.yzeng.utils.wx.SignUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Controller
public class IndexController {
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	@Resource
	private RedisUtil redisUtil;
	@Resource
	private MessageService msgService;
	@Autowired
	private WxApiService wxApiService;

	@RequestMapping(value = "checkwx", method = RequestMethod.GET)
	public void indexGet(HttpServletRequest request, HttpServletResponse response) {
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			log.info("验证成功!");

			ServletResponseUtil.print(echostr, response);
		}
	}

	@RequestMapping(value="checkwx",method=RequestMethod.POST)
	public void indexPost(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		//将微信请求xml转为map格式，获取所需的参数
		Map<String,String> map = MessageUtil.xmlToMap(request);
	
		String message = msgService.msgHandler(map);
		
		ServletResponseUtil.print(message, response);
	}
	
	
	@RequestMapping(value="index")
	@ResponseBody
	public String getTest() {
		return wxApiService.getAccessToken();
	}
	
	@ApiOperation(value = "用户注册", notes = "根据User对象创建用户")
	@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(String username, String password) {
		redisUtil.set("test.set", "sdadsdsa大大", 8);
		String object = (String) redisUtil.get("test.set");
		System.out.println(object);
		System.out.println("appid" + WxConstans.APP_ID);
		return "index";
	}
}
