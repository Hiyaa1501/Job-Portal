package com.job.Portal.Repository;

import com.job.Portal.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
    // queries written automatically here
}
