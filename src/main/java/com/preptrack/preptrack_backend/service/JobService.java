package com.preptrack.preptrack_backend.service;

import com.preptrack.preptrack_backend.entity.Job;
import com.preptrack.preptrack_backend.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job save(Job job, com.preptrack.preptrack_backend.entity.User user) {
        job.setUser(user);
        return jobRepository.save(job);
    }

    public List<Job> getAll(com.preptrack.preptrack_backend.entity.User user) {
        return jobRepository.findAllByUserOrderByIdAsc(user);
    }

    public void delete(Long id, com.preptrack.preptrack_backend.entity.User user) {
        Job row = jobRepository.findById(id).orElseThrow();
        if (row.getUser() == null) throw new org.springframework.security.access.AccessDeniedException("Unassigned legacy job requires migration");
        if (!user.getId().equals(row.getUser().getId())) throw new org.springframework.security.access.AccessDeniedException("Job does not belong to the authenticated user");
        jobRepository.delete(row);
    }
}