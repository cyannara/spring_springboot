package com.yedam.app.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.app.sample.service.TimeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SampleController {

	private final TimeService timeService;
	
	@GetMapping("/")
	@ResponseBody
	public String getTime() {
		return timeService.getTime();
	}
	
	@GetMapping("/uploadForm")
	public String uploadForm() {
		return "uploadForm";
	}
	
	@PostMapping("/uploadFormAction")
	public String uploadFormAction(@RequestPart("uploadFile") MultipartFile uploadFile) {
		System.out.println(uploadFile.getSize());
		System.out.println(uploadFile.getOriginalFilename());
		return "uploadForm";
	}
	
	
}
