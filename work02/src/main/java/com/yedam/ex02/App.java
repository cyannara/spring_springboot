package com.yedam.ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {

    	ApplicationContext ctx = new AnnotationConfigApplicationContext(Ex02Configure.class);
    	Restaurant restarurant = (Restaurant)ctx.getBean("restaurant");
		restarurant.getChef().cook();
    }
}
