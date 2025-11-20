package com.example.sistema;

import com.example.sistema.model.Aluno;
import com.example.sistema.model.Curso;
import com.example.sistema.repository.AlunoRepository;
import com.example.sistema.repository.CursoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final AlunoRepository alunoRepo;
    private final CursoRepository cursoRepo;

    public DataLoader(AlunoRepository alunoRepo, CursoRepository cursoRepo) {
        this.alunoRepo = alunoRepo;
        this.cursoRepo = cursoRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Curso c1 = new Curso();
        c1.setNome("Engenharia");
        c1.setCargaHoraria(2400);
        cursoRepo.save(c1);

        Aluno a1 = new Aluno();
        a1.setNome("Isabelle");
        a1.setEmail("isa@example.com");
        a1.setMatricula("2025001");
        a1.getCursos().add(c1);
        alunoRepo.save(a1);
    }
}
