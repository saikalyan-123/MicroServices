package com.google.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("google-maps-service")
public class GoogleBean {

	private String messeage = null;
	
	private String duty = null;

	public String getMesseage() {
		return messeage;
	}

	public void setMesseage(String messeage) {
		this.messeage = messeage;
	}

	

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

}
