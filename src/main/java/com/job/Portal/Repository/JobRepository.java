package com.job.Portal.Repository;

import com.job.Portal.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    // queries written automatically here
    List<Job> findByTitleContainingIgnoreCase(String keyword);

    List<Job> findByLocationContainingIgnoreCase(String location);

    List<Job> findByCompanyContainingIgnoreCase(String company);

    List<Job> findBySalaryBetween(long minSalary, long maxSalary);
    //not used
}
