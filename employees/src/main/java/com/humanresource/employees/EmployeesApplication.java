package com.humanresource.employees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EntityScan(basePackages = {
		"com.humanresource.departments.entity",
		"com.humanresource.locations.entity",
		"com.humanresource.countries.entity",
		"com.humanresource.jobs.entity",
		"com.humanresource.employees.entity"
})
@EnableFeignClients
public class EmployeesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesApplication.class, args);
	}

	/*@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}*/

	/*@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}*/
}
