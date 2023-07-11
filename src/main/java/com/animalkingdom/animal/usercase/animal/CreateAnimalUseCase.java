package com.animalkingdom.animal.usercase.animal;

import com.animalkingdom.animal.domain.Animal;
import com.animalkingdom.animal.domain.Rarity;
import com.animalkingdom.animal.domain.Specie;
import com.animalkingdom.animal.repository.animal.CreateAnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAnimalUseCase {

    private final CreateAnimalRepository repository;

    public void execute(Input input) {

        var animal = Animal.builder()
                .name(input.name())
                .description(input.description())
                .specie(Specie.builder().id(input.idSpecie).build())
                .rarity(Rarity.builder().id(input.idRarity).build())
                .build();

        repository.create(animal);
    }

    public record Input(
            String name,
            String description,
            Integer idSpecie,
            Integer idRarity
    ) {
    }
}
