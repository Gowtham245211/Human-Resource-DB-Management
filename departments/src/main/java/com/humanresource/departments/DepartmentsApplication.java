package com.humanresource.departments;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.humanresource.departments.entity", "com.humanresource.locations.entity",
		"com.humanresource.countries.entity"})
@OpenAPIDefinition(
		info = @Info(
				title = "Departments microservice documentation",
				description = "Used to manage departments of the employees"
		)
)
public class DepartmentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentsApplication.class, args);
	}
}
