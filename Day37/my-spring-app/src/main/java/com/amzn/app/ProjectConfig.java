package com.amzn.app;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.amzn.beans.Farmer;

@ComponentScan({"com.amzn.beans", "com.amzn.aspects", "com.amzn.spring.dao"})
@Configuration
@EnableAspectJAutoProxy
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
	
//	@Bean
//	DataSource dataSource() {
//		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//			driverManagerDataSource.setUrl("jdbc:h2:mem:testdb;;DB_CLOSE_DELAY=-1;IGNORECASE=TRUE;");
//		driverManagerDataSource.setUsername("sa");
//		driverManagerDataSource.setPassword("password");
//		driverManagerDataSource.setDriverClassName("org.h2.Driver");		
//		
//		return driverManagerDataSource;
//	}
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
			driverManagerDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/amzn");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("rootroot");
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");		
		
		return driverManagerDataSource;
	}

}

// 35A - Create Apple class and then Apple instance using Sp FW context 
