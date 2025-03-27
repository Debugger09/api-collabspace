package com.ime.collabspace.controller;

import java.util.List;

import com.ime.collabspace.service.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import com.ime.collabspace.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService; // Utilisation de final pour l'injection de constructeur

    public UserController(UserService userService) { // Injection de constructeur
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserDTO create(@RequestBody UserDTO userDTO) {
        return userService.creer(userDTO);

    }

    @GetMapping("/read")
    public List<UserDTO> read() {
        return userService.lire();
    }

    @PutMapping("/update/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.modifier(id, userDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return userService.supprimer(id);
    }

    @GetMapping("/readOne/{id}")
    public UserDTO readOne(@PathVariable Long id) {
        return userService.lireUn(id);
    }

}
