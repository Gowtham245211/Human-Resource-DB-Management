package com.humanresource.employees.kafka;

import com.humanresource.employees.dto.JobsDto;
import com.humanresource.jobs.entity.Jobs;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private Jobs job;

    @KafkaListener(topics="job_json", groupId = "jobs")
    public void listen(Jobs job){
        System.out.println(job);
        this.job = job;
    }

    public Jobs getJobJson (){
        return job;
    }
}
