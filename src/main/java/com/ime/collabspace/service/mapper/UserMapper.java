package com.ime.collabspace.service.mapper;

import com.ime.collabspace.model.User;
import com.ime.collabspace.service.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") // Ajout de l'annotation @Mapper
public interface UserMapper {

    UserDTO toDto(User user);
    User toEntity(UserDTO dto);
}