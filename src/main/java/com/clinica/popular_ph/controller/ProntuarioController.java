package com.clinica.popular_ph.controller;

import com.clinica.popular_ph.dto.request.ProntuarioRequestDTO;
import com.clinica.popular_ph.dto.response.ProntuarioResponseDTO;
import com.clinica.popular_ph.service.ProntuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

    /*ACESSANDO O SERVICE*/
    @Autowired
    private ProntuarioService prontuarioService;

    /*GET - LISTAR TODOS OS PRONTUARIOS*/
    @GetMapping
    public ResponseEntity<List<ProntuarioResponseDTO>> listarTodos() {
        return ResponseEntity.ok(prontuarioService.listarTodos());
    }

    /*GET - BUSCAR PRONTUARIO POR ID*/
    @GetMapping("/{id}")
    public ResponseEntity<ProntuarioResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(prontuarioService.buscarPorId(id));
    }

    /*POST - CRIAR NOVO PRONTUARIO*/
    @PostMapping
    public ResponseEntity<ProntuarioResponseDTO> criar(@RequestBody @Valid ProntuarioRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(prontuarioService.criar(request));
    }

    /*PUT - ATUALIZAR PRONTUARIO*/
    @PutMapping("/{id}")
    public ResponseEntity<ProntuarioResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ProntuarioRequestDTO request) {
        return ResponseEntity.ok(prontuarioService.atualizar(id, request));
    }

    /*DELETE - DELETAR PRONTUARIO*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        prontuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}