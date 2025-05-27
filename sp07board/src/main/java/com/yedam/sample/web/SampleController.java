package com.yedam.sample.web;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yedam.sample.service.TimeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@Controller
public class SampleController {
	
    private final TimeService timeService;
	
	@RequestMapping(value = "/sample", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
				
		model.addAttribute("serverTime", timeService.getTime2() );
		
		return "/home";
	}
	
}
