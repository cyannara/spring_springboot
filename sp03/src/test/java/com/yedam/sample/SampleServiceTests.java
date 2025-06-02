package com.yedam.sample;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.yedam.sample.service.SampleService;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ExtendWith(SpringExtension.class) 
@ContextConfiguration("file:src/main/resources/spring/*-context.xml")
public class SampleServiceTests {

  @Setter(onMethod_ = @Autowired)
  private SampleService service;
  
  
  @Test
  public void testClass() {
    
    log.info(service);
    log.info(service.getClass().getName());    
    
  }
  
  @Test
  public void testAdd() throws Exception {
    
    log.info(service.doAdd("123", "456"));
    
  }
  
  @Test
  public void testAddError() throws Exception {
    
    log.info(service.doAdd("123", "ABC"));
    
  }  


  
}

