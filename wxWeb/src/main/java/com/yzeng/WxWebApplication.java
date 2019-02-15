package com.yzeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
//@EnableDiscoveryClient
//@EnableFeignClients(basePackages = "xyz.yzblog.weather.client")
public class WxWebApplication extends SpringBootServletInitializer {

	/*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WxWebApplication.class);
    }*/
	
	public static void main(String[] args) {
		SpringApplication.run(WxWebApplication.class, args);
	}
}
