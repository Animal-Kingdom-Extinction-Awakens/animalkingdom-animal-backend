package com.animalkingdom.animal.infrastructure.controller;

import com.animalkingdom.animal.usercase.CreateAnimalUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
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

        userCase.execute(new CreateAnimalUseCase.Input(request.name()));
    }

    public record Request(
            @NotEmpty
            String name
    ) {
    }
}
