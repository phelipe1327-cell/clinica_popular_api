package com.clinica.popular_ph.service;

import com.clinica.popular_ph.dto.request.ProntuarioRequestDTO;
import com.clinica.popular_ph.dto.response.ProntuarioResponseDTO;
import com.clinica.popular_ph.entity.Paciente;
import com.clinica.popular_ph.entity.Prontuario;
import com.clinica.popular_ph.exception.ResourceNotFoundException;
import com.clinica.popular_ph.repository.PacienteRepository;
import com.clinica.popular_ph.repository.ProntuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*REGRAS DE NEGÓCIO, MÉTODOS QUE VÃO SER CHAMADOS PELO CONTROLLER*/
@Service
public class ProntuarioService {

    /*ACESSANDO O BANCO COM REPOSITORY*/
    @Autowired
    private ProntuarioRepository prontuarioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    /*GET - LISTAR OS PRONTUARIOS*/
    public List<ProntuarioResponseDTO> listarTodos() {
        List<Prontuario> prontuarios = prontuarioRepository.findAll();
        List<ProntuarioResponseDTO> lista = new ArrayList<>();
        for (Prontuario prontuario : prontuarios) {
            lista.add(toResponse(prontuario));
        }
        return lista;
    }

    /*GET - BUSCAR PRONTUARIO POR ID*/
    public ProntuarioResponseDTO buscarPorId(Long id) {
        Prontuario prontuario = prontuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Prontuario não encontrado"));
        return toResponse(prontuario);
    }

    /*POST - CRIAR NOVO PRONTUARIO*/
    public ProntuarioResponseDTO criar(ProntuarioRequestDTO request) {
        Paciente paciente = pacienteRepository.findById(request.getPacienteId()).orElseThrow(() -> new ResourceNotFoundException("Prontuario não encontrado"));
        Prontuario prontuario = new Prontuario();
        prontuario.setTipoSanguineo(request.getTipoSanguineo());
        prontuario.setAlergias(request.getAlergias());
        prontuario.setObservacoes(request.getObservacoes());
        prontuario.setPaciente(paciente);
        return toResponse(prontuarioRepository.save(prontuario));
    }

    /*PUT - ATUALIZAR PRONTUARIO*/
    public ProntuarioResponseDTO atualizar(Long id, ProntuarioRequestDTO request) {
        Prontuario prontuario = prontuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Prontuario não encontrado"));
        Paciente paciente = pacienteRepository.findById(request.getPacienteId()).orElseThrow(() -> new ResourceNotFoundException("Prontuario não encontrado"));
        prontuario.setTipoSanguineo(request.getTipoSanguineo());
        prontuario.setAlergias(request.getAlergias());
        prontuario.setObservacoes(request.getObservacoes());
        prontuario.setPaciente(paciente);
        return toResponse(prontuarioRepository.save(prontuario));
    }

    /*DELETE - DELETAR PRONTUARIO*/
    public void deletar(Long id) {
        prontuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Prontuario não encontrado"));
        prontuarioRepository.deleteById(id);
    }

    /*CONVERTER PRONTUARIO PARA RESPONSE DTO*/
    private ProntuarioResponseDTO toResponse(Prontuario prontuario) {
        ProntuarioResponseDTO response = new ProntuarioResponseDTO();
        response.setId(prontuario.getId());
        response.setTipoSanguineo(prontuario.getTipoSanguineo());
        response.setAlergias(prontuario.getAlergias());
        response.setObservacoes(prontuario.getObservacoes());
        response.setPacienteId(prontuario.getPaciente().getId());
        response.setPacienteNome(prontuario.getPaciente().getNome());
        return response;
    }
}