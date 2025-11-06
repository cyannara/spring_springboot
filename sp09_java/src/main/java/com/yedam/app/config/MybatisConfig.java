package com.yedam.app.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "com.yedam.**.mapper")
public class MybatisConfig {
	
	@Autowired DataSource dataSource;
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		
		//dataSource
		sqlSessionFactoryBean.setDataSource(dataSource);
		
		//MapperLocation
		Resource[] resources = new PathMatchingResourcePatternResolver()
	            .getResources("classpath:/mappers/**/*.xml");
		sqlSessionFactoryBean.setMapperLocations(resources);
		
		//configLocation
		Resource configresource = new PathMatchingResourcePatternResolver()
	            .getResource("classpath:/sql-map-config.xml");
		sqlSessionFactoryBean.setConfigLocation(configresource);
		
		return sqlSessionFactoryBean.getObject();
	}
}
