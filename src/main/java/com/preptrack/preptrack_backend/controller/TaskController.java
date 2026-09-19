package com.preptrack.preptrack_backend.controller;

import com.preptrack.preptrack_backend.entity.Task;
import com.preptrack.preptrack_backend.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.security.Principal;
import com.preptrack.preptrack_backend.entity.User;
import com.preptrack.preptrack_backend.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {

    private final TaskService taskService;
    private final UserRepository userRepository;

    public TaskController(TaskService taskService, UserRepository userRepository) {
        this.taskService = taskService;
        this.userRepository = userRepository;
    }

    private User user(Principal principal) {
        return userRepository.findByEmail(principal.getName()).orElseThrow();
    }

    @PostMapping("/api/tasks/save")
    public Task save(@RequestBody Task task, Principal principal) {
        return taskService.save(task, user(principal));
    }

    @GetMapping("/api/tasks/all")
    public List<Task> getAll(Principal principal) {
        return taskService.getAll(user(principal));
    }

    @PutMapping("/api/tasks/update")
    public Task update(@RequestBody Task task, Principal principal) {
        return taskService.update(task, user(principal));
    }

    @DeleteMapping("/api/tasks/delete/{id}")
    public void delete(@PathVariable Long id, Principal principal) {
        taskService.delete(id, user(principal));
    }
}