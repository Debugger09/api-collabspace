package com.ime.collabspace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ime.collabspace.service.MaterielService;
import com.ime.collabspace.service.dto.MaterielDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/materiel")
public class MaterielController {
    private final MaterielService materielService;
    public MaterielController(MaterielService materielService) {
        this.materielService = materielService;
    }

    @PostMapping("/create")
    public MaterielDTO create(@RequestBody MaterielDTO materielDTO) {
        return materielService.creer(materielDTO);
    }

    @GetMapping("/read")
    public List<MaterielDTO> read() { 
        return materielService.lire();
    }

    @PutMapping("/update/{id}")
    public MaterielDTO update(@RequestBody MaterielDTO materielDTO, @PathVariable Long id) {
        return materielService.modifier(id, materielDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return materielService.supprimer(id);
    }

    @GetMapping("/readOne/{id}")
    public MaterielDTO readOne(@PathVariable Long id) {
        return materielService.lireUn(id);
    }

}
