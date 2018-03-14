package com.jk;


import com.jk.test.GenerateQRCode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import static com.jk.test.GenerateQRCode.generateQRCode;
import static com.jk.test.GenerateQRCode.parseQRCode;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignDemoApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(FeignDemoApplication.class, args);
	}

	/**
	 * 支持jsp需要重写此方法
	 * @param builder
	 * @return
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}




}
