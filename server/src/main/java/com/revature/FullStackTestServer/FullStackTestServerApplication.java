package com.revature.FullStackTestServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "com.revature.FullStackTestServer.beans")
public class FullStackTestServerApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FullStackTestServerApplication.class, args);
	}

}
