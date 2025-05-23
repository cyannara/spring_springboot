package com.yedam.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("com/yedam/ex01/applicationContext.xml");
    	Restaurant restarurant = (Restaurant)ctx.getBean("restaurant");
		restarurant.getChef().cook();
    }
}
