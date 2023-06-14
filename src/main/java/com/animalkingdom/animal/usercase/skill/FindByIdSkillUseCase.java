package com.animalkingdom.animal.usercase.skill;

import com.animalkingdom.animal.entity.gateway.SkillGateway;
import com.animalkingdom.animal.entity.model.Skill;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindByIdSkillUseCase {

    private final SkillGateway gateway;

    public Skill execute(Input input) {

        return gateway
                .findById(input.id())
                .orElseThrow(() -> new RuntimeException("Skill not found"));
    }

    public record Input(
            String id
    ) {
    }
}
