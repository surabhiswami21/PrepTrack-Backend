package com.preptrack.preptrack_backend.repository;

import com.preptrack.preptrack_backend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import com.preptrack.preptrack_backend.entity.User;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findAllByUserOrderByIdAsc(User user);
	List<Task> findAllByUserIsNullOrderByIdAsc();
}
