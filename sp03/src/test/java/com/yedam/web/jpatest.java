package com.yedam.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/resources/spring/datasource-context.xml",
	                   "classpath:/spring/jpa-context.xml"})
public class jpatest {

    @PersistenceContext
    private EntityManager em;
	
    @Test
    public void test() {
    	System.out.println(em);
    	//em.find(User.class, em)
    }
}
