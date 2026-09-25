package com.devshowcase.controller;

import com.devshowcase.model.Profile;
import com.devshowcase.repository.ProfileRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileRepository repository;

    public ProfileController(ProfileRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Profile> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Profile criar(@RequestBody Profile profile) {
        return repository.save(profile);
    }

    @GetMapping("/{id}")
    public Profile buscar(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}