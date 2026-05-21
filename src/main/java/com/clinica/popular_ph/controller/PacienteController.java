package com.clinica.popular_ph.controller;

import com.clinica.popular_ph.dto.request.PacienteRequestDTO;
import com.clinica.popular_ph.dto.response.PacienteResponseDTO;
import com.clinica.popular_ph.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    /*ACESSANDO O SERVICE*/
    @Autowired
    private PacienteService pacienteService;

    /*GET - LISTAR TODOS OS PACIENTES*/
    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> listarTodos() {
        return ResponseEntity.ok(pacienteService.listarTodos());
    }

    /*GET - BUSCAR PACIENTE POR ID*/
    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }

    /*POST - CRIAR NOVO PACIENTE*/
    @PostMapping
    public ResponseEntity<PacienteResponseDTO> criar(@RequestBody @Valid PacienteRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.criar(request));
    }

    /*PUT - ATUALIZAR PACIENTE*/
    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid PacienteRequestDTO request) {
        return ResponseEntity.ok(pacienteService.atualizar(id, request));
    }

    /*DELETE - DELETAR PACIENTE*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pacienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}