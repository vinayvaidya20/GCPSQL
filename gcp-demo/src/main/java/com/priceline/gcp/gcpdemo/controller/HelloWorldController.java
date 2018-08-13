package com.priceline.gcp.gcpdemo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/{name}")
	public String getGreeting(@PathVariable String name) {
		return "Hello, "+name;
	}

}
