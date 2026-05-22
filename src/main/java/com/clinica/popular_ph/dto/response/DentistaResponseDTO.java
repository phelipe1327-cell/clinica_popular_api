package com.clinica.popular_ph.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Dados retornados do dentista")
public class DentistaResponseDTO {

    @Schema(description = "ID do dentista")
    private Long id;

    @Schema(description = "Nome do dentista")
    private String nome;

    @Schema(description = "CRO do dentista")
    private String cro;

    @Schema(description = "Telefone do dentista")
    private String telefone;

    @Schema(description = "Email do dentista")
    private String email;

    @Schema(description = "Lista de especialidades do dentista")
    private List<String> especialidades;

    /*GETTERS E SETTERS*/
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getCro() {return cro;}
    public void setCro(String cro) {this.cro = cro;}
    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public List<String> getEspecialidades() {return especialidades;}
    public void setEspecialidades(List<String> especialidades) {this.especialidades = especialidades;}
}