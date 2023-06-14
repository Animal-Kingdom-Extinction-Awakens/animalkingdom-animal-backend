package com.animalkingdom.animal.usercase;

import com.animalkingdom.animal.entity.gateway.AnimalGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteAnimalUseCase {

    private final AnimalGateway animalGateway;

    public void execute(Input input) {

        animalGateway
                .delete(input.id());
    }

    public record Input(
            String id
    ) {
    }
}
