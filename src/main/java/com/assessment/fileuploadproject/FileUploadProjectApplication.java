package com.assessment.fileuploadproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan("com.assessment")
public class FileUploadProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadProjectApplication.class, args);
	}

}
