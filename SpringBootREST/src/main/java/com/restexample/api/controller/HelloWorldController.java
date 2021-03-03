/**
 * 
 */
package com.restexample.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.restexample.api.model.HelloWorld;

/**
 * @author virajd
 *
 */
@RestController
public class HelloWorldController {
	
	@GetMapping(path="/helloWorld")
	public HelloWorld HelloWorld() {
		return new HelloWorld("Hello World");
	}
	
	@GetMapping(path="/helloWorld/{name}")
	public HelloWorld HelloWorld(@PathVariable String name) {
		return new HelloWorld("Hello "+name);
	}

}
