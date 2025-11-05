package com.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper {
	List<Employee> selectall();
	Map selectone(int id);
}
