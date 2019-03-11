package com.spring.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	@Value("${provider.servicename1}")
	private String servicename1;
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/consumer")
	public String getUserById(){
	    System.out.println("-----------hello test--------------"+servicename1);
		return this.restTemplate.getForObject("http://"+servicename1+"/hello", String.class);
	}
   @GetMapping("/hello")
    public String hello(){
        System.out.println("I am spring cloud consumer");
        return "hello,I am spring cloud consumer.";
    }
}
