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
    private final UserMapper userMapper; // Injecter UserMapper

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper; // Initialiser UserMapper
    }

    @Override
    public UserDTO creer(UserDTO userDTO) {
        User user = userRepository.save(userMapper.toEntity(userDTO)); // Utiliser userMapper
        return userMapper.toDto(user); // Utiliser userMapper
    }

    @Override
    public List<UserDTO> lire() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList()); // Utiliser userMapper
    }

    @Override
    public UserDTO modifier(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .map(p -> {
                    p.setEmail(userDTO.getEmail());
                    p.setNom(userDTO.getNom());
                    p.setLogin(userDTO.getLogin());
                    p.setPassWord(userDTO.getPassWord());
                    p.setStatus(userDTO.getStatus());
                    p.setRole(userDTO.getRole());
                    return userRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Utilisateur introuvable !"));

        return userMapper.toDto(user); // Utiliser userMapper
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
        return userMapper.toDto(user); // Utiliser userMapper
    }
}