package com.ssafy.kpc;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableBatchProcessing
@SpringBootApplication
public class KpcApplication {

	public static void main(String[] args) {
		SpringApplication.run(KpcApplication.class, args);
	}

}
