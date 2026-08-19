package com.job.Portal.Controller;

import com.job.Portal.Dto.JobDto;
import com.job.Portal.Entity.Job;
import com.job.Portal.Service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")    //contains url
@AllArgsConstructor
public class JobController {
    private final JobService jobService;

    @PostMapping
    //Take the JSON sent by the client and convert it into a Job object.
    public JobDto createJob(@RequestBody JobDto jobDto) {
        return jobService.createJob(jobDto);
    }

    @GetMapping
    public List<Job> getAllJob() {
        return jobService.getAllJob();
    }

    @GetMapping("/{id}")
    //pathvariable -> used to take value from url
    public Job getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);   //no return as nothing is returning
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Long id, @RequestBody Job job) {
        return jobService.updateJob(id, job);
    }
}
