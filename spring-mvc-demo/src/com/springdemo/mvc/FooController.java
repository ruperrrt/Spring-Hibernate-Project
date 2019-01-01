package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FooController {
	
	// a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String displayTheForm() {
		return "silly";
	}
	
	
	
}
