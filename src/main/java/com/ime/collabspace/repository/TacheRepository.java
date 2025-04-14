package com.ime.collabspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ime.collabspace.model.Tache;

public interface TacheRepository extends JpaRepository<Tache, Long> {
   
}
