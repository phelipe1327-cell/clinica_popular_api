package com.clinica.popular_ph.dto.request;

import jakarta.validation.constraints.*;

public class ProntuarioRequestDTO {

    /*VALIDANDO OS CAMPOS PARA O ENVIO CORRETO*/
    @NotBlank(message = "Tipo sanguíneo é obrigatório")
    private String tipoSanguineo;

    private String alergias;

    private String observacoes;

    @NotNull(message = "Paciente é obrigatório")
    private Long pacienteId;

    /*GETTERS E SETTERS*/
    public String getTipoSanguineo() {return tipoSanguineo;}
    public void setTipoSanguineo(String tipoSanguineo) {this.tipoSanguineo = tipoSanguineo;}
    public String getAlergias() {return alergias;}
    public void setAlergias(String alergias) {this.alergias = alergias;}
    public String getObservacoes() {return observacoes;}
    public void setObservacoes(String observacoes) {this.observacoes = observacoes;}
    public Long getPacienteId() {return pacienteId;}
    public void setPacienteId(Long pacienteId) {this.pacienteId = pacienteId;}
}