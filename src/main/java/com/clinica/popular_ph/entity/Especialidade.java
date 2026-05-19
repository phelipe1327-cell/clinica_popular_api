package com.clinica.popular_ph.entity;

import jakarta.persistence.*;
import java.util.List;

/*CRIANDO A TABELA*/
@Entity
@Table(name = "especialidades")
public class Especialidade {

    /*CRIANDO OS CAMPOS*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = true)
    private String descricao;

    /*RELACIONAMENTO N-N COM DENTISTA | dentista_id: FK na tabela dentistas*/
    @ManyToMany(mappedBy = "especialidades")
    private List<Dentista> dentistas;

    /*CONSTRUTORES*/
    public Especialidade() {}
    public Especialidade(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    /*GETTERS E SETTERS*/
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public List<Dentista> getDentistas() { return dentistas; }
    public void setDentistas(List<Dentista> dentistas) { this.dentistas = dentistas; }
}