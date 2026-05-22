package com.clinica.popular_ph.controller;

import com.clinica.popular_ph.dto.request.ConsultaRequestDTO;
import com.clinica.popular_ph.dto.response.ConsultaResponseDTO;
import com.clinica.popular_ph.service.ConsultaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    /*ACESSANDO O SERVICE*/
    @Autowired
    private ConsultaService consultaService;

    /*CHECAR QUAIS ENPOINTS POSSO CHAMAR*/
    @Operation(summary = "Listar todas as consultas", description = "Retorna uma lista com todas as consultas cadastradas")

    /*GET - LISTAR TODAS AS CONSULTAS*/
    @GetMapping
    public ResponseEntity<List<ConsultaResponseDTO>> listarTodos() {
        return ResponseEntity.ok(consultaService.listarTodos());
    }

    /*GET - BUSCAR CONSULTA POR ID*/
    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(consultaService.buscarPorId(id));
    }

    /*POST - CRIAR NOVA CONSULTA*/
    @PostMapping
    public ResponseEntity<ConsultaResponseDTO> criar(@RequestBody @Valid ConsultaRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.criar(request));
    }

    /*PUT - ATUALIZAR CONSULTA*/
    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ConsultaRequestDTO request) {
        return ResponseEntity.ok(consultaService.atualizar(id, request));
    }

    /*DELETE - DELETAR CONSULTA*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        consultaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}