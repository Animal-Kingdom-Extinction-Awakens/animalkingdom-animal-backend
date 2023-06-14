package com.animalkingdom.animal.usercase.skill;

import com.animalkingdom.animal.entity.gateway.SkillGateway;
import com.animalkingdom.animal.entity.model.Skill;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateSkillUseCase {

    private final SkillGateway gateway;

    public void execute(Input input) {

        var skill = Skill.builder()
                .name(input.name())
                .description(input.description())
                .build();

        gateway
                .create(skill);
    }

    public record Input(
            String name,
            String description
    ) {
    }
}
