package com.connection.MongoDB.restService;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.connection.MongoDB.restService.controller","com.connection.MongoDB.restService.service"})
public class RestServiceApplication 
{
	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
		
	}
}