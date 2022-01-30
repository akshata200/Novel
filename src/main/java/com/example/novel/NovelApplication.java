package com.example.novel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NovelApplication {

	public static void main(String[] args) {
		System.out.println("Application starting");
		SpringApplication.run(NovelApplication.class, args);
	}

}
