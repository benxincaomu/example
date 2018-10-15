package org.sft.sample;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleApplication {
	private static final Logger log=LogManager.getLogger(SampleApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
		log.info("Application  started");
	}
}
