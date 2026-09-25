package com.devshowcase.controller;

import com.devshowcase.model.Technology;
import com.devshowcase.repository.TechnologyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/technologies")
public class TechnologyController {

    private final TechnologyRepository repository;

    public TechnologyController(TechnologyRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Technology> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Technology criar(@RequestBody Technology technology) {
        return repository.save(technology);
    }

    @GetMapping("/{id}")
    public Technology buscar(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}