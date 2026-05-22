package com.clinica.popular_ph.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "Dados de cadastro do prontuario")
public class ProntuarioRequestDTO {

    /*VALIDANDO OS CAMPOS PARA O ENVIO CORRETO*/
    @Schema(description = "Tipo sanguíneo do paciente")
    @NotBlank(message = "Tipo sanguíneo é obrigatório")
    private String tipoSanguineo;

    @Schema(description = "Alergias do paciente")
    private String alergias;

    @Schema(description = "Observações médicas do paciente")
    private String observacoes;

    @Schema(description = "ID do paciente dono do prontuario")
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