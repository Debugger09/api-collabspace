package com.ime.collabspace.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ime.collabspace.model.Materiel;
import com.ime.collabspace.repository.MaterielRepository;
import com.ime.collabspace.service.MaterielService;
import com.ime.collabspace.service.dto.MaterielDTO;
import com.ime.collabspace.service.mapper.MaterielMapper;

@Service
public class MaterielServiceImpl implements MaterielService {
    
    private final MaterielRepository materielRepository;
    private final MaterielMapper materielMapper;
    
    public MaterielServiceImpl(MaterielRepository materielRepository, 
                             MaterielMapper materielMapper) {
        this.materielRepository = materielRepository;
        this.materielMapper = materielMapper;
    }

    @Override
    public MaterielDTO creer(MaterielDTO materielDTO) {
        Materiel materiel = materielRepository.save(materielMapper.toEntity(materielDTO));
        return materielMapper.toDto(materiel);
    }

    @Override
    public List<MaterielDTO> lire() {
        return materielRepository.findAll()
                .stream()
                .map(materielMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MaterielDTO modifier(Long id, MaterielDTO materielDTO) {
        Materiel materiel = materielRepository.findById(id)
                .map(p -> {
                    p.setLibelle(materielDTO.getLibelle());
                    p.setDateEnregistrer(materielDTO.getDateEnregistrer());
                    return materielRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Materiel introuvable !"));
        return materielMapper.toDto(materiel);
    }

    @Override
    public String supprimer(Long id) {
        materielRepository.deleteById(id);
        return "Materiel supprimé !";
    }

    @Override
    public MaterielDTO lireUn(Long id) {
        Materiel materiel = materielRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materiel introuvable avec l'ID : " + id));
        return materielMapper.toDto(materiel);
    }
}