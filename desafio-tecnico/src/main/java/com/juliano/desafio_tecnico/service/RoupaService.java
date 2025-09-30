package com.juliano.desafio_tecnico.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.juliano.desafio_tecnico.exceptions.RoupaNotFoundException;
import com.juliano.desafio_tecnico.model.Roupa;
import com.juliano.desafio_tecnico.repository.RoupaRepository;

@Service
public class RoupaService {

    private final RoupaRepository roupaRepository;
    private static final String NOT_FOUND_EXCEPTION = "ROUPA NÃO ENCONTRADA";

    public RoupaService(RoupaRepository roupaRepository) {
        this.roupaRepository = roupaRepository;
    }

    public List<Roupa> getAllRoupas() {

        List<Roupa> roupasLista = roupaRepository.findAll();

        if (roupasLista.isEmpty()) {
            throw new RoupaNotFoundException(NOT_FOUND_EXCEPTION);
        }
        return roupasLista;
    }

    public Roupa save(Roupa roupa) {
        return roupaRepository.save(roupa);
    }

    public void delete(Long roupaId) {
        Roupa roupa = this.roupaRepository.findById(roupaId).orElseThrow(() -> new RoupaNotFoundException(NOT_FOUND_EXCEPTION));

        this.roupaRepository.delete(roupa);
    }

    public Roupa getRoupaById(Long roupaId) {
        
        Roupa roupa = roupaRepository.findById(roupaId).orElseThrow(() -> new RoupaNotFoundException(NOT_FOUND_EXCEPTION));
        return roupa;
    }

}
