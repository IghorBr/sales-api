package com.example.sales.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.sales.services.impl.DBServiceImpl;

@Configuration
@Profile("dev")
public class DBConfig {

	@Autowired private DBServiceImpl dbService;
	
	@Bean
	public boolean instantiateDatabase() {
		
		dbService.instantiateDevDatabase();
		return true;
	}
}
