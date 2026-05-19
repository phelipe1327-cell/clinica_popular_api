package com.clinica.popular_ph.dto.response;

import java.util.List;

public class DentistaResponse {

    /*CAMPOS QUE APARECERÃO PARA O CLIENTE*/
    private Long id;
    private String nome;
    private String cro;
    private String telefone;
    private String email;
    private List<String> especialidades;

    /*GETTERS E SETTERS*/
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getCro() {return cro;}
    public void setCro(String cro) {this.cro = cro;}
    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public List<String> getEspecialidades() {return especialidades;}
    public void setEspecialidades(List<String> especialidades) {this.especialidades = especialidades;}
}