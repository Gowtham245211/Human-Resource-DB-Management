package com.humanresource.employees.service;

import com.humanresource.employees.dto.JobsDto;
import com.humanresource.employees.entity.Employees;
import com.humanresource.employees.kafka.KafkaConsumer;
import com.humanresource.employees.repository.EmployeesRepository;
import com.humanresource.jobs.entity.Jobs;
import com.humanresource.jobs.repository.JobsRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class EmployeesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeesService.class);

    @Autowired
    private EmployeesRepository employeesRepository;

    /*

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    */
    @Autowired
    private APIClient apiClient;

    @Autowired
    private KafkaConsumer kafkaConsumer;

    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    // @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    public Map<String, Object> getEmployeeJobByEmployeeId(Integer employeeId) {

        Employees employee = employeesRepository.findById(employeeId).get();
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("employee", employee);

                                              /* Using Rest Template */

        /*response.put("job", restTemplate.getForEntity("http://localhost:8086/jobs/getJobByJobId/" + employee.getJob().getJobId()
                        , Jobs.class));*/

                                               /* Using Web Client */

        /*response.put("job", webClient.get()
                .uri("http://localhost:8086/jobs/getJobByJobId/" + employee.getJob().getJobId()))
                .retrieve()
                .bodyToMono(Jobs.class) // The return type should be mentioned here
                .block(); // block is used to make synchronous calls*/

                                             /* Using Open feign Client */

        apiClient.getJobByJobId(employee.getJob().getJobId());
        response.put("job", kafkaConsumer.getJobJson());

        return response;
    }

    public Map<String, Object> getDefaultDepartment(Integer employeeId, Exception exception) {

        LOGGER.info("inside getDefaultDepartment() method");

        Employees employee = employeesRepository.findById(employeeId).get();

        JobsDto job = new JobsDto();
        job.setJobId(20);
        job.setJobTitle("Plumber");
        job.setMinSalary(3000.0);
        job.setMaxSalary(12000.0);

        Map<String, Object> apiResponseDto = new LinkedHashMap<>();
        apiResponseDto.put("employee", employee);
        apiResponseDto.put("job", job);
        return apiResponseDto;
    }
}
