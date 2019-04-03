package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	// show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "hellworld-form";
	}
	
	// Process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// new controller method to read data
	// add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// read the request param from the HTML form
		String theName = request.getParameter("studentName");
		// convert data to upper case
		theName = theName.toUpperCase();
		// create the message
		String result = "Hey! " + theName;
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	// using special annotation for @requestParam
	@RequestMapping("/processFormVersionThree")
	public String processFromVersionThree(@RequestParam("studentName") String theName, Model model) {

		// convert data to upper case
		theName = theName.toUpperCase();
		// create the message
		String result = "Hey! " + theName;
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
}
