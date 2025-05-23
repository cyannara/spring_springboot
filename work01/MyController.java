package com.yedam.message;

public class MyController {
	
	private MessageService service;
	
	// constructor 
	public MyController() { }   
	public MyController(MessageService  service) {  // DI
		this.service = service;
	}
	
	// setter method
	public void setService(MessageService service) {  // DI
		this.service = service;
	}
	
	public boolean processMessage(String msg, String rec) {
		return this.service.sendMessage(msg, rec);
	}
	
}
