package com.example.avaliacao.service;

import com.example.avaliacao.model.Funcionario;  // Importando a classe Funcionario
import com.example.avaliacao.repository.FuncionarioRepository;  // Importando o repositório de Funcionario
import com.example.avaliacao.exception.GlobalExceptionHandler;  // Importando o handler de exceções globais
import jakarta.validation.GroupDefinitionException;  // Exceção que será lançada em caso de erro de validação de grupo
import jakarta.validation.Valid;  // Anotação que valida os objetos durante a execução do método
import org.springframework.stereotype.Service;  // Anotação que indica que essa classe é um serviço

import java.util.List;  // Para retornar uma lista de funcionários
import java.util.Optional;  // Para tratar a possibilidade de o funcionário não ser encontrado

@Service  // Define que a classe FuncionarioService é um serviço que pode ser injetado em outras classes
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;  // Injetando o repositório de Funcionários

    // Construtor da classe, onde o repositório é injetado via Spring
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    // Método para listar todos os funcionários
    public List<Funcionario> listarTodos() {
        // Retorna todos os funcionários do banco de dados utilizando o repositório
        return funcionarioRepository.findAll();
    }

    // Método para salvar um novo funcionário
    public Funcionario salvar(@Valid Funcionario funcionario) {
        // Aqui você pode adicionar uma lógica para verificar se o CPF já existe
        // Verifica se já existe um funcionário com o mesmo CPF
        Optional<Funcionario> funcionarioExistente = funcionarioRepository.findByCpf(funcionario.getCpf());
        if (funcionarioExistente.isPresent()) {
            // Se encontrar, lança uma exceção com a mensagem "Funcionário com CPF já cadastrado."
            throw new RuntimeException("Funcionário com CPF já cadastrado.");
        }

        // Se o CPF não estiver duplicado, salva o novo funcionário no banco
        return funcionarioRepository.save(funcionario);
    }

    // Método para atualizar as informações de um funcionário existente
    public Funcionario atualizar(Long id, @Valid Funcionario funcionario) {
        // Busca o funcionário no banco pelo id. Se não encontrar, lança uma exceção personalizada.
        Funcionario funcionarioAtual = funcionarioRepository.findById(id)
                .orElseThrow(() -> new GroupDefinitionException("Funcionário não encontrado"));

        // Atualiza os campos do funcionário com os dados passados
        funcionarioAtual.setNome(funcionario.getNome());
        funcionarioAtual.setCpf(funcionario.getCpf());
        funcionarioAtual.setDataNascimento(funcionario.getDataNascimento());
        funcionarioAtual.setSexo(funcionario.getSexo());
        funcionarioAtual.setSetor(funcionario.getSetor());
        funcionarioAtual.setEstadoCivil(funcionario.getEstadoCivil());
        funcionarioAtual.setSalario(funcionario.getSalario());
        funcionarioAtual.setEmail(funcionario.getEmail());
        funcionarioAtual.setEndereco(funcionario.getEndereco());

        // Salva as alterações no banco de dados
        return funcionarioRepository.save(funcionarioAtual);
    }

    // Método para excluir um funcionário
    public void excluir(Long id) {
        // Busca o funcionário no banco pelo id. Se não encontrar, lança uma exceção personalizada.
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new GroupDefinitionException("Funcionário não encontrado"));

        // Exclui o funcionário do banco de dados
        funcionarioRepository.delete(funcionario);
    }

    // Método para encontrar um funcionário por CPF
    public Optional<Funcionario> findByCpf(String cpf) {
        // Retorna um Optional de Funcionario, caso o CPF seja encontrado no banco
        return funcionarioRepository.findByCpf(cpf);
    }
}
