package com.example.api_alunos.Repository;

import com.example.api_alunos.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AlunoRepositorio extends JpaRepository<Aluno, Long> {
}
