package com.ni.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
		.and()
		.authorizeRequests().antMatchers("/console/**").permitAll();
		http.csrf().disable(); // POST not working fix
		http.headers().frameOptions().disable(); // H2 console fix

//		http.authorizeHttpRequests()
//		.mvcMatchers("/index.html").permitAll()
//		.mvcMatchers("/h2-console/**").permitAll()
//		.mvcMatchers("/api/farmer/**").permitAll()
//		.mvcMatchers("/jpa/farmers/*").permitAll()
////		.mvcMatchers("/**").permitAll()
////		
////		//.mvcMatchers("/company.html").denyAll()
////		.mvcMatchers("/github/user/*").authenticated()
////		//.mvcMatchers("/home.html").denyAll()
////		.mvcMatchers("/training/actuator/beans").hasRole("EMPLOYEE")
////		.mvcMatchers("/training/actuator/**").hasRole("ADMIN")
//		
//		.and()
//		.formLogin().loginPage("/login").permitAll()
//		.defaultSuccessUrl("/about")
//		.failureUrl("/login?error=true")
//		.and()
//		.logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
//		.and().httpBasic();
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("u1").password("123").roles("USER").and().withUser("u2").password("456")
				.roles("USER", "EMPLOYEE").and().withUser("u3").password("456").roles("EMPLOYEE").and()
				.withUser("admin").password("admin123").roles("ADMIN", "USER").and()
				.passwordEncoder(NoOpPasswordEncoder.getInstance());

	}

}
