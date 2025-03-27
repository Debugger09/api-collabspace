package com.ime.collabspace.service.mapper;

import com.ime.collabspace.model.User;
import com.ime.collabspace.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends EntityMapper<UserDTO, User> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO toDto(User user);
    User toEntity(UserDTO dto);
}
