package com.google.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("location-service")
public class SampleBean {
	
	
	private String Greet;
	private String Result;
	public String getGreet() {
		return Greet;
	}
	public void setGreet(String greet) {
		Greet = greet;
	}
	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
	

}
