package com.clinica.popular_ph.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados retornados do prontuario")
public class ProntuarioResponseDTO {

    @Schema(description = "ID do prontuario")
    private Long id;

    @Schema(description = "Tipo sanguíneo do paciente")
    private String tipoSanguineo;

    @Schema(description = "Alergias do paciente")
    private String alergias;

    @Schema(description = "Observações médicas")
    private String observacoes;

    @Schema(description = "ID do paciente")
    private Long pacienteId;

    @Schema(description = "Nome do paciente")
    private String pacienteNome;

    /*GETTERS E SETTERS*/
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getTipoSanguineo() {return tipoSanguineo;}
    public void setTipoSanguineo(String tipoSanguineo) {this.tipoSanguineo = tipoSanguineo;}
    public String getAlergias() {return alergias;}
    public void setAlergias(String alergias) {this.alergias = alergias;}
    public String getObservacoes() {return observacoes;}
    public void setObservacoes(String observacoes) {this.observacoes = observacoes;}
    public Long getPacienteId() {return pacienteId;}
    public void setPacienteId(Long pacienteId) {this.pacienteId = pacienteId;}
    public String getPacienteNome() {return pacienteNome;}
    public void setPacienteNome(String pacienteNome) {this.pacienteNome = pacienteNome;}
}