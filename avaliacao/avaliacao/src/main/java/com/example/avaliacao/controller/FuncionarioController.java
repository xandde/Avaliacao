package com.example.avaliacao.controller;

import com.example.avaliacao.model.Funcionario;
import com.example.avaliacao.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// Controlador responsável pelas requisições HTTP relacionadas à entidade Funcionario
@RestController
@RequestMapping("/funcionario")  // Define o caminho base para as rotas relacionadas ao funcionário
public class FuncionarioController {

    // Instância do serviço FuncionarioService, que contém a lógica de negócio
    private final FuncionarioService funcionarioService;

    // Construtor que injeta a dependência do serviço
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    // Método para listar todos os funcionários, que responde a requisição GET em "/funcionario"
    @GetMapping
    public List<Funcionario> listarTodos() {
        // Chama o serviço para listar todos os funcionários
        return funcionarioService.listarTodos();
    }

    // Método para salvar um novo funcionário, que responde a requisição POST em "/funcionario"
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Funcionario funcionario) {
        // Valida e salva o novo funcionário
        funcionarioService.salvar(funcionario);
        // Retorna uma resposta com status 201 (Criado) e uma mensagem de sucesso
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Funcionário cadastrado com sucesso"));
    }

    // Método para atualizar os dados de um funcionário existente, que responde a requisição PUT em "/funcionario/{id}"
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(
            @PathVariable Long id,  // O ID do funcionário é capturado da URL
            @Valid @RequestBody Funcionario funcionario) {  // O corpo da requisição contém os novos dados do funcionário

        // Define o ID do funcionário que está sendo atualizado
        funcionario.setId(id);

        // Chama o serviço para atualizar o funcionário
        funcionarioService.atualizar(id, funcionario);

        // Retorna uma resposta com status 200 (OK) e uma mensagem de sucesso
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Funcionário atualizado com sucesso"));
    }

    // Método para excluir um funcionário, que responde a requisição DELETE em "/funcionario/{id}"
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id) {
        // Chama o serviço para excluir o funcionário
        funcionarioService.excluir(id);

        // Retorna uma resposta com status 200 (OK) e uma mensagem de sucesso
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Funcionário excluído com sucesso"));
    }
}
