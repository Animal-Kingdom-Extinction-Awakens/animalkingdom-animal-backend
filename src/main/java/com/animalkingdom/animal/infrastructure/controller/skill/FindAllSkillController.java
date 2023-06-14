package com.animalkingdom.animal.infrastructure.controller.skill;

import com.animalkingdom.animal.entity.model.Skill;
import com.animalkingdom.animal.usercase.skill.FindAllSkillUseCase;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FindAllSkillController {

    private final FindAllSkillUseCase userCase;

    @GetMapping("/skills")
    @ResponseStatus(HttpStatus.OK)
    public Response getFindAllSkill() {

        return new Response(userCase.execute());
    }

    public record Response(
            List<Skill> listSkill
    ) {
    }
}
