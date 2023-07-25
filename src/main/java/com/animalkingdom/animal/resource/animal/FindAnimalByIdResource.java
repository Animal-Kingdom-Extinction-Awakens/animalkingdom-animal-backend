package com.animalkingdom.animal.resource.animal;

import com.animalkingdom.animal.dto.AnimalDetailDto;
import com.animalkingdom.animal.usecase.animal.FindAnimalByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FindAnimalByIdResource {

    private final FindAnimalByIdUseCase useCase;

    @GetMapping("/animals/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response getFindAnimalById(@PathVariable Integer id) {

        return new Response(this.useCase.execute(id));
    }

    public record Response(
            AnimalDetailDto animal
    ) {
    }

}
