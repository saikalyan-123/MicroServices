package com.google.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/locations")
public class locationserviceController {
	
	@Autowired
	public SampleBean sampleBean = null;
	
	@Autowired
	public GooglewithSampleFeignProxy feignproxy = null;
	
	
	@GetMapping("/config")
	public ResponseEntity<SampleBean> loadConfig()
	{
		return new ResponseEntity<SampleBean>(sampleBean,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/maps/config")
	public ResponseEntity<GooglewithSampleBean> loadall()
	{
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<GooglewithSampleBean> restEntity = restTemplate.getForEntity("http://localhost:9002/maps/config", GooglewithSampleBean.class);
		 GooglewithSampleBean allinfo = restEntity.getBody();
		 allinfo.setGreet(sampleBean.getGreet());
		 allinfo.setResult(sampleBean.getResult());
		 
		
		return new ResponseEntity<GooglewithSampleBean>(allinfo,HttpStatus.OK);
	}
	
	
	@GetMapping("/maps/config/feign-client")
	public ResponseEntity<GooglewithSampleBean> getall()
	{
		ResponseEntity<GooglewithSampleBean> restEntity =  feignproxy.getAll();
		
		GooglewithSampleBean allinfo = restEntity.getBody();
		allinfo.setGreet(sampleBean.getGreet());
		allinfo.setResult(sampleBean.getResult());
		return new ResponseEntity<GooglewithSampleBean>(allinfo,HttpStatus.OK);
		
	}
	

}
