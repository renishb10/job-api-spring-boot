package com.alpstack.jobapi.service;

import com.alpstack.jobapi.model.JobPost;
import com.alpstack.jobapi.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepo;

    public List<JobPost> getAllJobs() {
        return jobRepo.getAllJobs();
    }

    public JobPost getJob(int jobId) {
        return jobRepo.getJob(jobId);
    }

    public JobPost addJob(JobPost job) {
        return jobRepo.addJob(job);
    }

    public void updateJob(JobPost job) {
        jobRepo.updateJob(job);
    }

    public void deleteJob(int jobId) {
        jobRepo.deleteJob(jobId);
    }
}
