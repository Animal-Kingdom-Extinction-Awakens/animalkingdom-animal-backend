package com.animalkingdom.animal.usercase.skill;

import com.animalkingdom.animal.entity.gateway.SkillGateway;
import com.animalkingdom.animal.entity.model.Skill;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteSkillUseCase {

    private final SkillGateway gateway;

    public void execute(Input input) {

        gateway
                .delete(input.id());
    }

    public record Input(
            String id
    ) {
    }
}
