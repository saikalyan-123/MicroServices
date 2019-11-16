package com.google.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/maps")
public class GoogleMapsController {
	
	@Autowired
	private GoogleBean googleBean = null;
	@Autowired
	private Environment environment = null;
	
	
	@GetMapping("config")
	public ResponseEntity<GoogleBean> loadConfigDeatails()
	{
		System.out.println("***********Google Map Service port "+environment.getProperty("local.server.port"));
		return new ResponseEntity<GoogleBean>(googleBean,HttpStatus.OK);
		
	}
	
	
	
	
	
	

}
