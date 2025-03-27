package com.ime.collabspace.service;

import java.util.List;

import com.ime.collabspace.model.User;
import com.ime.collabspace.service.dto.UserDTO;

public interface UserService {
    UserDTO creer(UserDTO userDTO);

    List<UserDTO> lire();

    UserDTO modifier(Long id, UserDTO userDTO);

    String supprimer(Long id);

}
