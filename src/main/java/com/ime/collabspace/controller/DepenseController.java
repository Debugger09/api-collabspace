package com.ime.collabspace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.ime.collabspace.service.DepenseService;
import com.ime.collabspace.service.dto.DepenseDTO;

@RestController
@RequestMapping("/api/depense")
public class DepenseController {
    private final DepenseService depenseService;
    public DepenseController(DepenseService depenseService) {
        this.depenseService = depenseService;
    }

    @PostMapping("/create")
    public DepenseDTO create(@RequestBody DepenseDTO depenseDTO) {
        return depenseService.creer(depenseDTO);
    }

    @PutMapping("/update/{id}")
    public DepenseDTO update(@PathVariable Long id, @RequestBody DepenseDTO depenseDTO) {
        return depenseService.modifier(id, depenseDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return depenseService.supprimer(id);
    }

    @GetMapping("/readOne/{id}")
    public DepenseDTO readOne(@PathVariable Long id) {
        return depenseService.lireUn(id);
    }

    @GetMapping("/read")
    public List<DepenseDTO> read() {
        return depenseService.lire();
    }



}
