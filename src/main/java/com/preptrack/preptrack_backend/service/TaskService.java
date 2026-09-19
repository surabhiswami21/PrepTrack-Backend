package com.preptrack.preptrack_backend.service;

import com.preptrack.preptrack_backend.entity.Task;
import com.preptrack.preptrack_backend.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task save(Task task, com.preptrack.preptrack_backend.entity.User user) {
        task.setUser(user);
        return taskRepository.save(task);
    }

    public List<Task> getAll(com.preptrack.preptrack_backend.entity.User user) {
        return taskRepository.findAllByUserOrderByIdAsc(user);
    }

    public void delete(Long id, com.preptrack.preptrack_backend.entity.User user) {
        Task task = taskRepository.findById(id).orElseThrow();
        if (task.getUser() == null) throw new org.springframework.security.access.AccessDeniedException("Unassigned legacy task requires migration");
        if (!user.getId().equals(task.getUser().getId())) {
            throw new org.springframework.security.access.AccessDeniedException("Task does not belong to the authenticated user");
        }
        taskRepository.delete(task);
    }

    public Task update(Task task, com.preptrack.preptrack_backend.entity.User user) {
        Task existing = taskRepository.findById(task.getId()).orElseThrow();
        if (existing.getUser() == null) throw new org.springframework.security.access.AccessDeniedException("Unassigned legacy task requires migration");
        if (!user.getId().equals(existing.getUser().getId())) {
            throw new org.springframework.security.access.AccessDeniedException("Task does not belong to the authenticated user");
        }
        existing.setText(task.getText());
        existing.setDone(task.isDone());
        return taskRepository.save(existing);
    }

}