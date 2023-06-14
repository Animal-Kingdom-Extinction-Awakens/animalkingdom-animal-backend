package com.animalkingdom.animal.infrastructure.controller.skill;

import com.animalkingdom.animal.usercase.skill.UpdateSkillUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UpdateSkillController {

    private final UpdateSkillUseCase userCase;

    @PutMapping("/skills/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void putUpdateAnimal(@PathVariable String id, @RequestBody @Valid Request request) {

        userCase.execute(new UpdateSkillUseCase.Input(
                id,
                request.name(),
                request.description()
        ));
    }

    public record Request(
            @NotEmpty
            String name,
            @NotEmpty
            String description
    ) {
    }
}
