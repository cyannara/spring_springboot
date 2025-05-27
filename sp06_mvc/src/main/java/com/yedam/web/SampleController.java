package com.yedam.web;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class SampleController {


	@PostMapping("/file")
	public String file(@RequestPart("file") MultipartFile file) throws IllegalStateException, IOException {
		System.out.println(file.getSize());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		file.transferTo(new File("c:/upload",file.getOriginalFilename()));
		System.out.println();
		return "home";
	}
}
