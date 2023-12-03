package com.pepcoding.dsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PepCodingApplication {

	public static void main(String[] args) {
		//SpringApplication.run(PepCodingApplication.class, args);
		//public static void main(String[] args) {
			final String pig = "length: 10";
			final String dog = "length: " + pig.length();
			  
			System.out.println("Animals are equal: " + pig == dog);
			
	}

}
