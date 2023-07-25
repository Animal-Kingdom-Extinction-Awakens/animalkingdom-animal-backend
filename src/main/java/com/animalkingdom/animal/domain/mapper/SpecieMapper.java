package com.animalkingdom.animal.domain.mapper;

import com.animalkingdom.animal.domain.Specie;
import com.animalkingdom.animal.entity.SpecieEntity;

public class SpecieMapper {

    private SpecieMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static SpecieEntity toEntity(Specie specie) {

        return SpecieEntity.builder()
                .id(specie.getId())
                .name(specie.getName())
                .description(specie.getDescription())
                .build();
    }
}
