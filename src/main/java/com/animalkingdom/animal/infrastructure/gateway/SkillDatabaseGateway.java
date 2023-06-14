package com.animalkingdom.animal.infrastructure.gateway;

import com.animalkingdom.animal.entity.gateway.AnimalGateway;
import com.animalkingdom.animal.entity.gateway.SkillGateway;
import com.animalkingdom.animal.entity.model.Animal;
import com.animalkingdom.animal.entity.model.Skill;
import com.animalkingdom.animal.infrastructure.config.db.document.mapper.AnimalDocumentMapper;
import com.animalkingdom.animal.infrastructure.config.db.document.mapper.SkillDocumentMapper;
import com.animalkingdom.animal.infrastructure.config.db.repository.AnimalRepository;
import com.animalkingdom.animal.infrastructure.config.db.repository.SkillRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SkillDatabaseGateway implements SkillGateway {

    private final SkillRepository repository;

    @Override
    public void create(Skill skill) {

        repository
                .insert(SkillDocumentMapper.toDocument(skill));
    }

    @Override
    public void update(Skill skill) {

        repository
                .save(SkillDocumentMapper.toDocument(skill));
    }

    @Override
    public void delete(String id) {

        repository
                .deleteById(id);
    }

    @Override
    public Optional<Skill> findById(String id) {

        return repository
                .findById(id)
                .flatMap(SkillDocumentMapper::toModel);
    }

    @Override
    public List<Skill> findAll() {

        return repository
                .findAll()
                .stream()
                .map(SkillDocumentMapper::toModel)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
