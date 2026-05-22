package com.clinica.popular_ph.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados retornados da especialidade")
public class EspecialidadeResponseDTO {

    @Schema(description = "ID da especialidade")
    private Long id;

    @Schema(description = "Nome da especialidade")
    private String nome;

    @Schema(description = "Descrição da especialidade")
    private String descricao;

    /*GETTERS E SETTERS*/
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
}