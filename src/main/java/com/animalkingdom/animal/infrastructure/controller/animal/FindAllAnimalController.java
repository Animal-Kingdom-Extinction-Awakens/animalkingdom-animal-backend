package com.animalkingdom.animal.infrastructure.controller.animal;

import com.animalkingdom.animal.entity.model.Animal;
import com.animalkingdom.animal.usercase.animal.FindAllAnimalUserCase;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FindAllAnimalController {

    private final FindAllAnimalUserCase userCase;

    @GetMapping("/animals")
    @ResponseStatus(HttpStatus.OK)
    public Response getFindAllAnimal() {

        return new Response(
                this.userCase.execute()
        );
    }

    public record Response(
            List<Animal> listAnimal
    ) {
    }
}