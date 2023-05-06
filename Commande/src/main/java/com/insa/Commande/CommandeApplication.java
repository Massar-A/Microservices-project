package com.insa.Commande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@ServletComponentScan
@SpringBootApplication
public class CommandeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommandeApplication.class, args);
	}

}
