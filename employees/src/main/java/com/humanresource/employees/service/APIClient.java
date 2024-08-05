package com.humanresource.employees.service;

import com.humanresource.jobs.entity.Jobs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// @FeignClient(url = "http://localhost:8086/jobs", value = "JOBS")
@FeignClient(name = "JOBS")
public interface APIClient {

    @GetMapping("/api/getJobByJobId/{jobId}")
    Jobs getJobByJobId(@PathVariable("jobId") Integer jobId);
}
