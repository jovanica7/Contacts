package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	//@Value("${test.message:test")
	//private String message = "Test";
	
	@RequestMapping("/hello")
		public String hello() {
	        return "Hello";
	    }
}
