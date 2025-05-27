package com.yedam.ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {

    	ApplicationContext ctx = new AnnotationConfigApplicationContext(Ex03Configure.class);
    	Restaurant restarrant = (Restaurant)ctx.getBean("restaurant");
		//restarurant.getChef().cook();
    }
}
