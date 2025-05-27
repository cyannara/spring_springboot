package com.yedam.sample.mapper;

import org.apache.ibatis.annotations.Select;

//@Repository
public interface TimeMapper {

	@Select("SELECT sysdate FROM dual")
	public String getTime();

	public String getTime2();

}
