package com.animalkingdom.animal.infrastructure.controller;

import com.animalkingdom.animal.usercase.DeleteAnimalUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DeleteAnimalController {

    private final DeleteAnimalUseCase userCase;

    @DeleteMapping("/animals/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void putUpdateAnimal(@PathVariable String id) {

        userCase.execute(new DeleteAnimalUseCase.Input(id));
    }
}