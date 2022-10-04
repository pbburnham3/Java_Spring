package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "Good fortune";
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tenacity is the key";
	}
	
	@RequestMapping("/travel/{city}")
	public String showCity(@PathVariable("city") String city) {
		return "Congratulations, you will soon travel to " + city;
	}
	
	@RequestMapping("/lotto/{num}")
	public String showNum(@PathVariable("num") Integer num) {
		if(num %2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		} else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
		}
	}

}
