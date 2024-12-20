package com.alpstack.jobapi.controller;

import com.alpstack.jobapi.model.JobPost;
import com.alpstack.jobapi.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://localhost:3000")

public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("jobs")
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("jobs/{jobId}")
    public JobPost getJob(@PathVariable("jobId") int jobId) {
        System.out.println("Received" + jobId);
        return jobService.getJob(jobId);
    }

    @PostMapping("jobs")
    public JobPost addJob(@RequestBody JobPost job) {
        return jobService.addJob(job);
    }

    @PutMapping("jobs")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobs/{jobId}")
    public String deleteJob(@PathVariable int jobId) {
        jobService.deleteJob(jobId);
        return "Deleted";
    }

    @GetMapping("seed")
    public String seedData() {
        jobService.load();
        return "Seeded!";
    }
}
