package com.ime.collabspace.service.mapper;

import org.mapstruct.Mapper;

import com.ime.collabspace.model.Depense;
import com.ime.collabspace.service.dto.DepenseDTO;

@Mapper(componentModel = "spring")
public interface DepenseMapper {
    DepenseDTO toDto(Depense depense);
    Depense toEntity(DepenseDTO dto);

}
