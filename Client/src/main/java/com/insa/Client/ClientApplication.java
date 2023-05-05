package com.insa.Client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@SpringBootApplication
public class ClientApplication {

	@RequestMapping( "/")
	public RedirectView redirectView(){
		return new RedirectView("/index.html");
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

}
