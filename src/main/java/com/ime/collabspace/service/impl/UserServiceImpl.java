package com.ime.collabspace.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.ime.collabspace.service.dto.UserDTO;
import com.ime.collabspace.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

import com.ime.collabspace.model.User;
import com.ime.collabspace.repository.UserRepository;
import com.ime.collabspace.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO creer(UserDTO userDTO) {
           User  user=userRepository.save(UserMapper.INSTANCE.toEntity(userDTO));
        return UserMapper.INSTANCE.toDto(user);
    }

    @Override
    public List<UserDTO> lire() {

        return userRepository.findAll().stream().map(UserMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDTO modifier(Long id, UserDTO userDTO) {
      User user=  userRepository.findById(id)
                .map(p -> {
                    p.setEmail(userDTO.getEmail());
                    p.setNom(userDTO.getNom());
                    p.setLogin(userDTO.getLogin());
                    p.setPassWord(userDTO.getPassWord());
                    p.setStatus(userDTO.getStatus());
                    p.setRole(userDTO.getRole());
                    return userRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Utiisateur introuvable !"));

        return UserMapper.INSTANCE.toDto(user);
    }

    @Override
    public String supprimer(Long id) {
        userRepository.deleteById(id);
        return "Utilisateur supprimé !";
    }

    @Override
    public UserDTO lireUn(Long id) {
        User user = userRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("Utilisateur introuvable avec l'ID : " + id));
        return UserMapper.INSTANCE.toDto(user);
}

}
