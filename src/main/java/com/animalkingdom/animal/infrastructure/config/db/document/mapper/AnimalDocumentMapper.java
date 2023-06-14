package com.animalkingdom.animal.infrastructure.config.db.document.mapper;

import com.animalkingdom.animal.entity.model.Animal;
import com.animalkingdom.animal.entity.model.enums.RarityAnimalEnum;
import com.animalkingdom.animal.infrastructure.config.db.document.AnimalDocument;
import java.util.Optional;

public class AnimalDocumentMapper {

    private AnimalDocumentMapper() {

        throw new IllegalStateException("Utility class");
    }

    public static AnimalDocument toDocument(Animal animal) {

        return AnimalDocument.builder()
                .id(animal.getId())
                .name(animal.getName())
                .species(Optional.ofNullable(animal.getSpecies())
                        .map(SpeciesAnimalDocumentMapper::toDocument)
                        .orElse(null))
                .rarity(animal.getRarity().name())
                .listSkill(Optional.ofNullable(animal.getListSkill())
                        .map(SkillDocumentMapper::toDocument)
                        .orElse(null))
                .build();
    }

    public static Optional<Animal> toModel(AnimalDocument animalDocument) {

        return Optional.ofNullable(animalDocument)
                .map(animal -> Animal.builder()
                        .id(animal.getId())
                        .name(animal.getName())
                        .species(Optional.ofNullable(animal.getSpecies())
                                .map(SpeciesAnimalDocumentMapper::toModel)
                                .orElse(null))
                        .rarity(RarityAnimalEnum.valueOf(animal.getRarity()))
                        .listSkill(Optional.ofNullable(animal.getListSkill())
                                .map(SkillDocumentMapper::toModel)
                                .orElse(null))
                        .build());
    }
}
