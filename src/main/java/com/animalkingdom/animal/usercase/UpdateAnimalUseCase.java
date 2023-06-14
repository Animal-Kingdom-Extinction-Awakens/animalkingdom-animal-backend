package com.animalkingdom.animal.usercase;

import com.animalkingdom.animal.entity.gateway.AnimalGateway;
import com.animalkingdom.animal.entity.model.Animal;
import com.animalkingdom.animal.entity.model.enums.RarityAnimalEnum;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateAnimalUseCase {

    private final AnimalGateway animalGateway;

    public void execute(Input input) {

        var animal = Animal.builder()
                .id(input.id())
                .name(input.name())
                .rarity(RarityAnimalEnum.LEGENDARY)
                .build();

        animalGateway
                .update(animal);
    }

    public record Input(
            String id,
            String name
    ) {
    }
}
