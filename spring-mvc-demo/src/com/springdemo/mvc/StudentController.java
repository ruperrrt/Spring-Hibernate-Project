package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	// a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm(Model myModel) {	// model is used to pass data between controller & views
		
		// create a student object and add student object to the model 
		
		myModel.addAttribute("student", new Student());
		
		return "student-form";
	}
	
	// a controller method to process the form
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		// log input data
		System.out.println("DEBUG:" + theStudent.getFirstName() + " " + theStudent.getLastName());
		
		return "student-confirmation";
	}
	
	
}
