package com.ime.collabspace.service;

import java.util.List;

import com.ime.collabspace.model.User;

public interface UserService {
    User creer(User user);

    List<User> lire();

    User modifier(Long id, User user);

    String supprimer(Long id);

}
