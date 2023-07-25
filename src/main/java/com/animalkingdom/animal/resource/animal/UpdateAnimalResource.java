package com.animalkingdom.animal.resource.animal;

import com.animalkingdom.animal.usecase.animal.UpdateAnimalUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class UpdateAnimalResource {

    private final UpdateAnimalUseCase useCase;

    @PutMapping(value = "/animals/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public Response putUpdateAnimal(@ModelAttribute @Valid Request request, @PathVariable Integer id) {

        useCase.execute(new UpdateAnimalUseCase.Input(
                id,
                request.name(),
                request.description(),
                request.idSpecie(),
                request.idRarity(),
                request.fileImage()
        ));

        return new Response("Animal updated successfully");
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
