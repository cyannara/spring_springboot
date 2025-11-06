package com.yedam.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "com.yedam.app" })
public class RootConfig {
	/*
	 * @Bean public Chef chef() { return new Chef(); }
	 * 
	 * @Bean public Restaurant restaurant() { return new Restaurant(chef()); }
	 */
	
}
