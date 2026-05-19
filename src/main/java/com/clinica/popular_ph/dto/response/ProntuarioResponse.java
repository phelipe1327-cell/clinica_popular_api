package com.clinica.popular_ph.dto.response;

public class ProntuarioResponse {

    /*CAMPOS QUE APARECERÃO PARA O CLIENTE*/
    private Long id;
    private String tipoSanguineo;
    private String alergias;
    private String observacoes;
    private Long pacienteId;
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