package com.animalkingdom.animal.resource.specie;

import com.animalkingdom.animal.usecase.specie.CreateSpecieUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateSpecieResource {

    private final CreateSpecieUseCase useCase;

    @PostMapping(value = "/species")
    @ResponseStatus(HttpStatus.CREATED)
    public void postCreateSpecie(@ModelAttribute @Valid Request request) {

        useCase.execute(new CreateSpecieUseCase.Input(
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
