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
        // Mapper le DTO vers l'entité
        Materiel materiel = materielMapper.toEntity(materielDTO);

        // Sauvegarder l'entité dans la base de données
        Materiel savedMateriel = materielRepository.save(materiel);

        // Mapper l'entité sauvegardée vers le DTO
        return materielMapper.toDto(savedMateriel);
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
        return materielRepository.findById(id)
                .map(existingMateriel -> {
                    existingMateriel.setLibelle(materielDTO.getLibelle());
                    existingMateriel.setDateEnregistrer(materielDTO.getDateEnregistrer());
                    Materiel updatedMateriel = materielRepository.save(existingMateriel);
                    return materielMapper.toDto(updatedMateriel);
                })
                .orElseThrow(() -> new RuntimeException("Materiel introuvable !"));
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