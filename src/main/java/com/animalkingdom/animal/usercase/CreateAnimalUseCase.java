package com.animalkingdom.animal.usercase;

import com.animalkingdom.animal.entity.gateway.AnimalGateway;
import com.animalkingdom.animal.entity.model.Animal;
import com.animalkingdom.animal.entity.model.enums.RarityAnimalEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateAnimalUseCase {

    private final AnimalGateway animalGateway;

    public void execute(Input input) {

        var animal = Animal.builder()
                .name(input.name())
                .rarity(RarityAnimalEnum.COMMON)
                .build();

        animalGateway
                .create(animal);
    }

    public record Input(
            String name
    ) {
    }
}
