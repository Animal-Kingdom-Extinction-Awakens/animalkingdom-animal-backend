package com.animalkingdom.animal.resource.specie;

import com.animalkingdom.animal.dto.SpecieDto;
import com.animalkingdom.animal.usecase.specie.FindAllSpecieUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FindAllSpecieResource {

    private final FindAllSpecieUseCase useCase;

    @GetMapping("/species")
    @ResponseStatus(HttpStatus.OK)
    public Response getFindAllSpecie() {

        return new Response(this.useCase.execute());
    }

    public record Response(
            List<SpecieDto> listSpecie
    ) {
    }
}
