package com.clinica.popular_ph.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "Dados de cadastro das especialidades")
public class EspecialidadeRequestDTO {

    /*VALIDANDO OS CAMPOS PARA O ENVIO CORRETO*/
    @Schema(description = "Nome da especialidade")
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Schema(description = "Descrição da especialidade")
    private String descricao;

    /*GETTERS E SETTERS*/
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
}