package com.eshop.ms;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.eshop.ms.security.JwTokenGenerator;

@SpringBootApplication
public class MsEshopApplication implements CommandLineRunner{
	
	@Autowired
	private JwTokenGenerator generator;
	
	
	public static void main(String[] args) {
		SpringApplication.run(MsEshopApplication.class, args);
		
		System.out.println("Eshop application started!");
	}

	@Override
	public void run(String... args)throws Exception{
		
		//String token = generator.generateToken("Blondine", Arrays.asList("ADMIN"));
		
		//System.out.println("Token " + token);
		
		
		
	}
}
