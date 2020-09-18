package com.au.usyd.brooks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showPage() {
		//not the complete name because we already set prefix and suffix
		return "mainMenu";
	}
}
