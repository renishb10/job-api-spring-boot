package com.alpstack.jobapi.controller;

import com.alpstack.jobapi.model.JobPost;
import com.alpstack.jobapi.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://localhost:3000")
@RequestMapping("/api")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("jobs")
    public ResponseEntity<List<JobPost>> getAllJobs() {
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }

    @GetMapping("jobs/{jobId}")
    public JobPost getJob(@PathVariable("jobId") int jobId) {
        System.out.println("Received" + jobId);
        return jobService.getJob(jobId);
    }

    @GetMapping("jobs/keyword/{keyword}")
    public List<JobPost> search(@PathVariable("keyword") String keyword) {
        return jobService.search(keyword);
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
