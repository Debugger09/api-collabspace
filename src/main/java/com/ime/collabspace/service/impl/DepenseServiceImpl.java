package com.ime.collabspace.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ime.collabspace.model.Depense;
import com.ime.collabspace.repository.DepenseRepository;
import com.ime.collabspace.service.DepenseService;
import com.ime.collabspace.service.dto.DepenseDTO;
import com.ime.collabspace.service.mapper.DepenseMapper;

@Service
@Transactional
public class DepenseServiceImpl implements DepenseService {

    private final DepenseRepository depenseRepository;
    private final DepenseMapper depenseMapper;

    public DepenseServiceImpl(DepenseRepository depenseRepository, DepenseMapper depenseMapper) {
        this.depenseRepository = depenseRepository;
        this.depenseMapper = depenseMapper;
    }

    @Override
    public DepenseDTO creer(DepenseDTO depenseDTO) {
       Depense depense = depenseRepository.save(depenseMapper.toEntity(depenseDTO));
        return depenseMapper.toDto(depense);
    }

    @Override
    public DepenseDTO modifier(Long id, DepenseDTO depenseDTO) {
        Depense depense = depenseRepository.findById(id)
                .map(p -> {
                    p.setLibelle(depenseDTO.getLibelle());
                    p.setMontant(depenseDTO.getMontant());
                    p.setDateRecu(depenseDTO.getDateRecu());
                    p.setProjet(depenseDTO.getProjet());
                    return depenseRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Dépense introuvable avec l'ID : " + id));
                return depenseMapper.toDto(depense);
    }

    @Override
    public String supprimer(Long id) {
        depenseRepository.deleteById(id);
        return "Dépense supprimée avec succès !";
    }

    @Override
    public DepenseDTO lireUn(Long id) {
        // Trouver la dépense par ID
        Depense depense = depenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dépense introuvable avec l'ID : " + id));

        // Retourner le DTO correspondant
        return depenseMapper.toDto(depense);
    }

    @Override
    public List<DepenseDTO> lire() {
        // Récupérer toutes les dépenses et les convertir en DTOs
        return depenseRepository.findAll()
                .stream()
                .map(depenseMapper::toDto)
                .collect(Collectors.toList());
    }
}