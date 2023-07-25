package com.animalkingdom.animal.resource.animal;

import com.animalkingdom.animal.usecase.animal.CreateAnimalUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class CreateAnimalResource {

    private final CreateAnimalUseCase useCase;

    @PostMapping(value = "/animals", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public Response postCreateAnimal(@ModelAttribute @Valid Request request) {

        useCase.execute(new CreateAnimalUseCase.Input(
                request.name(),
                request.description(),
                request.idSpecie(),
                request.idRarity(),
                request.fileImage()
        ));

        return new Response("Animal created successfully");
    }

    public record Request(
            @NotEmpty
            String name,
            String description,
            @NotNull
            Integer idSpecie,
            @NotNull
            Integer idRarity,
            @NotNull
            MultipartFile fileImage
    ) {
    }

    public record Response(
            String message
    ) {
    }
}
