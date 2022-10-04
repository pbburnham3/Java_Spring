package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping("/")
	public String index(@RequestParam(value="q", required=false) String searchQuery) {
		if(searchQuery == null) {
			return "why you lookin up NOTHIN'";
		} else {
			return "Yo why you lookin up: " + searchQuery;
		}
	}

}
