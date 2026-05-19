package com.clinica.popular_ph.dto.response;

import com.clinica.popular_ph.entity.StatusConsulta;
import java.time.LocalDateTime;

public class ConsultaResponse {

    /*CAMPOS QUE APARECERÃO PARA O CLIENTE*/
    private Long id;
    private LocalDateTime dataHora;
    private StatusConsulta status;
    private String observacoes;
    private Long pacienteId;
    private String pacienteNome;
    private Long dentistaId;
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