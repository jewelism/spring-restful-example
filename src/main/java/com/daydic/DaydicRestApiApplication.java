package com.daydic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
public class DaydicRestApiApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DaydicRestApiApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DaydicRestApiApplication.class, args);

	}
}