package com.animalkingdom.animal.infrastructure.controller.skill;

import com.animalkingdom.animal.entity.model.Skill;
import com.animalkingdom.animal.usercase.skill.FindByIdSkillUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FindByIdSkillController {

    private final FindByIdSkillUseCase userCase;

    @GetMapping("/skills/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response getFindByIdSkill(@PathVariable String id) {

        return new Response(userCase.execute(new FindByIdSkillUseCase.Input(id)));
    }

    public record Response(
            Skill skill
    ) {
    }
}
