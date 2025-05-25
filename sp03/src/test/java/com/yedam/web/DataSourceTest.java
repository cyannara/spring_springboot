package com.yedam.web;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/resources/spring/datasource-context.xml", "classpath:/spring/mybatis-context.xml"})
public class DataSourceTest {

	@Setter(onMethod_ = {@Autowired})
	private DataSource dataSource;
	
	@Setter(onMethod_ = {@Autowired})
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection() {
		try(Connection con = dataSource.getConnection()) {
			System.out.println(con);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testMybatis() {
		try(SqlSession session = sqlSessionFactory.openSession(); Connection con = session.getConnection();){
			System.out.println(session);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
