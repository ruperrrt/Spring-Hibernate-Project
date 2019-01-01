package com.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")	// add parent mapping to resolve ambiguity
public class HelloWorldController {
	
	
	// a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "show-form";
	}
	
	
	// a controller method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	
	// another controller method to convert all data to uppercase
	// add data to model
	@RequestMapping("/processFormTwo")
	public String allCapital(HttpServletRequest request, Model model) {
		// read request from HTML form
		String theName = request.getParameter("studentName");
		
		// convert data to all caps
		theName = theName.toUpperCase();
		
		String res = "Yo! " + theName;
		
		// add message to model
		model.addAttribute("message", res);
		
		
		
		return "helloworld";
		
	}	
	
	
	// another way to do exactly same thing as above
	@RequestMapping("/processFormThree")
	public String allCapitalThree(@RequestParam("studentName") 
							String theName, Model model) {
		
		// convert data to all caps
		theName = theName.toUpperCase();
		
		String res = "Hey! " + theName;
		
		// add message to model
		model.addAttribute("message", res);
		
		
		
		return "helloworld";
		
	}
}
