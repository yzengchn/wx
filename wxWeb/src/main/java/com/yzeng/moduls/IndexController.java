package com.yzeng.moduls;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Controller
public class IndexController {
	
	@Resource
	private RedisTemplate redisTemplate;
	
	@ApiOperation(value="用户注册", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(String username,String password) {
		String object = redisTemplate.opsForValue().get("weather").toString();
		System.out.println(object);
		return "index";
	}
}
