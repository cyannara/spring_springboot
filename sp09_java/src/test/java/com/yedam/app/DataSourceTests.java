package com.yedam.app;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.yedam.app.config.DataSourceConfig;
import com.yedam.app.config.MybatisConfig;
import com.yedam.app.config.RootConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringJUnitConfig({ RootConfig.class, DataSourceConfig.class, MybatisConfig.class })
public class DataSourceTests {

	@Setter(onMethod_ = { @Autowired })
	private DataSource dataSource;

	@Setter(onMethod_ = { @Autowired })
	private SqlSessionFactory sqlSessionFactory;

	@Test
	public void testMyBatis() {

		try (SqlSession session = sqlSessionFactory.openSession(); Connection con = session.getConnection();) {

			log.info(session);

		} catch (Exception e) {
			fail(e.getMessage());
		}

	}

	// @Test
	public void testConnection() {

		try (Connection con = dataSource.getConnection()) {

			log.info(con);

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
