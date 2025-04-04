package com.ime.collabspace.service;

import java.util.List;

import com.ime.collabspace.service.dto.DepenseDTO;

public interface DepenseService {
    DepenseDTO creer(DepenseDTO depenseDTO);

    DepenseDTO modifier(Long id, DepenseDTO depenseDTO);

    String supprimer(Long id);

    DepenseDTO lireUn(Long id);

    List<DepenseDTO> lire();


}
