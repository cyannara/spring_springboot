package com.yedam.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

//@Repository
public interface TimeMapper {

	@Select("SELECT sysdate FROM dual")
	public String getTime();

	public String getTime2();

}
