package com.example.avaliacao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;  // Importação da classe LocalDate (não utilizada no momento)

// A classe Funcionario é uma entidade JPA, ou seja, será mapeada para uma tabela no banco de dados
@Entity
public class Funcionario {

    // Define que o campo 'id' será a chave primária e será gerado automaticamente no banco de dados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // O campo 'nome' não pode ser em branco, e a mensagem de erro será personalizada
    @NotBlank(message = "Nome é OBRIGATÓRIO")
    private String nome;

    // O campo 'cpf' não pode ser em branco e deve seguir um padrão de 11 dígitos numéricos (regra de validação)
    @NotBlank(message = "CPF é OBRIGATÓRIO")
    @Pattern(regexp = "\\d{11}", message = "CPF deve ter 11 dígitos")
    private String cpf;

    // O campo 'dataNascimento' não pode ser em branco. O tipo String pode ser substituído por LocalDate posteriormente para melhor manipulação de datas
    @NotBlank(message = "Data de Nascimento é OBRIGATÓRIA")
    private String dataNascimento; // Pode ser alterado para LocalDate posteriormente

    // O campo 'sexo' é um Enum, e a anotação @Enumerated define que ele será armazenado como String no banco de dados
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Sexo é obrigatório")
    private Sexo sexo;

    // O campo 'setor' é um Enum, e a anotação @Enumerated define que ele será armazenado como String no banco de dados
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Setor é obrigatório")
    private Setor setor;

    // O campo 'estadoCivil' é um Enum, e a anotação @Enumerated define que ele será armazenado como String no banco de dados
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Estado Civil é obrigatório")
    private EstadoCivil estadoCivil;

    // O campo 'salario' deve ser um valor positivo, definido pela anotação @Positive
    @Positive(message = "Salário deve ser um valor positivo")
    private double salario;

    // O campo 'email' não pode ser em branco, e deve seguir um formato válido de email (validação usando a anotação @Email)
    @NotBlank(message = "Email é OBRIGATÓRIO")
    @Email(message = "Deve ter um email válido")
    private String email;

    // O campo 'endereco' é uma relação Many-to-One com a entidade Endereco, com a chave estrangeira sendo 'endereco_id'
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    // Construtores da classe, tanto o padrão (sem parâmetros) quanto um com todos os campos
    public Funcionario() {
    }

    public Funcionario(Long id, String nome, String cpf, String dataNascimento, Sexo sexo, Setor setor, EstadoCivil estadoCivil, double salario, String email, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.setor = setor;
        this.estadoCivil = estadoCivil;
        this.salario = salario;
        this.email = email;
        this.endereco = endereco;
    }

    // Métodos Getter e Setter para acessar e modificar os valores dos campos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
