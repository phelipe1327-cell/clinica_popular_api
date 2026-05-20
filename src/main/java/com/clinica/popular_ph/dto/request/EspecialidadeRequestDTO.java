package com.clinica.popular_ph.dto.request;

import jakarta.validation.constraints.*;

public class EspecialidadeRequestDTO {

    /*VALIDANDO OS CAMPOS PARA O ENVIO CORRETO*/
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private String descricao;

    /*GETTERS E SETTERS*/
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
}