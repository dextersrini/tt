package com.lessons.tt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class TtApplication {

	public static void main(String[] args) {
		SpringApplication.run(TtApplication.class, args);
	}

}
