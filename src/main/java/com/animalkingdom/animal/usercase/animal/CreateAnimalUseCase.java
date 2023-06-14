package com.animalkingdom.animal.usercase.animal;

import com.animalkingdom.animal.entity.gateway.AnimalGateway;
import com.animalkingdom.animal.entity.model.Animal;
import com.animalkingdom.animal.entity.model.Skill;
import com.animalkingdom.animal.entity.model.SpeciesAnimal;
import com.animalkingdom.animal.entity.model.enums.RarityAnimalEnum;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateAnimalUseCase {

    private final AnimalGateway animalGateway;

    public void execute(Input input) {

        var animal = Animal.builder()
                .name(input.name())
                .species(input.species())
                .rarity(input.rarity())
                .listSkill(input.listSkill())
                .build();

        animalGateway
                .create(animal);
    }

    public record Input(
            String name,
            SpeciesAnimal species,
            RarityAnimalEnum rarity,
            List<Skill> listSkill
    ) {
    }
}
