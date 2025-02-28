package com.ime.collabspace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.ime.collabspace.model.User;
import com.ime.collabspace.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService; // Utilisation de final pour l'injection de constructeur

    public UserController(UserService userService) { // Injection de constructeur
        this.userService = userService;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.creer(user);

    }

    @GetMapping("/read")
    public List<User> read() {
        return userService.lire();
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return userService.modifier(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return userService.supprimer(id);
    }

}
