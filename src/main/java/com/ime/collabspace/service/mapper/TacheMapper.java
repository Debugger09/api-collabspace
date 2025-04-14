package com.ime.collabspace.service.mapper;

import org.mapstruct.Mapper;

import com.ime.collabspace.model.Tache;
import com.ime.collabspace.service.dto.TacheDTO;

@Mapper(componentModel = "spring")
public interface TacheMapper {
    TacheDTO toDto(Tache tache);
    Tache toEntity(TacheDTO dto);

}
