package com.animalkingdom.animal.usercase.animal;

import com.animalkingdom.animal.entity.gateway.AnimalGateway;
import com.animalkingdom.animal.entity.model.Animal;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindAllAnimalUserCase {

    private final AnimalGateway animalGateway;

    public List<Animal> execute() {

        return animalGateway
                .findAll();
    }
}
