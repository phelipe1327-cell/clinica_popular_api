package com.clinica.popular_ph.dto.response;

import com.clinica.popular_ph.entity.StatusConsulta;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Dados retornados da consulta")
public class ConsultaResponseDTO {

    @Schema(description = "ID da consulta")
    private Long id;

    @Schema(description = "Data e hora da consulta")
    private LocalDateTime dataHora;

    @Schema(description = "Status da consulta")
    private StatusConsulta status;

    @Schema(description = "Observações da consulta")
    private String observacoes;

    @Schema(description = "ID do paciente")
    private Long pacienteId;

    @Schema(description = "Nome do paciente")
    private String pacienteNome;

    @Schema(description = "ID do dentista")
    private Long dentistaId;

    @Schema(description = "Nome do dentista")
    private String dentistaNome;

    /*GETTERS E SETTERS*/
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public LocalDateTime getDataHora() {return dataHora;}
    public void setDataHora(LocalDateTime dataHora) {this.dataHora = dataHora;}
    public StatusConsulta getStatus() {return status;}
    public void setStatus(StatusConsulta status) {this.status = status;}
    public String getObservacoes() {return observacoes;}
    public void setObservacoes(String observacoes) {this.observacoes = observacoes;}
    public Long getPacienteId() {return pacienteId;}
    public void setPacienteId(Long pacienteId) {this.pacienteId = pacienteId;}
    public String getPacienteNome() {return pacienteNome;}
    public void setPacienteNome(String pacienteNome) {this.pacienteNome = pacienteNome;}
    public Long getDentistaId() {return dentistaId;}
    public void setDentistaId(Long dentistaId) {this.dentistaId = dentistaId;}
    public String getDentistaNome() {return dentistaNome;}
    public void setDentistaNome(String dentistaNome) {this.dentistaNome = dentistaNome;}
}