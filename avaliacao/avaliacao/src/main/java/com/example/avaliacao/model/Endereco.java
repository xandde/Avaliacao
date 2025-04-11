package com.example.avaliacao.model;

import jakarta.persistence.Entity;  // Indica que esta classe é uma entidade JPA (pode ser persistida no banco de dados)
import jakarta.persistence.GeneratedValue;  // Indica que o valor da chave primária será gerado automaticamente
import jakarta.persistence.Id;  // Define o campo id como a chave primária da entidade

@Entity  // Anotação que marca a classe como uma entidade do JPA
public class Endereco {

    @Id  // Define a chave primária da entidade
    @GeneratedValue  // Indica que o valor dessa chave primária será gerado automaticamente
    private Long id;  // Atributo que armazena o ID único do endereço

    private String logradouro;  // Atributo para armazenar o nome do logradouro (exemplo: Rua, Avenida)
    private String numero;  // Atributo para armazenar o número da residência ou do estabelecimento
    private String complemento;  // Atributo para armazenar um complemento (exemplo: Bloco, Andar)
    private String cidade;  // Atributo para armazenar o nome da cidade

    // Construtores

    // Construtor padrão (sem parâmetros) para inicialização do objeto
    public Endereco() {
    }

    // Construtor com parâmetros para inicializar todos os campos da classe
    public Endereco(Long id, String logradouro, String numero, String complemento, String cidade) {
        this.id = id;  // Inicializa o ID do endereço
        this.logradouro = logradouro;  // Inicializa o logradouro
        this.numero = numero;  // Inicializa o número da residência ou estabelecimento
        this.complemento = complemento;  // Inicializa o complemento (caso haja)
        this.cidade = cidade;  // Inicializa o nome da cidade
    }

    // Getters e Setters

    // Método para obter o ID do endereço
    public Long getId() {
        return id;
    }

    // Método para definir o ID do endereço
    public void setId(Long id) {
        this.id = id;
    }

    // Método para obter o logradouro
    public String getLogradouro() {
        return logradouro;
    }

    // Método para definir o logradouro
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    // Método para obter o número do endereço
    public String getNumero() {
        return numero;
    }

    // Método para definir o número do endereço
    public void setNumero(String numero) {
        this.numero = numero;
    }

    // Método para obter o complemento do endereço
    public String getComplemento() {
        return complemento;
    }

    // Método para definir o complemento do endereço
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    // Método para obter a cidade do endereço
    public String getCidade() {
        return cidade;
    }

    // Método para definir a cidade do endereço
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
