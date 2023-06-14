package com.animalkingdom.animal.infrastructure.controller.animal;

import com.animalkingdom.animal.entity.model.Skill;
import com.animalkingdom.animal.entity.model.SpeciesAnimal;
import com.animalkingdom.animal.entity.model.enums.RarityAnimalEnum;
import com.animalkingdom.animal.usercase.animal.CreateAnimalUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CreateAnimalController {

    private final CreateAnimalUseCase userCase;

    @PostMapping("/animals")
    @ResponseStatus(HttpStatus.CREATED)
    public void postCreateAnimal(@RequestBody @Valid Request request) {

        userCase.execute(new CreateAnimalUseCase.Input(
                request.name(),
                request.species(),
                request.rarity(),
                request.listSkill()
        ));
    }

    public record Request(
            @NotEmpty
            String name,
            SpeciesAnimal species,
            @NotNull
            RarityAnimalEnum rarity,
            List<Skill> listSkill
    ) {
    }
}
