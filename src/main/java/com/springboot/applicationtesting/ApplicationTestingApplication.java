package com.springboot.applicationtesting;

import com.springboot.applicationtesting.services.DataService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationTestingApplication {


//	private DataService dataService;

	public static void main(String[] args) {
		SpringApplication.run(ApplicationTestingApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println(dataService.getData());
//	}

}
