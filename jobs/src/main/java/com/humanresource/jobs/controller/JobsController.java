package com.humanresource.jobs.controller;

import com.humanresource.jobs.entity.Jobs;
import com.humanresource.jobs.kafka.KafkaProducer;
import com.humanresource.jobs.service.JobsService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JobsController {

    @Autowired
    private JobsService jobsService;

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/getJobByJobId/{jobId}")
    public ResponseEntity<String> getJobByJobId(@PathVariable("jobId") Integer jobId) {

        JSONObject json = new JSONObject();
        kafkaProducer.sendMessage(jobsService.getJobByJobId(jobId));
        // return new ResponseEntity<>(jobsService.getJobByJobId(jobId), HttpStatus.OK);
        return new ResponseEntity<>("Json Message sent to kafka topic", HttpStatus.OK);
    }
}
