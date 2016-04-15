package com.kyrobot;

import java.security.Principal;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;

@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class DeepdiscoApplication extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests()
			.antMatchers("/", "/login**").permitAll()
			.anyRequest().permitAll()
			.and().logout().logoutSuccessUrl("/").permitAll();
	}
	
	@RequestMapping("/me")
	  public Map<String, String> me(Principal principal) {
		Map<String, String> userDetails = Maps.newHashMap();
		userDetails.put("user", principal.getName());
	    return userDetails;
	  }

	public static void main(String[] args) {
		SpringApplication.run(DeepdiscoApplication.class, args);
	}
}
