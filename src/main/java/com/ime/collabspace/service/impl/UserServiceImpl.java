package com.ime.collabspace.service.impl;

import java.util.List;

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
    public User creer(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> lire() {
        return userRepository.findAll();
    }

    @Override
    public User modifier(Long id, User user) {
        return userRepository.findById(id)
                .map(p -> {
                    p.setEmail(user.getEmail());
                    p.setNom(user.getNom());
                    p.setLogin(user.getLogin());
                    p.setPassWord(user.getPassWord());
                    p.setStatus(user.getStatus());
                    p.setRole(user.getRole());
                    return userRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Utiisateur introuvable !"));
    }

    @Override
    public String supprimer(Long id) {
        userRepository.deleteById(id);
        return "Utilisateur supprimé !";
    }

}
