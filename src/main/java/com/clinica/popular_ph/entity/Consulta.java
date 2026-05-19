package com.clinica.popular_ph.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "consultas")
public class Consulta {

    /*CRIANDO OS CAMPOS*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false)
    private String status;

    @Column(nullable = true)
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "dentista_id", nullable = false)
    private Dentista dentista;

    /*CONSTRUTORES*/
    public Consulta() {}
    public Consulta(Long id, LocalDateTime dataHora, String status, String observacoes) {
        this.id = id;
        this.dataHora = dataHora;
        this.status = status;
        this.observacoes = observacoes;
    }

    /*GETTERS E SETTERS*/
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public LocalDateTime getDataHora() {return dataHora;}
    public void setDataHora(LocalDateTime dataHora) {this.dataHora = dataHora;}
    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}
    public String getObservacoes() {return observacoes;}
    public void setObservacoes(String observacoes) {this.observacoes = observacoes;}

    public Paciente getPaciente() {return paciente;}
    public void setPaciente(Paciente paciente) {this.paciente = paciente;}
    public Dentista getDentista() {return dentista;}
    public void setDentista(Dentista dentista) {this.dentista = dentista;}
}
