package com.example.avaliacao.repository;

import com.example.avaliacao.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    // Método para encontrar um funcionário pelo CPF
    Optional<Funcionario> findByCpf(String cpf);
}
