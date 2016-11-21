package com.turkcell.tvplus.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RefreshScope
@RestController
@RequestMapping("/config")
public class ConfigController {
	
	@Value("${message.greeting}")
    String greeting;

    @Value("${server.port}")
    int port;

    @Value("${spring.application.name}")
    String applicationName;
    
    private final RestTemplate restTemplate;
    
    @Autowired
    public ConfigController(RestTemplate restTemplate) {
    	this.restTemplate = restTemplate;
	}
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<String>> getConfigs(){
    	List<String> response = Arrays.asList("message : " + greeting, " port : " + port, " application name : " + applicationName);
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/consume")
    public ResponseEntity<String> consumeRestService(){
    	String response = restTemplate.getForObject("/test", String.class);
    	return new ResponseEntity<String>(response, HttpStatus.OK);
    }
    
    
}
 