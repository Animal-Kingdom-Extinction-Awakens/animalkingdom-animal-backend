package com.animalkingdom.animal.infrastructure.gateway;

import com.animalkingdom.animal.entity.gateway.AnimalGateway;
import com.animalkingdom.animal.entity.model.Animal;
import com.animalkingdom.animal.infrastructure.config.db.document.mapper.AnimalDocumentMapper;
import com.animalkingdom.animal.infrastructure.config.db.repository.AnimalRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AnimalDatabaseGateway implements AnimalGateway {

    private final AnimalRepository animalRepository;

    @Override
    public void create(Animal animal) {

        animalRepository
                .insert(AnimalDocumentMapper.toDocument(animal));
    }

    @Override
    public void update(Animal animal) {

        animalRepository
                .save(AnimalDocumentMapper.toDocument(animal));
    }

    @Override
    public void delete(String id) {

        animalRepository
                .deleteById(id);
    }

    @Override
    public Optional<Animal> findById(String id) {

        return animalRepository
                .findById(id)
                .flatMap(AnimalDocumentMapper::toModel);
    }

    @Override
    public List<Animal> findAll() {

        return animalRepository
                .findAll()
                .stream()
                .map(AnimalDocumentMapper::toModel)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
