package com.devshowcase.controller;

import com.devshowcase.model.Project;
import com.devshowcase.repository.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectRepository repository;

    public ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Project> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Project criar(@RequestBody Project project) {
        return repository.save(project);
    }

    @GetMapping("/{id}")
    public Project buscar(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}