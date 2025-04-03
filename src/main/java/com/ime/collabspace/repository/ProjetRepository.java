package com.ime.collabspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ime.collabspace.model.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Long> {

}
