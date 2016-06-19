package com.tsfreitas.writeTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by tsfreitas.
 */
@SpringBootApplication
public class WriterApp {

	public static void main(String... args) {
		ConfigurableApplicationContext run = SpringApplication.run(WriterApp.class, args);
		
		run.close();
	}
}
