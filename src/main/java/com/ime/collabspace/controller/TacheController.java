package com.ime.collabspace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ime.collabspace.service.TacheService;
import com.ime.collabspace.service.dto.TacheDTO;
import com.ime.collabspace.service.mapper.TacheMapper;

@RestController
@RequestMapping("/api/tache")
public class TacheController {
    private final TacheService tacheService;
    public TacheController(TacheService tacheService, TacheMapper tacheMapper) {
        this.tacheService = tacheService;
    }

    @GetMapping("/read")
    public List<TacheDTO> read() { 
        return tacheService.lire();
    }
    @PostMapping("/create")
    public TacheDTO create(@RequestBody TacheDTO tacheDTO) {
        return tacheService.creer(tacheDTO);
    }
    @PutMapping("/update/{id}")
    public TacheDTO update(@RequestBody TacheDTO tacheDTO, @PathVariable Long id) {
        return tacheService.modifier(id, tacheDTO);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return tacheService.supprimer(id);
    }
    @GetMapping("/readOne/{id}")
    public TacheDTO readOne(@PathVariable Long id) {
        return tacheService.lireUn(id);
    }

}
