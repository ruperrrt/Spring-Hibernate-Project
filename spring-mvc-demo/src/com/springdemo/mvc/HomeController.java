package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller		// inherited from component
public class HomeController {
	
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
}
