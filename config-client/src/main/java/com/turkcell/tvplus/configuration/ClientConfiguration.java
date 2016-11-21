package com.turkcell.tvplus.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@RefreshScope
@Configuration
public class ClientConfiguration {
	
	@Value("${resttemplate.root.URI}")
	private String rootURI;
	
	@Value("${resttemplate.connection.timeout}")
	private int connectTimeout;
	
	@Value("${resttemplate.read.timeout}")
	private int readTimeout;

	@Bean
	@RefreshScope
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		RestTemplate restTemplate = restTemplateBuilder
				.rootUri(rootURI)
				.setConnectTimeout(connectTimeout)
				.setReadTimeout(readTimeout)
				.build();
		return restTemplate;
	}

}
