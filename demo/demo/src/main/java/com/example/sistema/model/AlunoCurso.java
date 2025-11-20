package com.example.sistema.model;

import jakarta.persistence.*;

@Entity
@Table(name = "aluno_curso")
public class AlunoCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="aluno_id", nullable=false)
    private Long alunoId;

    @Column(name="curso_id", nullable=false)
    private Long cursoId;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }
    public Long getCursoId() { return cursoId; }
    public void setCursoId(Long cursoId) { this.cursoId = cursoId; }
}
