package com.ime.collabspace.service.mapper;

import org.mapstruct.Mapper;

import com.ime.collabspace.model.Projet;
import com.ime.collabspace.service.dto.ProjetDTO;

@Mapper(componentModel = "spring")
public interface ProjetMapper {
    ProjetDTO toDto(Projet projet);
    Projet toEntity(ProjetDTO dto);

}
