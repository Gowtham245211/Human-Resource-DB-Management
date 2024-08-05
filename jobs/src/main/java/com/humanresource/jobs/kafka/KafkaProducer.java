package com.humanresource.jobs.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.humanresource.jobs.dto.JobsDto;
import com.humanresource.jobs.entity.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Jobs> kafkaTemplate;

    private static final String TOPIC = "job_json";

    public void sendMessage(Jobs job) {
        kafkaTemplate.send(TOPIC, job);
    }


    /*
     CompletableFuture<SendResult<String, JobsDto>> future = kafkaTemplate.send("job_json", job);

     Message<Jobs> message = MessageBuilder
            .withPayload(job)
            .setHeader(KafkaHeaders.TOPIC, "job_json")
            .build();

        kafkaTemplate.send(message);*/
    /*

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String TOPIC = "job_json";

    public void sendMessage(Jobs job) {
        try {
            String jobJson = objectMapper.writeValueAsString(job);
            kafkaTemplate.send(TOPIC, jobJson);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    */
}
