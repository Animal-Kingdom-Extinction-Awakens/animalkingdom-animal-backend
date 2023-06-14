package com.animalkingdom.animal.entity.gateway;

import com.animalkingdom.animal.entity.model.Skill;
import java.util.List;
import java.util.Optional;

public interface SkillGateway {

    void create(Skill skill);

    void update(Skill skill);

    void delete(String id);

    Optional<Skill> findById(String id);

    List<Skill> findAll();
}
