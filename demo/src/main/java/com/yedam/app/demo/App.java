package com.yedam.app.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!!!!" );
        Board board = new Board();
        board.setName("ttt");
        System.out.println(board.getName());
        ApplicationContext context = new ClassPathXmlApplicationContext("com/yedam/app/demo/test.xml");
    }
}
