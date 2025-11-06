package com.yedam.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.yedam.app.config.DataSourceConfig;
import com.yedam.app.config.MybatisConfig;
import com.yedam.app.config.RootConfig;
import com.yedam.app.sample.service.TimeService;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringJUnitConfig({ RootConfig.class, DataSourceConfig.class, MybatisConfig.class })
public class SampleServiceTest {

	@Setter(onMethod_ = @Autowired)
	private TimeService timeService;
	
	@Test
	public void testGetTime() {
		log.info(timeService.getTime());
	}
}
