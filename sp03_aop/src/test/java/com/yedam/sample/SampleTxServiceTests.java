package com.yedam.sample;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.yedam.sample.service.SampleTxService;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ExtendWith(SpringExtension.class) 
@ContextConfiguration({"classpath:/spring/*-context.xml"})
public class SampleTxServiceTests {

  @Setter(onMethod_ = { @Autowired })
  private SampleTxService service;

  @Test
  public void testLong() {
    
    String str ="spring AOP test";
    
    log.info(str.getBytes().length +" 글자");
    
    service.addData(str);    
  }
  
  
}


