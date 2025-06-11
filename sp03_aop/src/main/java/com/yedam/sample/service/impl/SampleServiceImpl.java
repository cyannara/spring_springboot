package com.yedam.sample.service.impl;

import org.springframework.stereotype.Service;

import com.yedam.sample.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService {

	@Override
	public Integer doAdd(String str1, String str2) throws Exception {

		return Integer.parseInt(str1) + Integer.parseInt(str2);

	}

}


