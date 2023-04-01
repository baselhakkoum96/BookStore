package com.example.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.bookstore.controller.UserDetailService;


//import com.example.bookstore.controller.UserDetailService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
	
	private UserDetailService userDetailService;
	
    public WebSecurityConfiguration(UserDetailService userDetailService) {
		super();
		this.userDetailService = userDetailService;
	}
    
    
    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/CSS/**").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.defaultSuccessUrl("/booklist")
				.permitAll()
			)
			.logout((logout) -> logout
					.logoutSuccessUrl("/login")
					.permitAll());

		return http.build();
	}
	/*protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests()
            .requestMatchers("/login").permitAll()
            .and()
        .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/booklist",true)
            .permitAll()
            .and()
        .logout()
        	.logoutSuccessUrl("/login")
            .permitAll();
        
    }*/
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
    } 
}