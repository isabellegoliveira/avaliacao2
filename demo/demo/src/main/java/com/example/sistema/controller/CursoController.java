package com.example.sistema.controller;

import com.example.sistema.model.Curso;
import com.example.sistema.repository.CursoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
@CrossOrigin
public class CursoController {
    private final CursoRepository repo;

    public CursoController(CursoRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Curso> all() { return repo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> get(@PathVariable Long id) {
        Optional<Curso> c = repo.findById(id);
        return c.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Curso create(@RequestBody Curso curso) { return repo.save(curso); }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso curso) {
        return repo.findById(id).map(existing -> {
            existing.setNome(curso.getNome());
            existing.setCargaHoraria(curso.getCargaHoraria());
            repo.save(existing);
            return ResponseEntity.ok(existing);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repo.deleteById(id); }
}
