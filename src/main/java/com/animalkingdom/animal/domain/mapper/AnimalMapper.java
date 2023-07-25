package com.animalkingdom.animal.domain.mapper;

import com.animalkingdom.animal.domain.Animal;
import com.animalkingdom.animal.domain.Rarity;
import com.animalkingdom.animal.domain.Specie;
import com.animalkingdom.animal.entity.AnimalEntity;

public class AnimalMapper {

    private AnimalMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static AnimalEntity toEntity(Animal animal) {

        return AnimalEntity.builder()
                .id(animal.getId())
                .name(animal.getName())
                .description(animal.getDescription())
                .idSpecie(animal.getSpecie().getId())
                .idRarity(animal.getRarity().getId())
                .key(animal.getKey())
                .build();
    }

    public static Animal toModel(AnimalEntity animalEntity) {

        return Animal.builder()
                .id(animalEntity.getId())
                .name(animalEntity.getName())
                .description(animalEntity.getDescription())
                .specie(Specie.builder().id(animalEntity.getIdSpecie()).build())
                .rarity(Rarity.builder().id(animalEntity.getIdRarity()).build())
                .key(animalEntity.getKey())
                .build();
    }
}
