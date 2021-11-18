package com.com619.group6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Application entry class.
 * 
 * @author WhitearL
 *
 */
@ComponentScan("com.com619.group6")
@EnableSwagger2
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class PortappbApplication {

	/**
	 * Entry point.
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(PortappbApplication.class, args);
	}

}
