package com.animalkingdom.animal.resource.animal;

import com.animalkingdom.animal.usecase.animal.DeleteAnimalByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteAnimalByIdResource {

    private final DeleteAnimalByIdUseCase useCase;

    @DeleteMapping("/animals/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response deleteAnimalById(@PathVariable Integer id) {

        this.useCase.execute(id);

        return new Response("Animal deleted successfully");
    }

    public record Response(
            String message
    ) {
    }
}
