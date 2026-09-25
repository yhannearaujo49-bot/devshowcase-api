package com.devshowcase.controller;

import com.devshowcase.model.Feedback;
import com.devshowcase.repository.FeedbackRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    private final FeedbackRepository repository;

    public FeedbackController(FeedbackRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Feedback> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Feedback criar(@RequestBody Feedback feedback) {
        return repository.save(feedback);
    }

    @GetMapping("/{id}")
    public Feedback buscar(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}