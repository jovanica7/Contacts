package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Value("${test.message:test")
	private String message = "Test";
	
	@RequestMapping("/test")
	public String test(Map<String, Object> model){
		model.put("message",  this.message);
		return("Test");
	}
}
