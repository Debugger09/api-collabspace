package com.ime.collabspace.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ime.collabspace.model.Projet;
import com.ime.collabspace.repository.ProjetRepository;
import com.ime.collabspace.service.ProjetService;
import com.ime.collabspace.service.dto.ProjetDTO;
import com.ime.collabspace.service.mapper.ProjetMapper;

@Service
public class ProjetServiceImpl implements ProjetService {
    private final ProjetRepository projetRepository;
    private final ProjetMapper projetMapper;

    public ProjetServiceImpl(ProjetRepository projetRepository, ProjetMapper projetMapper) {
        this.projetRepository = projetRepository;
        this.projetMapper = projetMapper;
    }

    @Override
    public ProjetDTO creer(ProjetDTO projetDTO) {
        Projet projet = projetRepository.save(projetMapper.toEntity(projetDTO));
        return projetMapper.toDto(projet);
        
    }

    @Override
    public List<ProjetDTO> lire() {
        return projetRepository.findAll()
                .stream()
                .map(projetMapper::toDto)
                .toList();
    }

    @Override
    public ProjetDTO modifier(Long id, ProjetDTO projetDTO) {
        Projet projet = projetRepository.findById(id)
                .map(p -> {
                    p.setNom(projetDTO.getNom());
                    p.setDateDebut(projetDTO.getDateDebut());
                    p.setDateFin(projetDTO.getDateFin());
                    p.setDescription(projetDTO.getDescription());
                    p.setStatutProjet(projetDTO.getStatutProjet());
                    p.setBudget(projetDTO.getBudget());
                    p.setChefProjet(projetDTO.getChefProjet());
                    return projetRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Projet introuvable !"));
        return projetMapper.toDto(projet);
    }

    @Override
    public String supprimer(Long id) {
        projetRepository.deleteById(id);
        return "Projet supprimé !";
    }

    @Override
    public ProjetDTO lireUn(Long id) {
        Projet projet = projetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projet introuvable avec l'ID : " + id));
        return projetMapper.toDto(projet);
    }

}
