package com.clinica.popular_ph.service;

import com.clinica.popular_ph.dto.request.DentistaRequestDTO;
import com.clinica.popular_ph.dto.response.DentistaResponseDTO;
import com.clinica.popular_ph.entity.Dentista;
import com.clinica.popular_ph.entity.Especialidade;
import com.clinica.popular_ph.exception.ResourceNotFoundException;
import com.clinica.popular_ph.repository.DentistaRepository;
import com.clinica.popular_ph.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*REGRAS DE NEGÓCIO, MÉTODOS QUE VÃO SER CHAMADOS PELO CONTROLLER*/
@Service
public class DentistaService {

    /*ACESSANDO O BANCO COM REPOSITORY*/
    @Autowired
    private DentistaRepository dentistaRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    /*GET - LISTAR OS DENTISTAS*/
    public List<DentistaResponseDTO> listarTodos() {
        List<Dentista> dentistas = dentistaRepository.findAll();
        List<DentistaResponseDTO> lista = new ArrayList<>();
        for (Dentista dentista : dentistas) {
            lista.add(toResponse(dentista));
        }
        return lista;
    }

    /*GET - BUSCAR DENTISTA POR ID*/
    public DentistaResponseDTO buscarPorId(Long id) {
        Dentista dentista = dentistaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dentista não encontrado"));
        return toResponse(dentista);
    }

    /*POST - CRIAR NOVO DENTISTA*/
    public DentistaResponseDTO criar(DentistaRequestDTO request) {
        Dentista dentista = new Dentista();
        dentista.setNome(request.getNome());
        dentista.setCro(request.getCro());
        dentista.setTelefone(request.getTelefone());
        dentista.setEmail(request.getEmail());
        if (request.getEspecialidadeIds() != null) {
            List<Especialidade> especialidades = especialidadeRepository.findAllById(request.getEspecialidadeIds());
            dentista.setEspecialidades(especialidades);
        }
        return toResponse(dentistaRepository.save(dentista));
    }

    /*PUT - ATUALIZAR DENTISTA*/
    public DentistaResponseDTO atualizar(Long id, DentistaRequestDTO request) {
        Dentista dentista = dentistaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dentista não encontrado"));
        dentista.setNome(request.getNome());
        dentista.setCro(request.getCro());
        dentista.setTelefone(request.getTelefone());
        dentista.setEmail(request.getEmail());
        if (request.getEspecialidadeIds() != null) {
            List<Especialidade> especialidades = especialidadeRepository.findAllById(request.getEspecialidadeIds());
            dentista.setEspecialidades(especialidades);
        }
        return toResponse(dentistaRepository.save(dentista));
    }

    /*DELETE - DELETAR DENTISTA*/
    public void deletar(Long id) {
        dentistaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dentista não encontrado"));
        dentistaRepository.deleteById(id);
    }

    /*CONVERTER DENTISTA PARA RESPONSE DTO*/
    private DentistaResponseDTO toResponse(Dentista dentista) {
        DentistaResponseDTO response = new DentistaResponseDTO();
        response.setId(dentista.getId());
        response.setNome(dentista.getNome());
        response.setCro(dentista.getCro());
        response.setTelefone(dentista.getTelefone());
        response.setEmail(dentista.getEmail());
        if (dentista.getEspecialidades() != null) {
            List<String> nomes = new ArrayList<>();
            for (Especialidade e : dentista.getEspecialidades()) {
                nomes.add(e.getNome());
            }
            response.setEspecialidades(nomes);
        }
        return response;
    }
}