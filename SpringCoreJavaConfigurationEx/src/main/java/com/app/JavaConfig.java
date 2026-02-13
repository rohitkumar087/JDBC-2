package com.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
	
	@Bean
	public Student stdObj() {
		Student ss = new Student();
		ss.setId(101);
		ss.setName("Abhinav");
		return ss;
	}
	
	@Bean
	public Student stdObj2() {
		Student ss = new Student();
		ss.setId(102);
		ss.setName("Rohan");
		return ss;
	}
}
