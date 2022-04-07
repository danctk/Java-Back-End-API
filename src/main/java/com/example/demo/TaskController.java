package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskRepository repo;

    @GetMapping("")
    public Iterable<Task> getTasks() {
        return repo.findAll();
    }

    @GetMapping("/hello")
    public String getHello() {
        return "hello";
    }

    @GetMapping("/{id}")
    public Optional<Task> getTask(@PathVariable Long id) {
        return repo.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<?> addTask(@RequestBody Task addTask, UriComponentsBuilder uri) {
        if (addTask == null || addTask.getTitle() == null) {
            return ResponseEntity.badRequest().build();
        }
        addTask = repo.save(addTask);
        URI path = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(addTask.getId()).toUri();
        ResponseEntity<?> response = ResponseEntity.created(path).build();
        return response;
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<?> editTask(@RequestBody Task editTask,
                                         @PathVariable("taskId") long taskId) {
        if (editTask.getId() != taskId || editTask.getTitle() == null) {
            return ResponseEntity.badRequest().build();
        }
        repo.save(editTask);
        return ResponseEntity.ok().build();
    }

}
