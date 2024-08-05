package com.humanresource.jobs.service;

import com.humanresource.jobs.dto.JobsDto;
import com.humanresource.jobs.entity.Jobs;
import com.humanresource.jobs.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobsService {

    @Autowired
    private JobsRepository jobsRepository;

    public Jobs getJobByJobId(Integer jobId) {

        Jobs job = jobsRepository.findById(jobId).get();

        /*JobsDto jobsDto = new JobsDto();
        jobsDto.setJobId(job.getJobId());
        jobsDto.setJobTitle(job.getJobTitle());
        jobsDto.setMinSalary(job.getMinSalary());
        jobsDto.setMaxSalary(job.getMaxSalary());*/

        return job;
    }
}
