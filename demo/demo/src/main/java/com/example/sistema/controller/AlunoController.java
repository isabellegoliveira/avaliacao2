package com.example.sistema.controller;

import com.example.sistema.model.Aluno;
import com.example.sistema.repository.AlunoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
@CrossOrigin
public class AlunoController {
    private final AlunoRepository repo;

    public AlunoController(AlunoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Aluno> all() { return repo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> get(@PathVariable Long id) {
        Optional<Aluno> a = repo.findById(id);
        return a.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aluno create(@RequestBody Aluno aluno) { return repo.save(aluno); }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno aluno) {
        return repo.findById(id).map(existing -> {
            existing.setNome(aluno.getNome());
            existing.setEmail(aluno.getEmail());
            existing.setMatricula(aluno.getMatricula());
            existing.setCursos(aluno.getCursos());
            repo.save(existing);
            return ResponseEntity.ok(existing);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repo.deleteById(id); }
}
