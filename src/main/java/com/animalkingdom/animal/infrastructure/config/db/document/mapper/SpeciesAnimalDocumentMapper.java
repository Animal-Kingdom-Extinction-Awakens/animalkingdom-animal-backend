package com.animalkingdom.animal.infrastructure.config.db.document.mapper;

import com.animalkingdom.animal.entity.model.SpeciesAnimal;
import com.animalkingdom.animal.infrastructure.config.db.document.SpeciesAnimalDocument;

public class SpeciesAnimalDocumentMapper {

    private SpeciesAnimalDocumentMapper() {

        throw new IllegalStateException("Utility class");
    }

    public static SpeciesAnimalDocument toDocument(SpeciesAnimal speciesAnimal) {

        return SpeciesAnimalDocument.builder()
                .id(speciesAnimal.getId())
                .name(speciesAnimal.getName())
                .description(speciesAnimal.getDescription())
                .build();
    }

    public static SpeciesAnimal toModel(SpeciesAnimalDocument speciesAnimalDocument) {

        return SpeciesAnimal.builder()
                .id(speciesAnimalDocument.getId())
                .name(speciesAnimalDocument.getName())
                .description(speciesAnimalDocument.getDescription())
                .build();
    }
}
