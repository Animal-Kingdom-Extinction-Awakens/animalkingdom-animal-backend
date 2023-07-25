package com.animalkingdom.animal.repository.animal.impl;

import com.animalkingdom.animal.entity.AnimalEntity;
import com.animalkingdom.animal.repository.animal.DeleteAnimalByIdRepository;
import com.animalkingdom.animal.repository.helper.JdbcRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:querys/animal/animal.properties")
public class DeleteAnimalByIdRepositoryImpl extends JdbcRepository<AnimalEntity> implements DeleteAnimalByIdRepository {

    @Value("${SPD.ANIMAL.WHERE.ID}")
    private String spdAnimalWhereId;

    @Override
    public void deleteAnimalById(Integer id) {

        delete(id, spdAnimalWhereId);
    }
}
