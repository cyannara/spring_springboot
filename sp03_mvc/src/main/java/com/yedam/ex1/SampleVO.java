package com.yedam.ex1;

import java.util.List;

import lombok.Data;

@Data
public class SampleVO {
	private String name;
	private int age;
	
	private List<String> hobby;
}
