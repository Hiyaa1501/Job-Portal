package com.job.Portal.Service;

import com.job.Portal.Dto.JobDto;
import com.job.Portal.Entity.Job;
import com.job.Portal.Repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.job.Portal.exception.JobNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class JobService {
    public final JobRepository jobRepository;

    public JobDto createJob(JobDto jobDto) {
//        return jobRepository.save(job);   -> before dto, repository expects a job entity not dto
        Job job = new Job();
        job.setTitle(jobDto.getTitle());
        job.setCompany(jobDto.getCompany());
        job.setLocation(jobDto.getLocation());
        job.setDescription(jobDto.getDescription());
        job.setSalary(jobDto.getSalary());

        // id -> null after saving id = 1
        Job savedJob = jobRepository.save(job);
        //job is saved in db
//        return jobDto;

        JobDto response = new JobDto();
        //dto created from saved entity
        response.setId(savedJob.getId());
        response.setTitle(savedJob.getTitle());
        response.setCompany(savedJob.getCompany());
        response.setLocation(savedJob.getLocation());
        response.setDescription(savedJob.getDescription());
        response.setSalary(savedJob.getSalary());

        return response;
    }

    public List<JobDto> getAllJob() {
        List<Job> jobs = jobRepository.findAll();
        List<JobDto> jobDtos = new ArrayList<>();

        for(Job job : jobs) {
            JobDto jobDto = new JobDto();

            jobDto.setId(job.getId());
            jobDto.setTitle(job.getTitle());
            jobDto.setDescription(job.getDescription());
            jobDto.setCompany(job.getCompany());
            jobDto.setLocation(job.getLocation());
            jobDto.setSalary(job.getSalary());

            jobDtos.add(jobDto);
        }
        return jobDtos;
    }

    public JobDto getJobById(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new JobNotFoundException("Job not found"));
        JobDto jobDto = new JobDto();

        jobDto.setId(job.getId());
        jobDto.setTitle(job.getTitle());
        jobDto.setDescription(job.getDescription());
        jobDto.setCompany(job.getCompany());
        jobDto.setLocation(job.getLocation());
        jobDto.setSalary(job.getSalary());

        return jobDto;
    }

    //void because delete operation doesnt return
    public void deleteJob(Long id) {
        if(!jobRepository.existsById(id)) {
            throw new JobNotFoundException("Job not found with id: " + id);
        }
        jobRepository.deleteById(id);
    }

    public JobDto updateJob(Long id, JobDto updatedJob) {
        Job existingJob = jobRepository.findById(id).orElseThrow(() -> new JobNotFoundException("Job not found with id: " + id));

        existingJob.setCompany(updatedJob.getCompany());
        existingJob.setTitle(updatedJob.getTitle());
        existingJob.setDescription(updatedJob.getDescription());
        existingJob.setSalary(updatedJob.getSalary());
        existingJob.setLocation(updatedJob.getLocation());

        Job savedJob = jobRepository.save(existingJob);

        JobDto responseDto = new JobDto();

        responseDto.setId(savedJob.getId());
        responseDto.setSalary(savedJob.getSalary());
        responseDto.setCompany(savedJob.getCompany());
        responseDto.setTitle(savedJob.getTitle());
        responseDto.setLocation(savedJob.getLocation());
        responseDto.setDescription(savedJob.getDescription());

        return responseDto;
    }
}
