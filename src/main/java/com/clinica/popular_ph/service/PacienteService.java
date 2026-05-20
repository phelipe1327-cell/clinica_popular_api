package com.clinica.popular_ph.service;

import com.clinica.popular_ph.dto.request.PacienteRequestDTO;
import com.clinica.popular_ph.dto.response.PacienteResponseDTO;
import com.clinica.popular_ph.entity.Paciente;
import com.clinica.popular_ph.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*REGRAS DE NEGÓCIO, MÉTODOS QUE VÃO SER CHAMADOS PELO CONTROLLER*/
@Service
public class PacienteService {

    /*ACESSANDO O BANCO COM REPOSITORY*/
    @Autowired
    private PacienteRepository pacienteRepository;

    /*GET - LISTAR OS PACIENTES*/
    public List<PacienteResponseDTO> listarTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        List<PacienteResponseDTO> lista = new ArrayList<>();

        for (Paciente paciente : pacientes) {
            lista.add(toResponse(paciente));
        }
        return lista;
    }

    /*GET - BUSCAR PACIENTE POR ID*/
    public PacienteResponseDTO buscarPorId(Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        return toResponse(paciente);
    }
    /*POST - CRIAR NOVO PACIENTE*/
    public PacienteResponseDTO criar(PacienteRequestDTO request) {
        Paciente paciente = new Paciente();
        paciente.setNome(request.getNome());
        paciente.setCpf(request.getCpf());
        paciente.setTelefone(request.getTelefone());
        paciente.setEmail(request.getEmail());
        paciente.setDataNascimento(request.getDataNascimento());
        return toResponse(pacienteRepository.save(paciente));
    }
    /*PUT - ATUALIZAR PACIENTE*/
    public PacienteResponseDTO atualizar(Long id, PacienteRequestDTO request) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        paciente.setNome(request.getNome());
        paciente.setCpf(request.getCpf());
        paciente.setTelefone(request.getTelefone());
        paciente.setEmail(request.getEmail());
        paciente.setDataNascimento(request.getDataNascimento());
        return toResponse(pacienteRepository.save(paciente));
    }
    /*DELETE - DELETAR PACIENTE*/
    public void deletar(Long id) {
        pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        pacienteRepository.deleteById(id);
    }
    /*CONVERTER ENTIDADE PRA RESPONSE*/
    private PacienteResponseDTO toResponse(Paciente paciente) {
        PacienteResponseDTO response = new PacienteResponseDTO();
        response.setId(paciente.getId());
        response.setNome(paciente.getNome());
        response.setCpf(paciente.getCpf());
        response.setTelefone(paciente.getTelefone());
        response.setEmail(paciente.getEmail());
        response.setDataNascimento(paciente.getDataNascimento());
        return response;
    }
}