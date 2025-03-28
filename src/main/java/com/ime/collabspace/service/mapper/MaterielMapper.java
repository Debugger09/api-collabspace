package com.ime.collabspace.service.mapper;

import com.ime.collabspace.model.Materiel;
import com.ime.collabspace.service.dto.MaterielDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaterielMapper {
    MaterielDTO toDto(Materiel materiel);
    Materiel toEntity(MaterielDTO materielDTO);
}