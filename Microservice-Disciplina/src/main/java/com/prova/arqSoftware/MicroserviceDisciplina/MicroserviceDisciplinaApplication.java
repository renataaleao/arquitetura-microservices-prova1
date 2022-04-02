package com.prova.arqSoftware.MicroserviceDisciplina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceDisciplinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDisciplinaApplication.class, args);
	}

}
