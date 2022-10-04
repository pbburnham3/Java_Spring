package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/root")
public class HomeController {
	@RequestMapping("/greeting")
	public String index() {
		return "Hello World";
	}
	
	@RequestMapping("/world")
	public String world() {
		return "ayyyy lmao this ez";
	}
	
	@RequestMapping("/cuh")
	public String cuh() {
		return "ay cuh";
	}

}
