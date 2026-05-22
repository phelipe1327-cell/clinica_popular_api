package com.clinica.popular_ph.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public class PacienteResponseDTO {

    /*CAMPOS QUE APARECERÃO PARA OS CLIENTE*/
    @Schema(description = "ID do paciente")
    private Long id;

    @Schema(description = "Nome do paciente")
    private String nome;

    @Schema(description = "CPF do paciente")
    private String cpf;

    @Schema(description = "Telefone do paciente")
    private String telefone;

    @Schema(description = "Email do paciente")
    private String email;

    @Schema(description = "Data de nascimento do paciente")
    private LocalDate dataNascimento;

    /*GETTERS E SETTERS*/
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public java.time.LocalDate getDataNascimento() {return dataNascimento;}
    public void setDataNascimento(java.time.LocalDate dataNascimento) {this.dataNascimento = dataNascimento;}
}