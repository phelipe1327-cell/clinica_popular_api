package com.clinica.popular_ph.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Schema(description = "Dados para cadastro de paciente")
public class PacienteRequestDTO {

    /*VALIDANDO OS CAMPOS PARA O ENIVIO CORRETO */
    @Schema(description = "Nome completo do paciente")
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Schema(description = "CPF do paciente | 11 dígitos")
    @NotBlank(message = "CPF é obrigatório")
    @Size(min = 11, max = 11, message = "CPF deve ter 11 dígitos")
    private String cpf;

    @Schema(description = "Telefone do paciente")
    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    @Schema(description = "Email do paciente")
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @Schema(description = "Data de nascimento do paciente")
    @NotNull(message = "Data de nascimento é obrigatória")
    @Past(message = "Data de nascimento deve estar no passado")
    private LocalDate dataNascimento;

    /*GETTERS E SETTERS*/
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public LocalDate getDataNascimento() {return dataNascimento;}
    public void setDataNascimento(LocalDate dataNascimento) {this.dataNascimento = dataNascimento;}
}
