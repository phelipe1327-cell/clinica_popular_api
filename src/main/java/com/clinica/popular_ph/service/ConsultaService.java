package com.clinica.popular_ph.service;

import com.clinica.popular_ph.dto.request.ConsultaRequestDTO;
import com.clinica.popular_ph.dto.response.ConsultaResponseDTO;
import com.clinica.popular_ph.entity.Consulta;
import com.clinica.popular_ph.entity.Dentista;
import com.clinica.popular_ph.entity.Paciente;
import com.clinica.popular_ph.exception.ResourceNotFoundException;
import com.clinica.popular_ph.repository.ConsultaRepository;
import com.clinica.popular_ph.repository.DentistaRepository;
import com.clinica.popular_ph.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*REGRAS DE NEGÓCIO, MÉTODOS QUE VÃO SER CHAMADOS PELO CONTROLLER*/
@Service
public class ConsultaService {

    /*ACESSANDO O BANCO COM REPOSITORY*/
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DentistaRepository dentistaRepository;

    /*GET - LISTAR AS CONSULTAS*/
    public List<ConsultaResponseDTO> listarTodos() {
        List<Consulta> consultas = consultaRepository.findAll();
        List<ConsultaResponseDTO> lista = new ArrayList<>();
        for (Consulta consulta : consultas) {
            lista.add(toResponse(consulta));
        }
        return lista;
    }

    /*GET - BUSCAR CONSULTA POR ID*/
    public ConsultaResponseDTO buscarPorId(Long id) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Consulta não Encontrada"));
        return toResponse(consulta);
    }

    /*POST - CRIAR NOVA CONSULTA*/
    public ConsultaResponseDTO criar(ConsultaRequestDTO request) {
        Paciente paciente = pacienteRepository.findById(request.getPacienteId()).orElseThrow(() -> new ResourceNotFoundException("Consulta não Encontrada"));
        Dentista dentista = dentistaRepository.findById(request.getDentistaId()).orElseThrow(() -> new ResourceNotFoundException("Consulta não Encontrada"));
        Consulta consulta = new Consulta();
        consulta.setDataHora(request.getDataHora());
        consulta.setStatus(request.getStatus());
        consulta.setObservacoes(request.getObservacoes());
        consulta.setPaciente(paciente);
        consulta.setDentista(dentista);
        return toResponse(consultaRepository.save(consulta));
    }

    /*PUT - ATUALIZAR CONSULTA*/
    public ConsultaResponseDTO atualizar(Long id, ConsultaRequestDTO request) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("Consulta não Encontrada"));
        Paciente paciente = pacienteRepository.findById(request.getPacienteId()).orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));
        Dentista dentista = dentistaRepository.findById(request.getDentistaId()).orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));
        consulta.setDataHora(request.getDataHora());
        consulta.setStatus(request.getStatus());
        consulta.setObservacoes(request.getObservacoes());
        consulta.setPaciente(paciente);
        consulta.setDentista(dentista);
        return toResponse(consultaRepository.save(consulta));
    }

    /*DELETE - DELETAR CONSULTA*/
    public void deletar(Long id) {
        consultaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Consulta não Encontrada"));
        consultaRepository.deleteById(id);
    }

    /*CONVERTER CONSULTA PARA RESPONSE DTO*/
    private ConsultaResponseDTO toResponse(Consulta consulta) {
        ConsultaResponseDTO response = new ConsultaResponseDTO();
        response.setId(consulta.getId());
        response.setDataHora(consulta.getDataHora());
        response.setStatus(consulta.getStatus());
        response.setObservacoes(consulta.getObservacoes());
        response.setPacienteId(consulta.getPaciente().getId());
        response.setPacienteNome(consulta.getPaciente().getNome());
        response.setDentistaId(consulta.getDentista().getId());
        response.setDentistaNome(consulta.getDentista().getNome());
        return response;
    }
}