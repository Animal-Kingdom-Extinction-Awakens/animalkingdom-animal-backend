package com.animalkingdom.animal.repository.specie.impl;

import com.animalkingdom.animal.entity.SpecieEntity;
import com.animalkingdom.animal.repository.helper.JdbcRepository;
import com.animalkingdom.animal.repository.specie.DeleteSpecieByIdRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:querys/specie/specie.properties")
public class DeleteSpecieByIdRepositoryImpl extends JdbcRepository<SpecieEntity> implements DeleteSpecieByIdRepository {

    @Value("${SPD.SPECIE.WHERE.ID}")
    private String spdAnimalWhereId;

    @Override
    public void delete(Integer id) {

        delete(id, spdAnimalWhereId);
    }
}
