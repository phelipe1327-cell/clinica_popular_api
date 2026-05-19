package com.clinica.popular_ph.dto.request;

import com.clinica.popular_ph.entity.StatusConsulta;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ConsultaRequest {

    /*VALIDANDO OS CAMPOS PARA O ENVIO CORRETO*/
    @NotNull(message = "Data e hora são obrigatórias")
    @Future(message = "Data da consulta deve ser no futuro")
    private LocalDateTime dataHora;

    @NotNull(message = "Status é obrigatório")
    private StatusConsulta status;

    private String observacoes;

    @NotNull(message = "Paciente é obrigatório")
    private Long pacienteId;

    @NotNull(message = "Dentista é obrigatório")
    private Long dentistaId;

    /*GETTERS E SETTERS*/

    public LocalDateTime getDataHora() {return dataHora;}
    public void setDataHora(LocalDateTime dataHora) {this.dataHora = dataHora;}
    public StatusConsulta getStatus() {return status;}
    public void setStatus(StatusConsulta status) {this.status = status;}
    public String getObservacoes() {return observacoes;}
    public void setObservacoes(String observacoes) {this.observacoes = observacoes;}
    public Long getPacienteId() {return pacienteId;}
    public void setPacienteId(Long pacienteId) {this.pacienteId = pacienteId;}
    public Long getDentistaId() {return dentistaId;}
    public void setDentistaId(Long dentistaId) {this.dentistaId = dentistaId;}
}