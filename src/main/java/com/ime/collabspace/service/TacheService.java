package com.ime.collabspace.service;

import java.util.List;

import com.ime.collabspace.service.dto.TacheDTO;

public interface TacheService {
    TacheDTO creer(TacheDTO tacheDTO);
    TacheDTO modifier(Long id, TacheDTO tacheDTO);
    String supprimer(Long id);
    TacheDTO lireUn(Long id);
    List<TacheDTO> lire();

}
