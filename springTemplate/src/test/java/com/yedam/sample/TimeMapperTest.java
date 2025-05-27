package com.yedam.sample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.yedam.sample.mapper.TimeMapper;

import lombok.Setter;

@ExtendWith(SpringExtension.class) 
@ContextConfiguration("file:src/main/resources/spring/*-context.xml")
public class TimeMapperTest {

	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		System.out.println(timeMapper.getClass().getName());
		System.out.println(timeMapper.getTime());
	}
}
