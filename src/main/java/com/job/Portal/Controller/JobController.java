package com.job.Portal.Controller;

import com.job.Portal.Dto.JobDto;
import com.job.Portal.Entity.Job;
import com.job.Portal.Service.JobService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")    //contains url
@AllArgsConstructor
public class JobController {
    private final JobService jobService;

    @PostMapping
    //Take the JSON sent by the client and convert it into a Job object.
    public JobDto createJob(@Valid @RequestBody JobDto jobDto) {
        return jobService.createJob(jobDto);
    }

    @GetMapping
    public List<JobDto> getAllJob() {
        return jobService.getAllJob();
    }

    @GetMapping("/{id}")
    //pathvariable -> used to take value from url
    public JobDto getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);   //no return as nothing is returning
    }
    //delete dosent need a dto

    @PutMapping("/{id}")
    public JobDto updateJob(@PathVariable Long id,@Valid @RequestBody JobDto jobDto) {
        return jobService.updateJob(id, jobDto);
    }

    @GetMapping("/search")
    public List<JobDto> searchJobs(@RequestParam("keyword") String keyword) {
        return jobService.searchJobs(keyword);
    }

    @GetMapping("/search/location")
    public List<JobDto> searchLocation(@RequestParam("location") String location) {
        return jobService.searchLocation(location);
    }

    @GetMapping("/search/company")
    public List<JobDto> searchJobsByCompany(@RequestParam("company") String company) {
        return jobService.searchJobsByCompany(company);
    }

    @GetMapping
    public Page<JobDto> getAllJobs(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return jobService.getAllJobs(page, size);
    }
}
