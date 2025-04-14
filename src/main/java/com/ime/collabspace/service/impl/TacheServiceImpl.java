package com.ime.collabspace.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ime.collabspace.model.Tache;
import com.ime.collabspace.repository.TacheRepository;
import com.ime.collabspace.service.TacheService;
import com.ime.collabspace.service.dto.TacheDTO;
import com.ime.collabspace.service.mapper.TacheMapper;

@Service
public class TacheServiceImpl implements TacheService {
    private final TacheRepository tacheRepository;
    private final TacheMapper tacheMapper;
    
    public TacheServiceImpl(TacheRepository tacheRepository, TacheMapper tacheMapper) {
        this.tacheRepository = tacheRepository;
        this.tacheMapper = tacheMapper;
    }

    @Override
    public TacheDTO creer(TacheDTO tacheDTO) {
        Tache tache = tacheRepository.save(tacheMapper.toEntity(tacheDTO));
        return tacheMapper.toDto(tache);
    }

    @Override
    public TacheDTO modifier(Long id, TacheDTO tacheDTO) {
        Tache tache = tacheRepository.findById(id)
                .map(p -> {
                    p.setLibelle(tacheDTO.getLibelle());
                    p.setDescription(tacheDTO.getDescription());
                    p.setDateEcheance(tacheDTO.getDateEcheance());
                    p.setPriorite(tacheDTO.getPriorite());
                    p.setStatutTache(tacheDTO.getStatutTache());
                    p.setProjet(tacheDTO.getProjet());
                    return tacheRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Tâche introuvable !"));
        return tacheMapper.toDto(tache);
    }

    @Override
    public String supprimer(Long id) {
        tacheRepository.deleteById(id);
        return "Tâche supprimée !";
    }

    @Override
    public TacheDTO lireUn(Long id) {
        Tache tache = tacheRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tâche introuvable !"));
        return tacheMapper.toDto(tache);
    }

    @Override
    public List<TacheDTO> lire() {
        return tacheRepository.findAll()
                .stream()
                .map(tacheMapper::toDto)
                .toList();
    }



}
