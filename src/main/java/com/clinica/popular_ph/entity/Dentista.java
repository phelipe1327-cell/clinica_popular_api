package com.clinica.popular_ph.entity;

import jakarta.persistence.*;
import java.util.List;

/*CRIANDO A TABELA*/
@Entity
@Table(name = "dentistas")
public class Dentista {

    /*CRIANDO OS CAMPOS*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cro;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String email;

    /*RELACIONAMENTO N-N COM ESPECIALIDADE | especialidades_id: FK na tabela especialidades*/
    @ManyToMany
    @JoinTable(
            name = "dentista_especialidade",
            joinColumns = @JoinColumn(name = "dentista_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidade_id")
    )
    private List<Especialidade> especialidades;

    /*CONSTRUTORES*/
    public Dentista() {}
    public Dentista(Long id, String nome, String cro, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.cro = cro;
        this.telefone = telefone;
        this.email = email;
    }

    /*GETTERS E SETTERS*/
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCro() { return cro; }
    public void setCro(String cro) { this.cro = cro; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Especialidade> getEspecialidades() { return especialidades; }
    public void setEspecialidades(List<Especialidade> especialidades) { this.especialidades = especialidades; }
}