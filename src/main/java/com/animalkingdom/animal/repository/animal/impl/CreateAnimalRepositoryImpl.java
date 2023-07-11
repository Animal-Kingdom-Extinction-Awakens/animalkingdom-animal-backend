package com.animalkingdom.animal.repository.animal.impl;

import com.animalkingdom.animal.domain.Animal;
import com.animalkingdom.animal.domain.mapper.AnimalMapper;
import com.animalkingdom.animal.entity.AnimalEntity;
import com.animalkingdom.animal.repository.animal.CreateAnimalRepository;
import com.animalkingdom.animal.repository.helper.JdbcRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:querys/animal/animal.properties")
public class CreateAnimalRepositoryImpl extends JdbcRepository<AnimalEntity> implements CreateAnimalRepository {

    @Value("${SPI.ANIMAL}")
    private String spiAnimal;

    @Override
    public void create(Animal animal) {

        save(AnimalMapper.toEntity(animal), spiAnimal);
    }
}
