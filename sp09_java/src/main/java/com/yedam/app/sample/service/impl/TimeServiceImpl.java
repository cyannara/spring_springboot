package com.yedam.app.sample.service.impl;

import org.springframework.stereotype.Service;

import com.yedam.app.sample.mapper.TimeMapper;
import com.yedam.app.sample.service.TimeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TimeServiceImpl implements TimeService{

	private final TimeMapper timeMapper;
	
	@Override
	public String getTime() {
		return timeMapper.getTime();
	}

}
