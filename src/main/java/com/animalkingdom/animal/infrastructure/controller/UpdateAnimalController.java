package com.animalkingdom.animal.infrastructure.controller;

import com.animalkingdom.animal.usercase.UpdateAnimalUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UpdateAnimalController {

    private final UpdateAnimalUseCase userCase;

    @PutMapping("/animals/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void putUpdateAnimal(@PathVariable String id, @RequestBody @Valid Request request) {

        userCase.execute(new UpdateAnimalUseCase.Input(id, request.name()));
    }

    public record Request(
            @NotEmpty
            String name
    ) {
    }
}
