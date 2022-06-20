package com.alejandrojorba.argprograma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.Collections;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class ArgprogramaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArgprogramaApplication.class, args);
	}

}

