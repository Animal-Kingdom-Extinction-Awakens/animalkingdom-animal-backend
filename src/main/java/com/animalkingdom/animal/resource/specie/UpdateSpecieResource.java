package com.animalkingdom.animal.resource.specie;

import com.animalkingdom.animal.usecase.specie.UpdateSpecieUseCase;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateSpecieResource {

    private final UpdateSpecieUseCase useCase;

    @PutMapping(value = "/species/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void putUpdateSpecie(@PathVariable Integer id, @RequestBody Request request) {

        useCase.execute(new UpdateSpecieUseCase.Input(
                id,
                request.name(),
                request.description()
        ));
    }

    public record Request(
            @NotEmpty
            String name,
            String description
    ) {
    }
}
