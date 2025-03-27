package com.ime.collabspace.service.mapper;

import org.mapstruct.factory.Mappers;

import com.ime.collabspace.model.Materiel;
import com.ime.collabspace.service.dto.MaterielDTO;

public interface MaterielMapper extends EntityMapper<MaterielDTO, Materiel> {
    MaterielMapper INSTANCE = Mappers.getMapper(MaterielMapper.class);
    MaterielDTO toDto(Materiel materiel);
    Materiel toEntity(MaterielDTO dto);

}
