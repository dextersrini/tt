package com.lessons.tt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication //Master configuration for enabling SpringBootApplication
@EnableSwagger2 //Enable Swagger version 2
@EnableScheduling //Enable Scheduling across app
public class TtApplication {

	public static void main(String[] args) {
		SpringApplication.run(TtApplication.class, args);
	}

	/**
	 * Given below is the Docket configuration for swagger APIs
	 */
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.lessons.tt")).build();
	}

	/**
	 * Given below is the Global CORS Configuration
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				//add global entries per API as given below
				//registry.addMapping("/products").allowedOrigins("http://localhost:8080");
			}
		};
	}

	/**
	 * Example of scheduling a fixed delayed task.
	 */
	@Scheduled(initialDelay = 10000, fixedDelay = 10000)
	public void greetEveryTenSecs() {
		System.out.println("Hello there");
	}
}
