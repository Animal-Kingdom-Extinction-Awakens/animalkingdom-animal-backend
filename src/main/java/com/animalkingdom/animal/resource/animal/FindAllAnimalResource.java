package com.animalkingdom.animal.resource.animal;

import com.animalkingdom.animal.dto.AnimalDto;
import com.animalkingdom.animal.usecase.animal.FindAllAnimalUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FindAllAnimalResource {

    private final FindAllAnimalUseCase useCase;

    @GetMapping("/animals")
    @ResponseStatus(HttpStatus.OK)
    public Response getFindAllAnimal() {

        return new Response(this.useCase.execute());
    }

    public record Response(
            List<AnimalDto> listAnimal
    ) {
    }
}
