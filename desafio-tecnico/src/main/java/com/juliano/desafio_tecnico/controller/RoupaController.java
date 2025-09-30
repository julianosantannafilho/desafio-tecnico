package com.juliano.desafio_tecnico.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juliano.desafio_tecnico.dto.RoupaDto;
import com.juliano.desafio_tecnico.model.Roupa;
import com.juliano.desafio_tecnico.service.RoupaService;
import com.juliano.desafio_tecnico.utils.RoupaUtils;

@RestController
@RequestMapping("/roupas")
public class RoupaController {

    private final RoupaService roupaService;
    private final RoupaUtils roupaUtils;
        
    public RoupaController(RoupaService roupaService, RoupaUtils roupaUtils) {
        this.roupaService = roupaService;
        this.roupaUtils = roupaUtils;
    }

    @PostMapping("/create")
    public Roupa createNewRoupa(@RequestBody RoupaDto roupaDto){
        Roupa roupa = roupaService.getRoupaById(roupaDto.getId());
        if (roupa == null) {
            return roupaService.save(roupaUtils.convertDtoToEntity(roupaDto));
        } else {
            throw new RuntimeException("Roupa já existe");
        }
    }

    @GetMapping("/all")
    public List<Roupa> getAllRoupas() {
        return roupaService.getAllRoupas();
    }

    @GetMapping("/{id}")
    public Roupa getRoupaById(@PathVariable Long id) {
        return roupaService.getRoupaById(id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteRoupa(@PathVariable Long id) {
        roupaService.delete(id);
    }

}
