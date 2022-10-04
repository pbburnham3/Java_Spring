package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/daikichi")

public class HomeController {
	
	@RequestMapping("")
	public String welcome() {
		return "Welcome!";
	}
	
	@RequestMapping("/today")
	public String today() {
		return "Fur Hao";
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tenacity is the key";
	}

}
