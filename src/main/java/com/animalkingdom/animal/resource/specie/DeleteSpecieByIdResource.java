package com.animalkingdom.animal.resource.specie;

import com.animalkingdom.animal.usecase.specie.DeleteSpecieByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteSpecieByIdResource {

    private final DeleteSpecieByIdUseCase useCase;

    @DeleteMapping("/species/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAnimalById(@PathVariable Integer id) {

        this.useCase.execute(id);
    }

}
