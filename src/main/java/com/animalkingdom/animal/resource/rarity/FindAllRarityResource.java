package com.animalkingdom.animal.resource.rarity;

import com.animalkingdom.animal.dto.RarityDto;
import com.animalkingdom.animal.usecase.rarity.FindAllRarityUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FindAllRarityResource {

    private final FindAllRarityUseCase useCase;

    @GetMapping("/rarities")
    @ResponseStatus(HttpStatus.OK)
    public Response getFindAllRarity() {

        return new Response(this.useCase.execute());
    }

    public record Response(
            List<RarityDto> listRarity
    ) {
    }
}
