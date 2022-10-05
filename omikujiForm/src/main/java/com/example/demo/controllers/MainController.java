package com.example.demo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
 
	@RequestMapping("/")
	public String index() {
     
    	return "index.jsp";
	}
	
	@RequestMapping("/submit")
	public String submit(
			@RequestParam(value="numberInput") String numberInput,
			@RequestParam(value="cityInput") String cityInput,
			@RequestParam(value="personInput") String personInput,
			@RequestParam(value="professionInput") String professionInput,
			@RequestParam(value="livingInput") String livingInput,
			@RequestParam(value="niceInput") String niceInput,
			HttpSession session
			) {
		session.setAttribute("numberInput", numberInput);
		session.setAttribute("cityInput", cityInput);
		session.setAttribute("personInput", personInput);
		session.setAttribute("professionInput", professionInput);
		session.setAttribute("livingInput", livingInput);
		session.setAttribute("niceInput", niceInput);
		return "redirect:/result";
	}
	
	@RequestMapping("/result")
	public String result() {
		return "omikuji.jsp";
	}
}