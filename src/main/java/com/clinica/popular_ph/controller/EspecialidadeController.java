package com.clinica.popular_ph.controller;

import com.clinica.popular_ph.dto.request.EspecialidadeRequestDTO;
import com.clinica.popular_ph.dto.response.EspecialidadeResponseDTO;
import com.clinica.popular_ph.service.EspecialidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {

    /*ACESSANDO O SERVICE*/
    @Autowired
    private EspecialidadeService especialidadeService;

    /*GET - LISTAR TODAS AS ESPECIALIDADES*/
    @GetMapping
    public ResponseEntity<List<EspecialidadeResponseDTO>> listarTodos() {
        return ResponseEntity.ok(especialidadeService.listarTodos());
    }

    /*GET - BUSCAR ESPECIALIDADE POR ID*/
    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(especialidadeService.buscarPorId(id));
    }

    /*POST - CRIAR NOVA ESPECIALIDADE*/
    @PostMapping
    public ResponseEntity<EspecialidadeResponseDTO> criar(@RequestBody @Valid EspecialidadeRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(especialidadeService.criar(request));
    }

    /*PUT - ATUALIZAR ESPECIALIDADE*/
    @PutMapping("/{id}")
    public ResponseEntity<EspecialidadeResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid EspecialidadeRequestDTO request) {
        return ResponseEntity.ok(especialidadeService.atualizar(id, request));
    }

    /*DELETE - DELETAR ESPECIALIDADE*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        especialidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}