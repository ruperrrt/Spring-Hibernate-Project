package com.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	// @initBinder: pre-process all web requests coming into our Controller
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, ste);
	}
	
	// a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm(Model myModel) {	// model is used to pass data between controller & views
		
		// create a customer object and add customer object to the model 
		
		myModel.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
						@Valid @ModelAttribute("customer") Customer theCustomer,
						BindingResult theBindingResult) {
		
		// log input data
		System.out.println("DEBUG:" + theCustomer.getFirstName() + " " + theCustomer.getLastName());
		System.out.println("Binding result" + theBindingResult);
		if(theBindingResult.hasErrors())
			return "customer-form";
		else
			return "customer-confirmation";
	}
}
