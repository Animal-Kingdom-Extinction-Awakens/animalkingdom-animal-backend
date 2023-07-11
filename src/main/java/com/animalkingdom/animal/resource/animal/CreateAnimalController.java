package com.animalkingdom.animal.resource.animal;

import com.animalkingdom.animal.usercase.animal.CreateAnimalUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateAnimalController {

    private final CreateAnimalUseCase userCase;

    @PostMapping("/animals")
    @ResponseStatus(HttpStatus.CREATED)
    public void postCreateAnimal(@RequestBody @Valid Request request) {

        userCase.execute(new CreateAnimalUseCase.Input(
                request.name(),
                request.description(),
                request.idSpecie(),
                request.idRarity()
        ));
    }

    public record Request(
            @NotEmpty
            String name,
            String description,
            @NotNull
            Integer idSpecie,
            @NotNull
            Integer idRarity
    ) {
    }
}
