package com.clinica.popular_ph.controller;

import com.clinica.popular_ph.dto.request.DentistaRequestDTO;
import com.clinica.popular_ph.dto.response.DentistaResponseDTO;
import com.clinica.popular_ph.service.DentistaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    /*ACESSANDO O SERVICE*/
    @Autowired
    private DentistaService dentistaService;

    /*GET - LISTAR TODOS OS DENTISTAS*/
    @GetMapping
    public ResponseEntity<List<DentistaResponseDTO>> listarTodos() {
        return ResponseEntity.ok(dentistaService.listarTodos());
    }

    /*GET - BUSCAR DENTISTA POR ID*/
    @GetMapping("/{id}")
    public ResponseEntity<DentistaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(dentistaService.buscarPorId(id));
    }

    /*POST - CRIAR NOVO DENTISTA*/
    @PostMapping
    public ResponseEntity<DentistaResponseDTO> criar(@RequestBody @Valid DentistaRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dentistaService.criar(request));
    }

    /*PUT - ATUALIZAR DENTISTA*/
    @PutMapping("/{id}")
    public ResponseEntity<DentistaResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid DentistaRequestDTO request) {
        return ResponseEntity.ok(dentistaService.atualizar(id, request));
    }

    /*DELETE - DELETAR DENTISTA*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        dentistaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}