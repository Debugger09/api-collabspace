package com.ime.collabspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ime.collabspace.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
