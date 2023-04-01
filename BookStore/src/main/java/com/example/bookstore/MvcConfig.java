package com.example.bookstore;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/booklist").setViewName("booklist");
		registry.addViewController("/").setViewName("booklist");
		registry.addViewController("/addbook").setViewName("addbook");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/editbook").setViewName("editbook");
	}

}