package com.preptrack.preptrack_backend.repository;

import com.preptrack.preptrack_backend.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import com.preptrack.preptrack_backend.entity.User;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
	List<Job> findAllByUserOrderByIdAsc(User user);
	List<Job> findAllByUserIsNullOrderByIdAsc();

}
