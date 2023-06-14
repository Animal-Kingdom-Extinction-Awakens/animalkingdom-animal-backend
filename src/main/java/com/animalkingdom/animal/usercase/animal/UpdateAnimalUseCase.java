package com.animalkingdom.animal.usercase.animal;

import com.animalkingdom.animal.entity.gateway.AnimalGateway;
import com.animalkingdom.animal.entity.model.Animal;
import com.animalkingdom.animal.entity.model.Skill;
import com.animalkingdom.animal.entity.model.SpeciesAnimal;
import com.animalkingdom.animal.entity.model.enums.RarityAnimalEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
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
                .species(input.species())
                .rarity(input.rarity())
                .listSkill(input.listSkill())
                .rarity(RarityAnimalEnum.LEGENDARY)
                .build();

        animalGateway
                .update(animal);
    }

    public record Input(
            String id,
            String name,
            SpeciesAnimal species,
            RarityAnimalEnum rarity,
            List<Skill> listSkill
    ) {
    }
}
