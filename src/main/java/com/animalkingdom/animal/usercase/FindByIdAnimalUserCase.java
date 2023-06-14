package com.animalkingdom.animal.usercase;

import com.animalkingdom.animal.entity.gateway.AnimalGateway;
import com.animalkingdom.animal.entity.model.Animal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindByIdAnimalUserCase {

    private final AnimalGateway animalGateway;

    public Animal execute(Input input) {

        return animalGateway
                .findById(input.id())
                .orElseThrow(() -> new RuntimeException("Animal not found"));
    }

    public record Input(
            String id
    ) {
    }
}
