package com.animalkingdom.animal.infrastructure.controller.skill;

import com.animalkingdom.animal.usercase.skill.CreateSkillUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CreateSkillController {

    private final CreateSkillUseCase userCase;

    @PostMapping("/skills")
    @ResponseStatus(HttpStatus.CREATED)
    public void postCreateSkill(@RequestBody @Valid Request request) {

        userCase.execute(new CreateSkillUseCase.Input(
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
