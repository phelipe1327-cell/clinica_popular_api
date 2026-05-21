package com.clinica.popular_ph.service;

import com.clinica.popular_ph.dto.request.EspecialidadeRequestDTO;
import com.clinica.popular_ph.dto.response.EspecialidadeResponseDTO;
import com.clinica.popular_ph.entity.Especialidade;
import com.clinica.popular_ph.exception.ResourceNotFoundException;
import com.clinica.popular_ph.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*REGRAS DE NEGÓCIO, MÉTODOS QUE VÃO SER CHAMADOS PELO CONTROLLER*/
@Service
public class EspecialidadeService {

    /*ACESSANDO O BANCO COM REPOSITORY*/
    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    /*GET - LISTAR AS ESPECIALIDADES*/
    public List<EspecialidadeResponseDTO> listarTodos() {
        List<Especialidade> especialidades = especialidadeRepository.findAll();
        List<EspecialidadeResponseDTO> lista = new ArrayList<>();
        for (Especialidade especialidade : especialidades) {
            lista.add(toResponse(especialidade));
        }
        return lista;
    }

    /*GET - BUSCAR ESPECIALIDADE POR ID*/
    public EspecialidadeResponseDTO buscarPorId(Long id) {
        Especialidade especialidade = especialidadeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Especialidade não Encontrada"));
        return toResponse(especialidade);
    }

    /*POST - CRIAR NOVA ESPECIALIDADE*/
    public EspecialidadeResponseDTO criar(EspecialidadeRequestDTO request) {
        Especialidade especialidade = new Especialidade();
        especialidade.setNome(request.getNome());
        especialidade.setDescricao(request.getDescricao());
        return toResponse(especialidadeRepository.save(especialidade));
    }

    /*PUT - ATUALIZAR ESPECIALIDADE*/
    public EspecialidadeResponseDTO atualizar(Long id, EspecialidadeRequestDTO request) {
        Especialidade especialidade = especialidadeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Especialidade não Encontrada"));
        especialidade.setNome(request.getNome());
        especialidade.setDescricao(request.getDescricao());
        return toResponse(especialidadeRepository.save(especialidade));
    }

    /*DELETE - DELETAR ESPECIALIDADE*/
    public void deletar(Long id) {
        especialidadeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Especialidade não Encontrada"));
        especialidadeRepository.deleteById(id);
    }

    /*CONVERTER ESPECIALIDADE PARA RESPONSE DTO*/
    private EspecialidadeResponseDTO toResponse(Especialidade especialidade) {
        EspecialidadeResponseDTO response = new EspecialidadeResponseDTO();
        response.setId(especialidade.getId());
        response.setNome(especialidade.getNome());
        response.setDescricao(especialidade.getDescricao());
        return response;
    }
}