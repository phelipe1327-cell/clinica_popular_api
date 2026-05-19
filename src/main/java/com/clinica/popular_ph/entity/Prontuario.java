package com.clinica.popular_ph.entity;

import jakarta.persistence.*;

/*CRIANDO A TABELA*/
@Entity
@Table(name = "prontuario")
public class Prontuario {

    /*CRIANDO OS CAMPOS*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipoSanguineo;

    @Column(nullable = true)
    private String alergias;

    @Column(nullable = true)
    private String observacoes;

    /*RELACIONAMENTO 1-1 com paciente | paciente_id: FK na tabela prontuarios*/
    @OneToOne
    @JoinColumn(name = "paciente_id", nullable = false, unique = true)
    private Paciente paciente;

    /*CONSTRUTORES*/
    public Prontuario() {}

    public Prontuario(Long id, String tipoSanguineo, String alergias, String observacoes, Paciente paciente) {
        this.id = id;
        this.tipoSanguineo = tipoSanguineo;
        this.alergias = alergias;
        this.observacoes = observacoes;
        this.paciente = paciente;
    }

    /*GETTERS E SETTERS*/
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getTipoSanguineo() {return tipoSanguineo;}
    public void setTipoSanguineo(String tipoSanguineo) {this.tipoSanguineo = tipoSanguineo;}
    public String getAlergias() {return alergias;}
    public void setAlergias(String alergias) {this.alergias = alergias;}
    public String getObservacoes() {return observacoes;}
    public void setObservacoes(String observacoes) {this.observacoes = observacoes;}
    public Paciente getPaciente() {return paciente;}
    public void setPaciente(Paciente paciente) {this.paciente = paciente;}
}


