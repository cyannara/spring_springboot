package com.yedam.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {

	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		model.addAttribute("exception", ex);
		log.error(model);
		return "error500";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handler404(Exception ex, Model model) {
		model.addAttribute("exception", ex);
		log.error(model);
		return "error404";
	}
}
