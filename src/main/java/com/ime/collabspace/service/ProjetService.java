package com.ime.collabspace.service;

import java.util.List;

import com.ime.collabspace.service.dto.ProjetDTO;

public interface ProjetService {
    ProjetDTO creer(ProjetDTO projetDTO);

    List<ProjetDTO> lire();
    
    ProjetDTO modifier(Long id, ProjetDTO projetDTO);
    
    String supprimer(Long id);
   
    ProjetDTO lireUn(Long id);

}
