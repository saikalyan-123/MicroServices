package com.google.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="google-maps-service")
@RibbonClient(name="google-maps-service")
public interface GooglewithSampleFeignProxy {

	@GetMapping("maps/config")
	public abstract ResponseEntity<GooglewithSampleBean> getAll();
	
}
