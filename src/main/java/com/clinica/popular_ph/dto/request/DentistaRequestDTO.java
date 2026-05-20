package com.clinica.popular_ph.dto.request;

import jakarta.validation.constraints.*;
import java.util.List;

public class DentistaRequestDTO {

    /*VALIDANDO OS CAMPOS PARA O ENVIO CORRETO*/
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "CRO é obrigatório")
    @Size(min = 6, max = 6, message = "CRO deve ter 6 dígitos")
    private String cro;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    private List<Long> especialidadeIds;

    /*GETTERS E SETTERS*/
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getCro() {return cro;}
    public void setCro(String cro) {this.cro = cro;}
    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public List<Long> getEspecialidadeIds() {return especialidadeIds;}
    public void setEspecialidadeIds(List<Long> especialidadeIds) {this.especialidadeIds = especialidadeIds;}
}