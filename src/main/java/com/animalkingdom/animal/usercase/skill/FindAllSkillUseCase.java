package com.animalkingdom.animal.usercase.skill;

import com.animalkingdom.animal.entity.gateway.SkillGateway;
import com.animalkingdom.animal.entity.model.Skill;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindAllSkillUseCase {

    private final SkillGateway gateway;

    public List<Skill> execute() {

        return gateway
                .findAll();
    }
}
