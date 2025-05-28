package com.yedam.sample;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@TestInstance(Lifecycle.PER_CLASS)
@Log4j2
@WebAppConfiguration
@ExtendWith(SpringExtension.class) 
@ContextConfiguration({"file:src/main/resources/spring/*-context.xml",
	                   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class SampleControllerTest {

	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;
	
	private static MockMvc mockMvc;
	
	@BeforeAll
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	@Test
	public void testGetTime() throws Exception {
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/sample"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
			//	.get("serverTime")
			);
	}
}
