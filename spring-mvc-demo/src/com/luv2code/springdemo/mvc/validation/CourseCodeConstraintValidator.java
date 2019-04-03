package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
	implements ConstraintValidator<CourseCode, String>{

	//private String coursePrefix;
	private String[] coursePrefixes;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		// TODO Auto-generated method stub
		coursePrefixes = theCourseCode.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext ) {
		
		// is extra course prefix?
boolean result = false;
		
		if (theCode != null) {
			
			//result = theCode.startsWith(coursePrefix);

			// loop thru course prefixes
			//
			// check to see if code matches any of the course prefixes
			//
			for (String tempPrefix : coursePrefixes) {
				result = theCode.startsWith(tempPrefix);
				
				// if we found a match then break out of the loop
				if (result) {
					break;
				}
			}
		}
		else {
			result = true;
		}
		
		return result;
	}

	
}
