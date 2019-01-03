package com.springdemo.mvc.customvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstrainstValidator 
	implements ConstraintValidator<CourseCode, String>{
	
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}
	
	@Override
	public boolean isValid(String theCode, 
							ConstraintValidatorContext theConstraintValidatorContext) {
		
		return theCode == null ? true : theCode.startsWith(coursePrefix);
		
	}

}
