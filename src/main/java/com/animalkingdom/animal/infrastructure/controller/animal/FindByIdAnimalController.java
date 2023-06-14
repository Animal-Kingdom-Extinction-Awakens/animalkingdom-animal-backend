package com.animalkingdom.animal.infrastructure.controller.animal;

import com.animalkingdom.animal.entity.model.Animal;
import com.animalkingdom.animal.usercase.animal.FindByIdAnimalUserCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FindByIdAnimalController {

    private final FindByIdAnimalUserCase userCase;

    @GetMapping("/animals/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response getFindByIdAnimal(@PathVariable String id) {

        return new Response(
                this.userCase.execute(new FindByIdAnimalUserCase.Input(id))
        );
    }

    public record Response(
            Animal animal
    ) {
    }
}
