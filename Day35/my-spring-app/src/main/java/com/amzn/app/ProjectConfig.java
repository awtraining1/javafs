package com.amzn.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


import com.amzn.beans.Farmer;

@ComponentScan({"com.amzn.beans"})
@Configuration
public class ProjectConfig {
	
	@Bean
	public Farmer abc() {
		return new Farmer("Partha", 34);
	}
	
	@Bean
	public Farmer abc2() {
		return new Farmer("Keerti", 64);
	}	
	
	@Bean("Sujata33Farmer")
	public Farmer abc3() {
		return new Farmer("Sujata", 33);
	}
	
	@Primary // Only one bean per class type(Farmer) is allowed 
	@Bean("Ali93Farmer")
	public Farmer farmer4() {
		return new Farmer("Ali", 93);
	}

}

// 35A - Create Apple class and then Apple instance using Sp FW context 
